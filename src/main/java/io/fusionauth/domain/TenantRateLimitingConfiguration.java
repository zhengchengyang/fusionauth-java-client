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

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inversoft.json.JacksonConstructor;
import com.inversoft.json.ToString;

/**
 * @author Daniel DeGroff
 */
public class TenantRateLimitingConfiguration implements Buildable<TenantRateLimitingConfiguration> {
  public RateLimitedRequestConfiguration failedLogin = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration forgotPassword = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration sendPasswordlessEmail = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration sendTwoFactorEmail = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration sendTwoFactorSMS = new RateLimitedRequestConfiguration();

  @JacksonConstructor
  public TenantRateLimitingConfiguration() {
  }

  public TenantRateLimitingConfiguration(TenantRateLimitingConfiguration other) {
    this.failedLogin = new RateLimitedRequestConfiguration(other.failedLogin);
    this.forgotPassword = new RateLimitedRequestConfiguration(other.forgotPassword);
    this.sendPasswordlessEmail = new RateLimitedRequestConfiguration(other.sendPasswordlessEmail);
    this.sendTwoFactorEmail = new RateLimitedRequestConfiguration(other.sendTwoFactorEmail);
    this.sendTwoFactorSMS = new RateLimitedRequestConfiguration(other.sendTwoFactorSMS);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TenantRateLimitingConfiguration that = (TenantRateLimitingConfiguration) o;
    return Objects.equals(forgotPassword, that.forgotPassword) &&
           Objects.equals(failedLogin, that.failedLogin) &&
           Objects.equals(sendPasswordlessEmail, that.sendPasswordlessEmail) &&
           Objects.equals(sendTwoFactorEmail, that.sendTwoFactorEmail) &&
           Objects.equals(sendTwoFactorSMS, that.sendTwoFactorSMS);
  }

  @JsonIgnore
  public RateLimitedRequestConfiguration getConfiguration(RateLimitedRequestType type) {
    switch (type) {
      case FailedLogin:
        return failedLogin;
      case ForgotPassword:
        return forgotPassword;
      case SendPasswordlessEmail:
        return sendPasswordlessEmail;
      case SendTwoFactorEmail:
        return sendTwoFactorEmail;
      case SendTwoFactorSMS:
        return sendTwoFactorSMS;
      default:
        throw new IllegalArgumentException("Unexpected request type");
    }
  }

  // TODO : Brett : I want to use enhanced switch syntax but IntelliJ is being a $#*%!
//  @JsonIgnore
//  public RateLimitedRequestConfiguration getConfiguration(RateLimitedRequestType type) {
//    return switch (type) {
//      case FailedLogin -> failedLogin;
//      case ForgotPassword -> forgotPassword;
//      case SendPasswordlessEmail -> sendPasswordlessEmail;
//      case SendTwoFactorEmail -> sendTwoFactorEmail;
//      case SendTwoFactorSMS -> sendTwoFactorSMS;
//      default -> throw new IllegalArgumentException("Unexpected request type");
//    };
//  }

  @Override
  public int hashCode() {
    return Objects.hash(forgotPassword, failedLogin, sendPasswordlessEmail, sendTwoFactorEmail, sendTwoFactorSMS);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
