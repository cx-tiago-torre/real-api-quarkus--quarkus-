package com.checkmarx.cheese.vulnerabilities.dos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/loop")
@Produces(MediaType.TEXT_PLAIN)
public class InfiniteLoop1 {

    // Vulnerability: Uncontrolled loop
    @GET
    public Response executeLoop(@QueryParam("iterations") long iterations) {
        long sum = 0;
        for (long i = 0; i < iterations; i++) {
            sum += i;
        }
        
        return Response.ok("Sum: " + sum).build();
    }
}
