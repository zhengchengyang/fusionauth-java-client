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
package io.fusionauth.domain.event;

import java.util.Objects;

import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;
import io.fusionauth.domain.AuditLog;
import io.fusionauth.domain.Buildable;

/**
 * Event event to an audit log was created.
 *
 * @author Daniel DeGroff
 */
public class AuditLogCreateEvent extends BaseEvent implements Buildable<AuditLogCreateEvent>, InstanceEvent {
  public AuditLog auditLog;

  @JacksonConstructor
  public AuditLogCreateEvent() {
  }

  public AuditLogCreateEvent(AuditLog auditLog) {
    this.auditLog = auditLog;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    AuditLogCreateEvent that = (AuditLogCreateEvent) o;
    return Objects.equals(auditLog, that.auditLog);
  }

  @Override
  public EventType getType() {
    return EventType.AuditLogCreate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), auditLog);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
