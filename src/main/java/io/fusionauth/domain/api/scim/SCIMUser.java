/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
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
import io.fusionauth.domain.User;
import io.fusionauth.domain.event.BaseEvent;
import io.fusionauth.domain.event.UserCreateCompleteEvent;

/**
 * Container for SCIM User information.
 *
 * @author Brett Pontarelli
 */
public class SCIMUser extends BaseSCIMResource {

  public boolean active;

  public List<SCIMUserAddress> addresses;

  public String displayName;

  public List<SCIMUserEmail> emails;

  public List<String> entitlements;

  public List<SCIMGroup> groups;

  public List<SCIMUserIMS> ims;

  public String locale;

  public SCIMUserName name;

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

  // [brettp]Note: These were are all the same (moved out to separate files), should they instead be SCIMEntry or something like that?
  //   When they get baked into a fusionauth-lang-client library we want the user to have flexiblity
  //   around extending SCIMUser and all of it's parts, implementations, etc.
  //   !!! DELETE SUBCLASSES WHEN RESOLVED !!!
  // public static class SCIMUserEmail {}
  // public static class SCIMUserIMS {}
  // public static class SCIMUserPhoneNumber {}
  // public static class SCIMUserPhoto {}
}
