/*
 * Copyright (c) 2019, FusionAuth, All Rights Reserved
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

/**
 * The types of lambdas that indicate how they are invoked by FusionAuth.
 *
 * @author Brian Pontarelli
 */
public enum LambdaType {
  // @formatter:off
  JWTPopulate("populate", "" +
      "// Using the user and registration parameters add additional values to the jwt object.\n" +
      "function populate(jwt, user, registration) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Populate your JWT here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),


  OpenIDReconcile("reconcile", "" +
      "// Using the JWT returned from UserInfo, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, jwt, id_token) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  SAMLv2Reconcile("reconcile", "" +
      "// Using the samlResponse, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, samlResponse) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  SAMLv2Populate("populate", "" +
      "// Using the user and registration parameters add additional values to the SAML response.\n" +
      "function populate(samlResponse, user, registration) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(samlResponse)); \n" +
      "\n" +
      "  // Happy coding! Populate the SAML response here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  AppleReconcile("reconcile", "" +
      "// Using the idToken returned from Apple, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, idToken) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  ExternalJWTReconcile("reconcile", "" +
      "// Using the JWT provided by an external IdP, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, jwt) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  FacebookReconcile("reconcile", "" +
      "// Using the response from Facebook Me API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, facebookUser) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  GoogleReconcile("reconcile", "" +
      "// Using the response from the Google Token info API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, idToken) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  HYPRReconcile("reconcile", "" +
      "// Reconcile the User and User Registration.\n" +
      "function reconcile(user, registration) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  TwitterReconcile("reconcile", "" +
      "// Using the response from the Twitter verify_credentials API, reconcile the User and User Registration.\n" +
       "function reconcile(user, registration, twitterUser) {\n" +
       "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
       "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
       "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
       "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
       "  //  \n" +
       "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
       "  //  console.info(JSON.stringify(user)); \n" +
       "\n" +
       "  // Happy coding! Reconcile the User here.\n" +
       "\n" +
       "  console.info('Hello World!');" +
       "\n" +
      "}\n"),

  LDAPConnectorReconcile("reconcile", "" +
      "// Using the response from an LDAP connector, reconcile the User.\n" +
      "function reconcile(user, userAttributes) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  LinkedInReconcile("reconcile", "" +
      "// Using the response returned from LinkedIn Me API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, linkedInUser) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  EpicGamesReconcile("reconcile", "" +
      "// Using the response from the Epic API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  NintendoReconcile("reconcile", "" +
      "// Using the response from the Nintendo API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  SonyPSNReconcile("reconcile", "" +
      "// Using the response from the SonyPSN API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  SteamReconcile("reconcile", "" +
      "// Using the response from the Steam API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  TwitchReconcile("reconcile", "" +
      "// Using the response from the Twitch API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  XboxReconcile("reconcile", "" +
      "// Using the response from the Xbox Token info API, reconcile the User and User Registration.\n" +
      "function reconcile(user, registration, userInfo) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "  //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Reconcile the User here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  ClientCredentialsJWTPopulate("populate", "" +
      "// Using the two Entity and permission parameters you can populate a client credentials grant JWT.\n" +
      "function populate(jwt, recipientEntity, targetEntities, permissions) {\n" +
      "  //  When writing a lambda we've added a few helpers to make life easier.\n" +
      "  //  console.info('Hello World');         # This will create an EventLog of type Information\n" +
      "  //  console.error('Not good.');          # This will create an EventLog of type Error\n" +
      "  //  console.debug('Step 42 completed.'); # This will create an EventLog of type Debug\n" +
      "   //  \n" +
      "  //  To dump an entire object to the EventLog you can use JSON.stringify, for example: \n" +
      "  //  console.info(JSON.stringify(user)); \n" +
      "\n" +
      "  // Happy coding! Populate your JWT here.\n" +
      "\n" +
      "  console.info('Hello World!');" +
      "\n" +
      "}\n"),

  SCIMServerEnterpriseUserRequest("convert", "" +
                                    "function convert(SCIMUser, user) {\n" +
                                    "  user.username = SCIMUser.userName;\n" +
                                    "  user.fullName = SCIMUser.name.formatted;\n" +
                                    "  user.lastName = SCIMUser.name.familyName;\n" +
                                    "  user.firstName = SCIMUser.name.givenName;\n" +
                                    "  user.middleName = SCIMUser.name.middleName;\n" +
                                    "  user.data.honorificPrefix = SCIMUser.name.honorificPrefix;\n" +
                                    "  user.data.honorificSuffix = SCIMUser.name.honorificSuffix;\n" +
                                    "  for (var i = 0; i < SCIMUser.phoneNumbers.length; i++) {\n" +
                                    "    if (SCIMUser.phoneNumbers[i].primary) {\n" +
                                    "      user.mobilePhone = SCIMUser.phoneNumbers[i].value;\n" +
                                    "    }\n" +
                                    "  }\n" +
                                    "  for (var i = 0; i < SCIMUser.emails.length; i++) {\n" +
                                    "    if (SCIMUser.emails[i].primary) {\n" +
                                    "      user.email = SCIMUser.emails[i].value;\n" +
                                    "    }\n" +
                                    "  }\n" +
                                    "}\n"),

  SCIMServerEnterpriseUserResponse("convert", "" +
                                    "function convert(user, newSCIMUser) {\n" +
                                    "          newSCIMUser.userName = user.username;\n" +
                                    "          newSCIMUser.name = {\n" +
                                    "            formatted: user.fullName,\n" +
                                    "            familyName: user.lastName,\n" +
                                    "            givenName: user.firstName,\n" +
                                    "            middleName: user.middleName,\n" +
                                    "            honorificPrefix: user.data.honorificPrefix,\n" +
                                    "            honorificSuffix: user.data.honorificSuffix\n" +
                                    "          }\n" +
                                    "          newSCIMUser.phoneNumbers = [\n" +
                                    "            {\n" +
                                    "              primary: true,\n" +
                                    "              value: user.mobilePhone,\n" +
                                    "              type: \"mobile\"\n" +
                                    "            }\n" +
                                    "          ]\n" +
                                    "          newSCIMUser.emails = [\n" +
                                    "            {\n" +
                                    "              primary: true,\n" +
                                    "              value: user.email,\n" +
                                    "              type: \"work\"\n" +
                                    "            }\n" +
                                    "          ]\n" +
                                    "}\n"),

  SCIMServerGroupRequest("convert", "" +
                            "// Using the generated SCIMUser and FA User, you can map incoming field data to the correct FusionAuth User data.\n" +
                            "function convert(SCIMGroup, group, members) {\n" +
                            "  members[0].id = SCIMGroup.members[0].id;" +
                            "}\n"),

  SCIMServerGroupResponse("convert", "" +
                             "// Using the FusionAuth User and generated SCIMGroup, you can map outgoing field data to the correct SCIMUser data.\n" +
                             "function convert(group, members, SCIMGroup) {\n" +
                             "  SCIMGroup.members[0].displayName = members[0].user.fullName;" +
                             "}\n"),

  SCIMServerUserRequest("convert", "" +
                                   "function convert(SCIMUser, user) {\n" +
                                   "  user.username = SCIMUser.userName;\n" +
                                   "  user.fullName = SCIMUser.name.formatted;\n" +
                                   "  user.lastName = SCIMUser.name.familyName;\n" +
                                   "  user.firstName = SCIMUser.name.givenName;\n" +
                                   "  user.middleName = SCIMUser.name.middleName;\n" +
                                   "  user.data.honorificPrefix = SCIMUser.name.honorificPrefix;\n" +
                                   "  user.data.honorificSuffix = SCIMUser.name.honorificSuffix;\n" +
                                   "  for (var i = 0; i < SCIMUser.phoneNumbers.length; i++) {\n" +
                                   "    if (SCIMUser.phoneNumbers[i].primary) {\n" +
                                   "      user.mobilePhone = SCIMUser.phoneNumbers[i].value;\n" +
                                   "    }\n" +
                                   "  }\n" +
                                   "  for (var i = 0; i < SCIMUser.emails.length; i++) {\n" +
                                   "    if (SCIMUser.emails[i].primary) {\n" +
                                   "      user.email = SCIMUser.emails[i].value;\n" +
                                   "    }\n" +
                                   "  }\n" +
                                   "}\n"),

  SCIMServerUserResponse("convert", "" +
                                    "function convert(user, newSCIMUser) {\n" +
                                    "          newSCIMUser.userName = user.username;\n" +
                                    "          newSCIMUser.name = {\n" +
                                    "            formatted: user.fullName,\n" +
                                    "            familyName: user.lastName,\n" +
                                    "            givenName: user.firstName,\n" +
                                    "            middleName: user.middleName,\n" +
                                    "            honorificPrefix: user.data.honorificPrefix,\n" +
                                    "            honorificSuffix: user.data.honorificSuffix\n" +
                                    "          }\n" +
                                    "          newSCIMUser.phoneNumbers = [\n" +
                                    "            {\n" +
                                    "              primary: true,\n" +
                                    "              value: user.mobilePhone,\n" +
                                    "              type: \"mobile\"\n" +
                                    "            }\n" +
                                    "          ]\n" +
                                    "          newSCIMUser.emails = [\n" +
                                    "            {\n" +
                                    "              primary: true,\n" +
                                    "              value: user.email,\n" +
                                    "              type: \"work\"\n" +
                                    "            }\n" +
                                    "          ]\n" +
                                    "          // example of accessing values from a custom schema extension." +
                                    "          // newSCIMUser['urn:ietf:params:scim:schemas:extension:fubar:2.0:User'].whibble = user.data.extensions['urn:ietf:params:scim:schemas:extension:fubar:2.0:User'].whibble + \"42\";\n" +
                                    "}\n");
  // @formatter:on

  private final String example;

  private final String functionName;

  LambdaType(String functionName, String example) {
    this.functionName = functionName;
    this.example = example;
  }

  public String getExample() {
    return example;
  }

  public String getFunctionName() {
    return functionName;
  }
}
