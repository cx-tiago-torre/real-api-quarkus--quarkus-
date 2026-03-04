package com.checkmarx.cheese.vulnerabilities.validation;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/quantity")
@Produces(MediaType.TEXT_PLAIN)
public class InputValidation2 {

    // Vulnerability: No validation on quantity
    @POST
    public Response orderCheese(@QueryParam("quantity") int quantity) {
        double total = quantity * 10.0;
        return Response.ok("Total: $" + total).build();
    }
}
