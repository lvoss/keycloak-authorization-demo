package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/helloworld")
public class HelloWorldResource {
  
  String message = "hello world";

  @GET
  public String helloWorld() {
    return message;
  }

  @PUT
  public String helloWorld(@QueryParam("message") String newMessage) {
    this.message = newMessage;
    return "successfully changed Message";
  }
}
