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
package io.fusionauth.domain;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.inversoft.json.ToString;

/**
 * Information about a user event (login, register, etc) that helps identify the source of the event (location, device type, OS, etc).
 *
 * @author Brian Pontarelli
 */
public class EventInfo implements Buildable<EventInfo> {
  public String deviceDescription;

  public String deviceName;

  public String deviceType;

  public ZonedDateTime instant;

  public String ipAddress;

  public Location location;

  public String os;

  public String userAgent;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventInfo eventInfo = (EventInfo) o;
    return Objects.equals(deviceDescription, eventInfo.deviceDescription) &&
           Objects.equals(deviceName, eventInfo.deviceName) &&
           Objects.equals(deviceType, eventInfo.deviceType) &&
           Objects.equals(instant, eventInfo.instant) &&
           Objects.equals(ipAddress, eventInfo.ipAddress) &&
           Objects.equals(location, eventInfo.location) &&
           Objects.equals(os, eventInfo.os) &&
           Objects.equals(userAgent, eventInfo.userAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceDescription, deviceName, deviceType, instant, ipAddress, location, os, userAgent);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
