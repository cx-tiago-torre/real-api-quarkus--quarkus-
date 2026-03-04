package com.checkmarx.cheese.vulnerabilities.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/rate-limit")
@Produces(MediaType.APPLICATION_JSON)
public class NoRateLimit1 {

    // Vulnerability: No rate limiting
    @POST
    public Response createOrder(@QueryParam("quantity") int quantity) {
        // No rate limiting - can be abused
        return Response.ok("{\"orderId\":\"12345\"}").build();
    }
}
