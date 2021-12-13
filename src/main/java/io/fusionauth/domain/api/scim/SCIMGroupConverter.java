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

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import io.fusionauth.domain.Group;
import io.fusionauth.domain.User;

public class SCIMGroupConverter {

  public static Group fromSCIMGroup(SCIMGroup source) {
    Group target = new Group();
    // Build a valid Group using the SCIMGroup data.
    target.id = source.id;
    target.name = source.displayName;
    // TODO: rob: what are we doing about members
    return target;
  }

  public static SCIMGroup toSCIMGroup(Group source) {
    SCIMGroup target = new SCIMGroup();
      // Build a valid ScimGroup using the FusionAuth Group data.
      target.id = source.id;
      target.schemas = new ArrayList<>();
      target.schemas.add("urn:ietf:params:scim:schemas:core:2.0:Group");
      SCIMMeta meta = new SCIMMeta();
      meta.resourceType = "Group";
      meta.created = source.insertInstant.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
      meta.lastModified =  source.lastUpdateInstant.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
      meta.location = "https://fusionauth.io/api/scim/resource/v2/Groups/" + source.id;
      meta.version = "";
      target.meta = meta;
      target.displayName = source.name;
      //TODO: rob: what are we doing about members
      return target;
  }
}
