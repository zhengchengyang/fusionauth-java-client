/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.api.scim;

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
public abstract class BaseScimResource {

  public String externalId;

  public UUID id;

  public Map<String, Object> meta = new HashMap<>();

  public List<String> schemas;

  @JacksonConstructor
  public BaseScimResource() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseScimResource that = (BaseScimResource) o;
    return Objects.equals(externalId, that.externalId) && Objects.equals(id, that.id) && Objects.equals(meta, that.meta) && Objects.equals(schemas, that.schemas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId, id, meta, schemas);
  }

  protected void createMeta(UUID id, String resource, ZonedDateTime created, ZonedDateTime lastModified) {
//    meta.resourceType = resourceType;
//    meta.created = created;
//    meta.lastModified = lastModified;
//    // [brettp]TODO: How do we build the URL with all the proper parts?
//    meta.location = "https://basescim.url/scim/v2/" + resourceType + "/" + id;
  }

  public static class ScimMeta {
    ZonedDateTime created;

    ZonedDateTime lastModified;

    String location;

    String resourceType;
  }
}
