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
package io.fusionauth.domain.api;

import java.util.List;

import com.inversoft.json.JacksonConstructor;
import io.fusionauth.domain.IPAccessControlList;
import io.fusionauth.domain.search.SearchResults;

/**
 * @author Brett Guy
 */
public class IPAccessControlListSearchResponse {
  public List<IPAccessControlList> ipAccessControlLists;

  public long total;

  @JacksonConstructor
  public IPAccessControlListSearchResponse() {
  }

  public IPAccessControlListSearchResponse(SearchResults<IPAccessControlList> searchResults) {
    this.ipAccessControlLists = searchResults.results;
    this.total = searchResults.total;
  }
}
