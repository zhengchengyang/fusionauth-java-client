## FusionAuth Java Client ![semver 2.0.0 compliant](http://img.shields.io/badge/semver-2.0.0-brightgreen.svg?style=flat-square)
If you're integrating FusionAuth with a Java application, this library will speed up your development time.

For additional information and documentation on FusionAuth refer to [https://fusionauth.io](https://fusionauth.io).


## Maven 
```xml
<dependency>
  <groupId>io.fusionauth</groupId>
  <artifactId>fusionauth-java-client</artifactId>
  <version>1.5.0</version>
</dependency>
```

Then, perform an integration build of the project by running:
```bash
$ sb int
```

For more information, checkout [savantbuild.org](http://savantbuild.org/).

## Example Usage

### Build the Client

```java
String apiKey = "5a826da2-1e3a-49df-85ba-cd88575e4e9d";
FusionAuthClient client = new FusionAuthClient(apiKey, "http://localhost:9011");
```

### Build the SSL Client

```java
String apiKey = "5a826da2-1e3a-49df-85ba-cd88575e4e9d";
FusionAuthClient client = new FusionAuthClient(apiKey, "https://localhost:9011").sslCertificate("BASE64 Encode ssl certificate value");
FusionAuthClient client = new FusionAuthClient(apiKey, "https://localhost:9011").sslCertificate("BASE64 Encode ssl certificate value").sslKey("BASE64 Encode ssl private key value");
```

### Login a user

```java
UUID applicationId = UUID.fromString("68364852-7a38-4e15-8c48-394eceafa601");

LoginRequest request = new LoginRequest(applicationId, "joe@fusionauth.io", null, "abc123");
ClientResponse<LoginResponse, Errors> result = client.login(request);
if (!result.wasSuccessful()) {
 // Error
}

// Hooray! Success
```

## Building 

### Building with Maven

```bash
$ mvn install
```

### Building with Savant

**Note:** This project uses the Savant build tool. To compile using Savant, follow these instructions:

```bash
$ mkdir ~/savant
$ cd ~/savant
$ wget http://savant.inversoft.org/org/savantbuild/savant-core/1.0.0/savant-1.0.0.tar.gz
$ tar xvfz savant-1.0.0.tar.gz
$ ln -s ./savant-1.0.0 current
$ export PATH=$PATH:~/savant/current/bin/
```

## Questions and support

If you have a question or support issue regarding this client library, we'd love to hear from you.

If you have a paid edition with support included, please [open a ticket in your account portal](https://account.fusionauth.io/account/support/). Learn more about [paid editions here](https://fusionauth.io/pricing).

Otherwise, please [post your question in the community forum](https://fusionauth.io/community/forum/).

## Contributing

Bug reports and pull requests are welcome on GitHub at https://github.com/FusionAuth/fusionauth-java-client.

## License

This code is available as open source under the terms of the [Apache v2.0 License](https://opensource.org/licenses/Apache-2.0).

