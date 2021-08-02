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
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.domain.internal.annotation.ExcludeFromDatabaseDataColumn;

/**
 * @author Brett Guy
 */
public class TenantAccessControlListConfiguration implements Buildable<TenantAccessControlListConfiguration> {

  @ExcludeFromDatabaseDataColumn
  public UUID ipAccessControlListId;

  @JacksonConstructor
  public TenantAccessControlListConfiguration() {
  }

  public TenantAccessControlListConfiguration(TenantAccessControlListConfiguration other) {
    this.ipAccessControlListId = other.ipAccessControlListId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantAccessControlListConfiguration that = (TenantAccessControlListConfiguration) o;
    return Objects.equals(ipAccessControlListId, that.ipAccessControlListId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipAccessControlListId);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
