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
  // TODO : Rate Limiting : Should we default these values to something reasonable? In general, we should not be adding any additional required fields to a tenant
  //                        unless absolutely necessary. So if we have primitive values, 0 is considered not set and we can default it. See ExternalId Configuration for an example.
  public RateLimitedRequestConfiguration failedLogin = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration forgotPassword = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration resendEmailVerification = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration resendRegistrationVerification = new RateLimitedRequestConfiguration();

  public RateLimitedRequestConfiguration sendPasswordlessEmail = new RateLimitedRequestConfiguration();

  // TODO : Rate Limiting : Guessing at defaults : 10 / 60 seconds
  public RateLimitedRequestConfiguration sendTwoFactorEmail = new RateLimitedRequestConfiguration(10, 60);

  public RateLimitedRequestConfiguration sendTwoFactorSMS = new RateLimitedRequestConfiguration();

  @JacksonConstructor
  public TenantRateLimitingConfiguration() {
  }

  public TenantRateLimitingConfiguration(TenantRateLimitingConfiguration other) {
    this.failedLogin = new RateLimitedRequestConfiguration(other.failedLogin);
    this.forgotPassword = new RateLimitedRequestConfiguration(other.forgotPassword);
    this.resendEmailVerification = new RateLimitedRequestConfiguration(other.resendEmailVerification);
    this.resendRegistrationVerification = new RateLimitedRequestConfiguration(other.resendRegistrationVerification);
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
    return Objects.equals(failedLogin, that.failedLogin) &&
           Objects.equals(forgotPassword, that.forgotPassword) &&
           Objects.equals(resendEmailVerification, that.resendEmailVerification) &&
           Objects.equals(resendRegistrationVerification, that.resendRegistrationVerification) &&
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
      case ResendEmailVerification:
        return resendEmailVerification;
      case ResendRegistrationVerification:
        return resendRegistrationVerification;
      case SendPasswordlessEmail:
        return sendPasswordlessEmail;
      case SendTwoFactorEmail:
        return sendTwoFactorEmail;
      case SendTwoFactorSMS:
        return sendTwoFactorSMS;
      default:
        throw new IllegalArgumentException("Unexpected request type [" + type + "].");
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(failedLogin, forgotPassword, resendEmailVerification, resendRegistrationVerification, sendPasswordlessEmail, sendTwoFactorEmail, sendTwoFactorSMS);
  }

  @Override
  public String toString() {
    return ToString.toString(this);
  }
}
