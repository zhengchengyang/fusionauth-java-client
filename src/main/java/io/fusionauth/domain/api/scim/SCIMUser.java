/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain.api.scim;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
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
public class SCIMUser extends BaseSCIMResource {

  public boolean active;

  public List<SCIMUserAddress> addresses;

  public String displayName;

  public List<Object> emails;

  public List<String> entitlements;

  // [brettp]TODO: This is actually a List<SCIMGroup>, right?
  public List<GroupMember> groups;

  public List<SCIMUserIMS> ims;

  public String locale;

  public SCIMUserName name = new SCIMUserName();

  public String nickName;

  public String password;

  public List<SCIMUserPhoneNumber> phoneNumbers;

  public List<SCIMUserPhoto> photos;

  public String preferredLanguage;

  public URI profileUrl;

  public List<String> roles;

  public ZoneId timezone;

  public URI title;

  public String userName;

  public URI userType;

  public List<X509Certificate> x509Certificates;

  @JacksonConstructor
  public SCIMUser() {
  }

  public SCIMUser(BaseEvent event) {
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
    SCIMUser that = (SCIMUser) o;
    return active == that.active && Objects.equals(displayName, that.displayName) && Objects.equals(emails, that.emails) && Objects.equals(groups, that.groups) && Objects.equals(name, that.name) && Objects.equals(phoneNumbers, that.phoneNumbers) && Objects.equals(photos, that.photos) && Objects.equals(preferredLanguage, that.preferredLanguage) && Objects.equals(timezone, that.timezone) && Objects.equals(userName, that.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), active, displayName, emails, groups, name, phoneNumbers, photos, preferredLanguage, timezone, userName);
  }

  public String toString() {
    return ToString.toString(this);
  }

  // [brettp]Note: -- Rob:
  //   I started adding these, but they break your SCIMService which I didn't want to make changes to
  //   since I know you'll likely be moving them to resource specific converters.  So, I'll leave them
  //   for now feel free to add/change/delete them as necessary.
  public static class SCIMUserAddress {
    public String country;

    public String formatted;

    public String locality;

    public String postalCode;

    public boolean primary;  // Not exactly in spec?, but in the example?

    public String region;

    public String streetAddress;
  }

  // [brettp]Note: These are all the same, should they instead be SCIMEntry or something like that?
  //   When they get baked into a fusionauth-lang-client library we want the user to have flexiblity
  //   around extending SCIMUser and all of it's parts, implementations, etc.
  public static class SCIMUserEmail {
    public boolean primary;

    public String type;

    public String value;
  }

  public static class SCIMUserIMS {
    public boolean primary;

    public String type;

    public String value;
  }

  public static class SCIMUserName {
    public String familyName;

    public String formatted;

    public String givenName;

    public String honorificPrefix;

    public String honorificSuffix;

    public String middleName;
  }

  public static class SCIMUserPhoneNumber {
    public boolean primary;

    public String type;

    public String value;
  }

  public static class SCIMUserPhoto {
    public boolean primary;

    public String type;

    public String value;
  }
}
