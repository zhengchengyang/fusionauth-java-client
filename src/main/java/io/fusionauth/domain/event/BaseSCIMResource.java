/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.event;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * Base class for all SCIM resources
 *
 * @author Brett Pontarelli
 */
public abstract class BaseSCIMResource {

  public String externalId;

  public UUID id;

  public ScimMeta meta = new ScimMeta();

  public List<String> schemas;

  @JacksonConstructor
  public BaseSCIMResource() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseSCIMResource that = (BaseSCIMResource) o;
    return Objects.equals(externalId, that.externalId) && Objects.equals(id, that.id) && Objects.equals(meta, that.meta) && Objects.equals(schemas, that.schemas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId, id, meta, schemas);
  }

  protected void createMeta(UUID id, String resourceType, ZonedDateTime created, ZonedDateTime lastModified) {
    meta.resourceType = resourceType;
    meta.created = created;
    meta.lastModified = lastModified;
    // [brettp]TODO: How do we build the URL with all the proper parts?
    meta.location = "https://basescim.url/scim/v2/" + resourceType + "/" + id;
  }

  public static class ScimMeta {
    public ZonedDateTime created;

    public ZonedDateTime lastModified;

    public String location;

    public String resourceType;
  }
}
