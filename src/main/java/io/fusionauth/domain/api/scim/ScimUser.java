/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.api.scim;

import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.domain.GroupMember;
import io.fusionauth.domain.User;
import io.fusionauth.domain.event.BaseEvent;
import io.fusionauth.domain.event.UserCreateCompleteEvent;

/**
 * Container for SCIM event information. This is the JSON that is sent from FusionAuth to a SCIM server.
 *
 * @author Brett Pontarelli
 */
public class ScimUser extends BaseScimResource {

  public boolean active;

  public String displayName;

  public List<Object> emails;

  public List<GroupMember> groups;

  public Map<String, String> name;

  public String password;

  public List<Map<String, String>> phoneNumbers;

  public List<Map<String, String>> photos;

  public List<Locale> preferredLanguage;

  public ZoneId timezone;

  public String userName;

  @JacksonConstructor
  public ScimUser() {
  }

  public ScimUser(BaseEvent event) {
    User user = ((UserCreateCompleteEvent) event).user;
    schemas = Collections.singletonList("urn:ietf:params:scim:schemas:core:2.0:User");
    id = user.id;
    createMeta(id, "User", user.insertInstant, user.lastUpdateInstant);
    extractData(user);
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
    ScimUser that = (ScimUser) o;
    return active == that.active && Objects.equals(displayName, that.displayName) && Objects.equals(emails, that.emails) && Objects.equals(groups, that.groups) && Objects.equals(name, that.name) && Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(photos, that.photos) && Objects.equals(preferredLanguage, that.preferredLanguage) && Objects.equals(timezone, that.timezone) && Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active, displayName, emails, groups, name, phoneNumbers, photos, preferredLanguage, timezone, userName);
  }

  public String toString() {
    return ToString.toString(this);
  }

  private void extractData(User user) {
    userName = user.uniqueUsername != null ? user.uniqueUsername : user.id.toString();
//    name = Map.of(
//        "formatted", user.fullName,
//        "familyName", user.lastName,
//        "givenName", user.firstName,
//        "middleName", user.middleName);
    displayName = user.getName();
    preferredLanguage = user.preferredLanguages;
    timezone = user.timezone;
    active = user.active;
    // password = It's in the spec, but I'm not sure if it's secure to pass to a ScimServer?
//    emails = Collections.singletonList(Map.of("value", user.email, "type", "other"));
//    phoneNumbers = Collections.singletonList(Map.of("value", user.mobilePhone, "type", "mobile"));
//    photos = Collections.singletonList(Map.of("value", user.imageUrl, "type", "photo"));
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

  // [brettp]Note: -- Rob:
  //   I started adding these, but they break your ScimService which I didn't want to make changes to
  //   since I know you'll likely be moving them to resource specific converters.  So, I'll leave them
  //   for now feel free to add/change/delete them as necessary.
  public static class ScimUserEmail {
    public boolean primary = true;

    public String type;

    public String value;
  }

  public static class ScimUserName {
    public String familyName;

    public String formatted;

    public String givenName;

    public String middleName;
  }

  public static class ScimUserPhoneNumber {
    public String type;

    public String value;
  }

  public static class ScimUserPhoto {
    public String type;

    public String value;
  }
}
