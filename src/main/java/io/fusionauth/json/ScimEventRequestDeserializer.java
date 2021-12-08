/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.json;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.fusionauth.domain.event.BaseEvent;
import io.fusionauth.domain.event.BaseScimResource;
import io.fusionauth.domain.event.EventType;
import io.fusionauth.domain.event.ScimEventRequest;

/**
 * Custom JSON deserializer for BaseScimEventRequest.
 *
 * @author Brett Pontarelli
 */
public class ScimEventRequestDeserializer extends StdDeserializer<ScimEventRequest> {
  public ScimEventRequestDeserializer() {
    super(ScimEventRequest.class);
  }

  @Override
  public ScimEventRequest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    return deserialize(p, ctxt, new ScimEventRequest());
  }

  @Override
  public ScimEventRequest deserialize(JsonParser p, DeserializationContext ctxt, ScimEventRequest req) throws IOException {
    JsonNode eventNode = p.getCodec().readTree(p);
    String type = eventNode.at("/meta/resourceType").asText();
    // Assume all our events have a name like Scim{type}EventRequest
    String className = BaseScimResource.class.getPackage().getName() + ".Scim" + type + "Resource";

    try {
      req.resource = (BaseScimResource) Class.forName(className).getConstructor().newInstance();
    } catch (Exception e) {
      throw new IllegalStateException("Unexpected type [" + type + "]. This is a FusionAuth bug, could not instantiate class [" + className + "].");
    }

    ((ObjectMapper) p.getCodec()).readerForUpdating(req.resource).readValue(eventNode);
    return req;
  }

  // [brettp]TODO: Do we want to get fancy here and check the incoming type against some enum?
  private EventType extractType(DeserializationContext ctxt, JsonParser p, JsonNode eventNode) throws IOException {
    JsonNode node = eventNode.at("/meta/resourceType");
    String type = node.asText();

    EventType eventType = EventType.forValue(type);
    if (eventType == null) {
      // This does actually throw an exception, but this is how Jackson rolls.
      String sorted = Arrays.stream(EventType.values()).map(Enum::name).sorted().collect(Collectors.joining(", "));
      return (EventType) ctxt.handleUnexpectedToken(BaseEvent.class, node.asToken(), p, "Expected the type field to be one of [" + sorted + "], but found [" + node.asText() + "]");
    }

    return eventType;
  }
}
