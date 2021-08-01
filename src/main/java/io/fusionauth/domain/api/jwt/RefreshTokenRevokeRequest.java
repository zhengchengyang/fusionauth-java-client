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
package io.fusionauth.domain.api.jwt;

import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import io.fusionauth.domain.EventInfo;
import io.fusionauth.domain.api.BaseEventRequest;

/**
 * Request for the Refresh Token API to revoke a refresh token rather than using the URL parameters.
 *
 * @author Brian Pontarelli
 */
public class RefreshTokenRevokeRequest extends BaseEventRequest {
  public UUID applicationId;

  public String token;

  public UUID userId;

  @JacksonConstructor
  public RefreshTokenRevokeRequest() {
  }

  public RefreshTokenRevokeRequest(EventInfo eventInfo, UUID applicationId, String token, UUID userId) {
    super(eventInfo);
    this.applicationId = applicationId;
    this.token = token;
    this.userId = userId;
  }
}
