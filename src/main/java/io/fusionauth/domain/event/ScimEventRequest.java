/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.event;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.json.ScimEventRequestDeserializer;

/**
 * Container for the SCIM event information. This is the JSON that is sent from FusionAuth to SCIM Servers.
 *
 * @author Brett Pontarelli
 */
@JsonDeserialize(using = ScimEventRequestDeserializer.class)
public class ScimEventRequest {
  public BaseScimResource resource;

  @JacksonConstructor
  public ScimEventRequest() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScimEventRequest that = (ScimEventRequest) o;
    return Objects.equals(resource, that.resource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resource);
  }

  public String toString() {
    return ToString.toString(this);
  }
}
