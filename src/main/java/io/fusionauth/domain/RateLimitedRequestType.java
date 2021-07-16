/*
 * Copyright (c) 2021, FusionAuth, All Rights Reserved
 */
package io.fusionauth.domain;

/**
 * @author Daniel DeGroff
 */
public enum RateLimitedRequestType {
  FailedLogin,
  ForgotPassword,
  ResendEmailVerification,
  ResendRegistrationVerification,
  SendPasswordlessEmail,
  SendTwoFactorEmail,
  SendTwoFactorSMS
}
