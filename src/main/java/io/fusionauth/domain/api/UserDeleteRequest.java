/*
 * Copyright (c) 2018-2019, FusionAuth, All Rights Reserved
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
package io.fusionauth.domain.api;

import java.util.List;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;

/**
 * User API delete request object.
 *
 * @author Daniel DeGroff
 */
public class UserDeleteRequest extends BaseEventRequest {
  public boolean dryRun;

  public boolean hardDelete;

  public String query;

  public String queryString;

  public List<UUID> userIds;

  @JacksonConstructor
  public UserDeleteRequest() {
  }

  public UserDeleteRequest(List<UUID> userIds) {
    this.userIds = userIds;
  }

  public UserDeleteRequest(List<UUID> userIds, boolean hardDelete) {
    this.hardDelete = hardDelete;
    this.userIds = userIds;
  }
}
