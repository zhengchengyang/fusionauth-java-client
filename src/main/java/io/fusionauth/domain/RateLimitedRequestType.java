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
  SendEmailVerification,
  SendRegistrationVerification,
  // TODO : Rate Limiting : Should this just be PasswordlessSend, or SendPasswordless? Currently this is only for email, but if we add SMS, etc -
  //        should you be able to do 5 of each type, or the fact that you are asking for 5 or more passwordless codes be the limiting factor?
  //        Consensus: Just use one type, use "SendPasswordless"
  SendPasswordlessEmail,
  SendTwoFactor
}
