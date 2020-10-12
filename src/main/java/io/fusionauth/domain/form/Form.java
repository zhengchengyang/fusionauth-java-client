/*
 * Copyright (c) 2020, FusionAuth, All Rights Reserved
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
package io.fusionauth.domain.form;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inversoft.json.ToString;
import io.fusionauth.domain.Buildable;
import io.fusionauth.domain.internal._InternalJSONColumn;
import io.fusionauth.domain.util.Normalizer;

/**
 * @author Daniel DeGroff
 */
public class Form implements Buildable<Form>, _InternalJSONColumn {
  public static final UUID DEFAULT_ADMIN_REGISTRATION_FORM_ID = UUID.fromString("ac396ce7-3268-47a9-8fb6-e652284a0705");

  public static final UUID DEFAULT_ADMIN_USER_FORM_ID = UUID.fromString("ac396ce7-3268-47a9-8fb6-e652284a0706");

  public Map<String, Object> data = new LinkedHashMap<>();

  public UUID id;

  public ZonedDateTime insertInstant;

  public ZonedDateTime lastUpdateInstant;

  public String name;

  public List<FormStep> steps = new ArrayList<>();

  public FormType type = FormType.registration;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Form)) {
      return false;
    }
    Form form = (Form) o;
    return Objects.equals(data, form.data) &&
           Objects.equals(id, form.id) &&
           Objects.equals(insertInstant, form.insertInstant) &&
           Objects.equals(lastUpdateInstant, form.lastUpdateInstant) &&
           Objects.equals(name, form.name) &&
           Objects.equals(steps, form.steps) &&
           type == form.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, id, insertInstant, lastUpdateInstant, name, steps, type);
  }

  @JsonIgnore
  public boolean isDefaultAdminRegistrationEdit() {
    return id != null && id.equals(DEFAULT_ADMIN_REGISTRATION_FORM_ID);
  }

  @JsonIgnore
  public boolean isDefaultAdminUserEdit() {
    return id != null && id.equals(DEFAULT_ADMIN_USER_FORM_ID);
  }

  public void normalize() {
    Normalizer.removeEmpty(data);
    Normalizer.removeEmpty(steps);
    steps.removeIf(step -> step.fields.isEmpty());
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
