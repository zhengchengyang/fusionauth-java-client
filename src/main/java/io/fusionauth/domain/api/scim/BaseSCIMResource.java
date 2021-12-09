/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.api.scim;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * Base class for all SCIM events
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

  // [brettp]Note: This method should go away, but since it will happen for every resource
  //   it might make sense to have a BaseConverter to populate meta?
  //   Note also, I'm still stuck :shrug: on how to pass down the `location` since the converter in
  //   the direction `User -> ScimUser` for example needs to take `baseUrl` or something as a param.
  protected void createMeta(UUID id, String resource, ZonedDateTime created, ZonedDateTime lastModified) {
//    meta.resourceType = resourceType;
//    meta.created = created;
//    meta.lastModified = lastModified;
//    meta.location = "https://basescim.url/scim/v2/" + resourceType + "/" + id;
  }

  public static class ScimMeta {
    ZonedDateTime created;

    ZonedDateTime lastModified;

    String location;

    String resourceType;

    String version;
  }
}
