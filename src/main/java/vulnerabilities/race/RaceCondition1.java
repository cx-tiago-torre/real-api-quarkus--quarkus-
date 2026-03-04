package com.checkmarx.cheese.vulnerabilities.race;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/counter")
@Produces(MediaType.TEXT_PLAIN)
public class RaceCondition1 {

    private int counter = 0;

    // Vulnerability: Race condition
    @POST
    public Response increment() {
        counter++;
        return Response.ok("Counter: " + counter).build();
    }

    @GET
    public Response getCounter() {
        return Response.ok(String.valueOf(counter)).build();
    }
}
