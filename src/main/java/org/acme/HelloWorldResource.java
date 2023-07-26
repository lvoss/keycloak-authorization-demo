package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/helloworld")
public class HelloWorldResource {
  @GET
  public String helloWorld() {
    return "hello world";
  }
}
