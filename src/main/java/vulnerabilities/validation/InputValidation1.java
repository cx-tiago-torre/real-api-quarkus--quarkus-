package com.checkmarx.cheese.vulnerabilities.validation;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/price")
@Produces(MediaType.TEXT_PLAIN)
public class InputValidation1 {

    // Vulnerability: Missing input validation
    @POST
    public Response setPrice(@QueryParam("price") double price) {
        // No validation for negative prices
        return Response.ok("Price set to: " + price).build();
    }
}
