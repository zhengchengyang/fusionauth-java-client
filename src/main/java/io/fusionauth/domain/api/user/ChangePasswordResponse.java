/*
 * Copyright (c) 2019, FusionAuth, All Rights Reserved
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
package io.fusionauth.domain.api.user;

import java.util.Map;

import com.inversoft.json.JacksonConstructor;

/**
 * Change password response object.
 *
 * @author Daniel DeGroff
 */
public class ChangePasswordResponse {
  public String oneTimePassword;

  public Map<String, Object> state;

  @JacksonConstructor
  public ChangePasswordResponse() {
  }

  public ChangePasswordResponse(String oneTimePassword) {
    this.oneTimePassword = oneTimePassword;
  }

  public ChangePasswordResponse(String oneTimePassword, Map<String, Object> state) {
    this.oneTimePassword = oneTimePassword;
    this.state = state;
  }
}
