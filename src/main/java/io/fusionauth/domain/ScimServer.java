/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
// [brettp]TODO: Clean up and check date for all copyright comments.
package io.fusionauth.domain;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.ToString;
import io.fusionauth.domain.event.EventType;
import io.fusionauth.domain.internal._InternalJSONColumn;
import io.fusionauth.domain.util.Normalizer;

/**
 * A SCIM server where events are sent.
 *
 * @author Brett Pontarelli
 */
public class ScimServer extends Enableable implements Buildable<ScimServer>, _InternalJSONColumn {
  public static final List<EventType> eventsEnabled = new ArrayList<>(
      Arrays.asList(EventType.UserCreateComplete,
                    EventType.UserDeleteComplete,
                    EventType.UserRegistrationCreateComplete,
                    EventType.UserRegistrationDeleteComplete,
                    EventType.UserRegistrationUpdateComplete,
                    EventType.UserUpdateComplete
                    // [brettp]TODO: Group, and what else?
                    ));

  public Integer connectTimeout;

  public Map<String, Object> data = new LinkedHashMap<>();

  public String description;

  public boolean global;

  public HTTPHeaders headers = new HTTPHeaders();

  public String httpAuthenticationPassword;

  public String httpAuthenticationUsername;

  public UUID id;

  public ZonedDateTime insertInstant;

  public ZonedDateTime lastUpdateInstant;

  public Integer readTimeout;

  public String sslCertificate;

  public List<UUID> tenantIds = new ArrayList<>();

  public URI url;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ScimServer that = (ScimServer) o;
    return global == that.global && connectTimeout.equals(that.connectTimeout) && data.equals(that.data) && description.equals(that.description) && eventsEnabled.equals(that.eventsEnabled) && headers.equals(that.headers) && httpAuthenticationPassword.equals(that.httpAuthenticationPassword) && httpAuthenticationUsername.equals(that.httpAuthenticationUsername) && id.equals(that.id) && insertInstant.equals(that.insertInstant) && lastUpdateInstant.equals(that.lastUpdateInstant) && readTimeout.equals(that.readTimeout) && sslCertificate.equals(that.sslCertificate) && tenantIds.equals(that.tenantIds) && url.equals(that.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), connectTimeout, data, description, eventsEnabled, global, headers, httpAuthenticationPassword, httpAuthenticationUsername, id, insertInstant, lastUpdateInstant, readTimeout, sslCertificate, tenantIds, url);
  }

  public void normalize() {
    headers.normalize();
    httpAuthenticationPassword = Normalizer.trim(httpAuthenticationPassword);
    httpAuthenticationUsername = Normalizer.trim(httpAuthenticationUsername);
    sslCertificate = Normalizer.trim(sslCertificate);
  }

  public String toString() {
    return ToString.toString(this);
  }
}
