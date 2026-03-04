package com.checkmarx.cheese.vulnerabilities.thread;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/thread")
@Produces(MediaType.TEXT_PLAIN)
public class ThreadSafety1 {

    private StringBuilder data = new StringBuilder();

    // Vulnerability: Not thread-safe
    @POST
    public Response appendData(@QueryParam("value") String value) {
        data.append(value);
        return Response.ok("Data appended").build();
    }

    @GET
    public Response getData() {
        return Response.ok(data.toString()).build();
    }
}
