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
package io.fusionauth.domain.api;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.inversoft.json.JacksonConstructor;
import io.fusionauth.domain.GroupMember;
import io.fusionauth.domain.GroupMemberListItem;

/**
 * Group Member Response
 *
 * @author Daniel DeGroff
 */
public class MemberListItemsResponse {
  public List<GroupMemberListItem> members;

  @JacksonConstructor
  public MemberListItemsResponse() {
  }

  public MemberListItemsResponse(List<GroupMemberListItem> members) {
    this.members = members;
  }
}
