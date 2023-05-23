package org.redhat;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Path("/hello")
public class HelloResource {

    @Inject
    MeterRegistry registry;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        registry.counter("hello.resource.hello.count").increment();
        return "hello";
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloName(@PathParam String name) {
        registry.counter("hello.resource.helloname.count", Tags.of("name", name)).increment();
        return "Hello " + name + "!";
    }
}