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
package io.fusionauth.domain.search;

import io.fusionauth.domain.util.SQLTools;

/**
 * @author Brian Pontarelli
 */
public abstract class BaseSearchCriteria {
  public int numberOfResults = 25;

  public String orderBy;

  public int startRow;

  public abstract BaseSearchCriteria prepare();

  public BaseSearchCriteria secure() {
    orderBy = SQLTools.sanitizeOrderBy(orderBy);
    return this;
  }

  protected String defaultOrderBy() {
    return null;
  }
}
