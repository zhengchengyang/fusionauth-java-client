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

import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import io.fusionauth.domain.EventInfo;
import io.fusionauth.domain.Tenant;

/**
 * @author Daniel DeGroff
 */
public class TenantRequest extends BaseEventRequest {
  public UUID sourceTenantId;

  public Tenant tenant;

  @JacksonConstructor
  public TenantRequest() {
  }

  public TenantRequest(Tenant tenant) {
    this.tenant = tenant;
  }

  public TenantRequest(EventInfo eventInfo, Tenant tenant) {
    super(eventInfo);
    this.tenant = tenant;
  }
}
