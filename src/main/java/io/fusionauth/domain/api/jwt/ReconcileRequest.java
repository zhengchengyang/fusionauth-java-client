/*
 * Copyright (c) 2018, FusionAuth, All Rights Reserved
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
package io.fusionauth.domain.api.jwt;

import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import io.fusionauth.domain.Buildable;
import io.fusionauth.domain.api.BaseLoginRequest;

/**
 * @author Daniel DeGroff
 */
public class ReconcileRequest extends BaseLoginRequest implements Buildable<ReconcileRequest> {
  public String encodedJWT;

  public UUID identityProviderId;

  @JacksonConstructor
  public ReconcileRequest() {
  }

  public ReconcileRequest(UUID identityProviderId, UUID applicationId, String encodedJWT) {
    this.identityProviderId = identityProviderId;
    this.applicationId = applicationId;
    this.encodedJWT = encodedJWT;
  }

  public ReconcileRequest(UUID identityProviderId, UUID applicationId, String encodedJWT, String ipAddress) {
    this.identityProviderId = identityProviderId;
    this.applicationId = applicationId;
    this.encodedJWT = encodedJWT;
    this.ipAddress = ipAddress;
  }
}
