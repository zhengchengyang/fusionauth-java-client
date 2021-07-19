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
  // TODO : Rate Limiting : Should this just be "EmailVerification" and "RegistrationVerification" since we will be using each time we "send"?
  //                        or is this isolated to the "resend" action. We could also call it "SendEmailVerification" and "SendRegistrationVerification" to be
  //                        consistent with the other "SendXX" types below.
  ResendEmailVerification,
  ResendRegistrationVerification,
  // TODO : Rate Limiting : Should this just be PasswordlessSend, or SendPasswordless? Currently this is only for email, but if we add SMS, etc -
  //        should you be able to do 5 of each type, or the fact that you are asking for 5 or more passwordless codes be the limiting factor?
  SendPasswordlessEmail,
  // TODO : Rate Limiting : Should this just be TwoFactorSend, or SendTwoFactor?
  //        The use case would be, if we limit to 5 (for example), should you be able to do 5 of each type, or the fact that you are asking for 5 or more
  //        two-factor codes be the limiting factor?
  SendTwoFactorEmail,
  SendTwoFactorSMS
}
