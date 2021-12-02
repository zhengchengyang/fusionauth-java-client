/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.event;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * Base class for all SCIM events
 *
 * @author Brett Pontarelli
 */
public abstract class BaseScimEventRequest {

  public String externalId;

  public UUID id;

  public Map<String, Object> meta = new HashMap<>();
//  public ScimMeta meta;

  public List<String> schemas;

  @JacksonConstructor
  public BaseScimEventRequest() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseScimEventRequest that = (BaseScimEventRequest) o;
    return Objects.equals(externalId, that.externalId) && Objects.equals(id, that.id) && Objects.equals(meta, that.meta) && Objects.equals(schemas, that.schemas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId, id, meta, schemas);
  }

  protected void createMeta(UUID id, String resource, ZonedDateTime created, ZonedDateTime lastModified) {
    meta.put("resourceType", resource);
    meta.put("created", created);
    meta.put("lastModified", lastModified);
    // [brettp]TODO: How do we build the URL with all the parts?
    //    meta.put("location", QueryStringBuilder
    meta.put("location", "http://thebaseurl.com/scim/v2/" + resource + "/" + id);
    // meta.put("version", "W\/\"f250dd84f0671c3\"");  // I don't think we are going to use this.
  }

  public class ScimMeta {
    ZonedDateTime created;

    ZonedDateTime lastModified;

    String location;

    String resourceType;
  }
}
