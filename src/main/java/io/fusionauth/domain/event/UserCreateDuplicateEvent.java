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
package io.fusionauth.domain.event;

import java.util.Objects;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.domain.Buildable;
import io.fusionauth.domain.User;

/**
 * Models an event where a user is being created with an "in-use" login Id (email or username).
 *
 * @author Daniel DeGroff
 */
public class UserCreateDuplicateEvent extends BaseEvent implements Buildable<UserCreateDuplicateEvent>, NonTransactionalEvent {
  public UUID applicationId;

  public String duplicateEmail;

  public String duplicateUsername;

  public User user;

  @JacksonConstructor
  public UserCreateDuplicateEvent() {
  }

  public UserCreateDuplicateEvent(UUID applicationId, String duplicateEmail, String duplicateUsername, User user) {
    this.applicationId = applicationId;
    this.duplicateEmail = duplicateEmail;
    this.duplicateUsername = duplicateUsername;
    this.user = user;
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
    UserCreateDuplicateEvent that = (UserCreateDuplicateEvent) o;
    return Objects.equals(applicationId, that.applicationId) &&
           Objects.equals(user, that.user);
  }

  @Override
  public EventType getType() {
    return EventType.UserCreateDuplicate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), applicationId, user);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
