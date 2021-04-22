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
package io.fusionauth.domain;

import java.util.Objects;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;

/**
 * @author Daniel DeGroff
 */
public class TenantUsernameConfiguration implements Buildable<TenantUsernameConfiguration> {
  public UniqueUsernameConfiguration unique = new UniqueUsernameConfiguration();

  public TenantUsernameConfiguration(TenantUsernameConfiguration other) {
    this.unique = new UniqueUsernameConfiguration(other.unique);
  }

  @JacksonConstructor
  public TenantUsernameConfiguration() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantUsernameConfiguration that = (TenantUsernameConfiguration) o;
    return Objects.equals(unique, that.unique);
  }

  @Override
  public int hashCode() {
    return Objects.hash(unique);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }

  public enum UniqueUsernameAppendPolicy {
    // Always append a suffix when unique usernames are enabled
    // Example: Even if nobody is using 'bob', this will be created as 'bob12345'
    Always,
    // Allow the root username to be used.
    // Example: If nobody is using 'bob', you can use this username a suffix will not be appended.
    OnDuplicate
  }

  public static class UniqueUsernameConfiguration extends Enableable implements Buildable<UniqueUsernameConfiguration> {
    public UniqueUsernameAppendPolicy appendPolicy;

    public int numberOfDigits;

    @JacksonConstructor
    public UniqueUsernameConfiguration() {
    }

    public UniqueUsernameConfiguration(UniqueUsernameConfiguration other) {
      this.appendPolicy = other.appendPolicy;
      this.numberOfDigits = other.numberOfDigits;
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
      UniqueUsernameConfiguration that = (UniqueUsernameConfiguration) o;
      return numberOfDigits == that.numberOfDigits && appendPolicy == that.appendPolicy;
    }

    @Override
    public int hashCode() {
      return Objects.hash(super.hashCode(), appendPolicy, numberOfDigits);
    }

    @Override
    public String toString() {
      return ToString.toString(this);
    }
  }
}
