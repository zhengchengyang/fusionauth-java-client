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
package io.fusionauth.domain;

import java.util.Objects;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;

/**
 * @author Rob Davis
 */
public class SCIMServerConfiguration implements Buildable<SCIMServerConfiguration> {

  public String baseUrl = "https://fusionauth.io";

  public String schemasResponse = "{\n" +
                                  "  \"itemsPerPage\" : 3,\n" +
                                  "  \"schemas\" : [ \"urn:ietf:params:scim:api:messages:2.0:ListResponse\" ],\n" +
                                  "  \"startIndex\" : 0,\n" +
                                  "  \"totalResults\" : 3,\n" +
                                  "  \"Resources\" : [\n" +
                                  "    {\n" +
                                  "      \"id\" : \"urn:ietf:params:scim:schemas:core:2.0:User\",\n" +
                                  "      \"name\" : \"User\",\n" +
                                  "      \"description\" : \"User Account\",\n" +
                                  "      \"attributes\" : [\n" +
                                  "        {\n" +
                                  "          \"name\" : \"userName\",\n" +
                                  "          \"type\" : \"string\",\n" +
                                  "          \"multiValued\" : false,\n" +
                                  "          \"description\" : \"Unique identifier for the User, typically used by the user to directly authenticate to the service provider. Each User MUST include a non-empty userName value. REQUIRED.\",\n" +
                                  "          \"required\" : true,\n" +
                                  "          \"caseExact\" : false,\n" +
                                  "          \"mutability\" : \"readWrite\",\n" +
                                  "          \"returned\" : \"default\",\n" +
                                  "          \"uniqueness\" : \"server\"\n" +
                                  "        },\n" +
                                  "        {\n" +
                                  "          \"name\" : \"active\",\n" +
                                  "          \"type\" : \"boolean\",\n" +
                                  "          \"multiValued\" : false,\n" +
                                  "          \"description\" : \"A Boolean value indicating the User's administrative status.\",\n" +
                                  "          \"required\" : false,\n" +
                                  "          \"mutability\" : \"readWrite\",\n" +
                                  "          \"returned\" : \"default\"\n" +
                                  "        }\n" +
                                  "      ],\n" +
                                  "      \"meta\" : {\n" +
                                  "        \"resourceType\" : \"Schema\",\n" +
                                  "        \"location\" : \"https://fusionauth.io/api/scim/resource/v2/Schemas/urn:ietf:params:scim:schemas:core:2.0:User\"\n" +
                                  "      }\n" +
                                  "    },\n" +
                                  "    {\n" +
                                  "      \"id\" : \"urn:ietf:params:scim:schemas:core:2.0:Group\",\n" +
                                  "      \"name\" : \"Group\",\n" +
                                  "      \"description\" : \"Group\",\n" +
                                  "      \"attributes\" : [\n" +
                                  "        {\n" +
                                  "          \"name\" : \"displayName\",\n" +
                                  "          \"type\" : \"string\",\n" +
                                  "          \"multiValued\" : false,\n" +
                                  "          \"description\" : \"A human-readable name for the Group. REQUIRED.\",\n" +
                                  "          \"required\" : false,\n" +
                                  "          \"caseExact\" : false,\n" +
                                  "          \"mutability\" : \"readWrite\",\n" +
                                  "          \"returned\" : \"default\",\n" +
                                  "          \"uniqueness\" : \"none\"\n" +
                                  "        },\n" +
                                  "        {\n" +
                                  "          \"name\" : \"members\",\n" +
                                  "          \"type\" : \"complex\",\n" +
                                  "          \"multiValued\" : true,\n" +
                                  "          \"description\" : \"A list of members of the Group.\",\n" +
                                  "          \"required\" : false,\n" +
                                  "          \"subAttributes\" : [\n" +
                                  "            {\n" +
                                  "              \"name\" : \"value\",\n" +
                                  "              \"type\" : \"string\",\n" +
                                  "              \"multiValued\" : false,\n" +
                                  "              \"description\" : \"Identifier of the member of this Group.\",\n" +
                                  "              \"required\" : false,\n" +
                                  "              \"caseExact\" : false,\n" +
                                  "              \"mutability\" : \"immutable\",\n" +
                                  "              \"returned\" : \"default\",\n" +
                                  "              \"uniqueness\" : \"none\"\n" +
                                  "            },\n" +
                                  "            {\n" +
                                  "              \"name\" : \"$ref\",\n" +
                                  "              \"type\" : \"reference\",\n" +
                                  "              \"referenceTypes\" : [\n" +
                                  "                \"User\",\n" +
                                  "                \"Group\"\n" +
                                  "              ],\n" +
                                  "              \"multiValued\" : false,\n" +
                                  "              \"description\" : \"The URI corresponding to a SCIM resource that is a member of this Group.\",\n" +
                                  "              \"required\" : false,\n" +
                                  "              \"caseExact\" : false,\n" +
                                  "              \"mutability\" : \"immutable\",\n" +
                                  "              \"returned\" : \"default\",\n" +
                                  "              \"uniqueness\" : \"none\"\n" +
                                  "            }\n" +
                                  "          ],\n" +
                                  "          \"mutability\" : \"readWrite\",\n" +
                                  "          \"returned\" : \"default\"\n" +
                                  "        }\n" +
                                  "      ],\n" +
                                  "      \"meta\" : {\n" +
                                  "        \"resourceType\" : \"Schema\",\n" +
                                  "        \"location\" :\n" +
                                  "        \"https://fusionauth.io/api/scim/resource/v2/Schemas/urn:ietf:params:scim:schemas:core:2.0:Group\"\n" +
                                  "      }\n" +
                                  "    },\n" +
                                  "    {\n" +
                                  "      \"id\" : \"urn:ietf:params:scim:schemas:extension:enterprise:2.0:User\",\n" +
                                  "      \"name\" : \"EnterpriseUser\",\n" +
                                  "      \"description\" : \"Enterprise User\",\n" +
                                  "      \"attributes\" : [],\n" +
                                  "      \"meta\" : {\n" +
                                  "        \"resourceType\" : \"Schema\",\n" +
                                  "        \"location\" :\"https://fusionauth.io/api/scim/resource/v2/Schemas/v2/Schemas/urn:ietf:params:scim:schemas:extension:enterprise:2.0:User\"\n" +
                                  "      }\n" +
                                  "    }\n" +
                                  "  ]\n" +
                                  "}\n";

  @JacksonConstructor
  public SCIMServerConfiguration() {
  }

  public SCIMServerConfiguration(SCIMServerConfiguration other) {
    this.baseUrl = other.baseUrl;
    this.schemasResponse = other.schemasResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SCIMServerConfiguration that = (SCIMServerConfiguration) o;
    return Objects.equals(baseUrl, that.baseUrl) && Objects.equals(schemasResponse, that.schemasResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseUrl, schemasResponse);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}