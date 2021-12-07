/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.event;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.domain.GroupMember;
import io.fusionauth.domain.User;

/**
 * Container for SCIM event information. This is the JSON that is sent from FusionAuth to a SCIM server.
 *
 * @author Brett Pontarelli
 */
public class ScimUserEvent extends BaseScimEvent {

  public boolean active;

  public String displayName;

  public List<Map<String, String>> emails = new ArrayList<>();

  public List<GroupMember> groups = new ArrayList<>();

  public Map<String, String> name = new HashMap<>();

  public List<Map<String, String>> phoneNumbers = new ArrayList<>();

  public List<Map<String, String>> photos = new ArrayList<>();

  public List<Locale> preferredLanguage;

  public ZoneId timezone;

  public String userName;

  @JacksonConstructor
  public ScimUserEvent() {
  }

  public ScimUserEvent(BaseEvent event) {
    schemas = Collections.singletonList("urn:ietf:params:scim:schemas:core:2.0:User");
    User user = ((UserCreateCompleteEvent) event).user;
    createMeta(user.id, "User", user.insertInstant, user.lastUpdateInstant, event.info);
    extractUserData(user);
  }

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
    ScimUserEvent that = (ScimUserEvent) o;
    return active == that.active && Objects.equals(displayName, that.displayName) && Objects.equals(emails, that.emails) && Objects.equals(groups, that.groups) && Objects.equals(name, that.name) && Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(photos, that.photos) && Objects.equals(preferredLanguage, that.preferredLanguage) && Objects.equals(timezone, that.timezone) && Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active, displayName, emails, groups, name, phoneNumbers, photos, preferredLanguage, timezone, userName);
  }

  public String toString() {
    return ToString.toString(this);
  }

  private void addEntry(List<Map<String, String>> list, String value, String type) {
    HashMap<String, String> map = new HashMap();
    map.put("value", value);
    map.put("type", type);
    list.add(map);
  }

  private void extractUserData(User user) {
    userName = user.uniqueUsername != null ? user.uniqueUsername : user.id.toString();
    name.put("formatted", user.fullName);
    name.put("familyName", user.lastName);
    name.put("givenName", user.firstName);
    name.put("middleName", user.middleName);
    displayName = user.getName();
    preferredLanguage = user.preferredLanguages;
    timezone = user.timezone;
    active = user.active;
    // password = It's in the spec, but I'm not sure if it's secure to pass to a ScimServer?
    // [brettp] Can't user Collections.singletonList(Map.of("value", user.email, "type", "other")) is there a better way?
    if (user.email != null) {
      addEntry(emails, user.email, "other");
    }
    if (user.mobilePhone != null) {
      addEntry(phoneNumbers, user.mobilePhone, "mobile");
    }
    if (user.imageUrl != null) {
      addEntry(photos, user.imageUrl.toString(), "photo");
    }
    groups = user.getMemberships();
    // roles = It's in the spec, but not sure how to get it passed to the SS

//  private final List<GroupMember> memberships = new ArrayList<>();
//  private final List<UserRegistration> registrations = new ArrayList<>();
//  public BreachedPasswordStatus breachedPasswordStatus;
//  public ChangePasswordReason passwordChangeReason;
//  public ContentStatus usernameStatus = ContentStatus.ACTIVE;
//  public Integer factor;
//  public LocalDate birthDate;
//  public Map<String, Object> data = new LinkedHashMap<>();
//  public String email;
//  public String encryptionScheme;
//  public String parentEmail;
//  public String salt;
//  public URI imageUrl;
//  public UUID cleanSpeakId;
//  public UUID connectorId = BaseConnectorConfiguration.FUSIONAUTH_CONNECTOR_ID;
//  public UUID tenantId;
//  public UserTwoFactorConfiguration twoFactor = new UserTwoFactorConfiguration();
//  public ZonedDateTime breachedPasswordLastCheckedInstant;
//  public ZonedDateTime expiry;
//  public ZonedDateTime lastLoginInstant;
//  public ZonedDateTime passwordLastUpdateInstant;
//  public boolean passwordChangeRequired;
//  public boolean verified;
  }
}
