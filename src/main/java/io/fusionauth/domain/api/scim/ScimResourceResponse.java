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

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inversoft.json.JacksonConstructor;

public class ScimResourceResponse {
  public UUID id;
  public List<String> schemas;
  public String externalId;
  public HashMap<String, String> meta;
  public HashMap<String, String> name;
  public String userName;
  public List<HashMap<String, String>> phoneNumbers;
  public List<HashMap<String, Object>> emails;

//  @JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
  public HashMap<String, Object> enterpriseUserExtension;

  @JacksonConstructor
  public ScimResourceResponse() {
  }

}
