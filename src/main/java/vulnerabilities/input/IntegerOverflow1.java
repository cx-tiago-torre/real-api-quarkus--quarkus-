package com.checkmarx.cheese.vulnerabilities.input;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/integer")
@Produces(MediaType.TEXT_PLAIN)
public class IntegerOverflow1 {

    // Vulnerability: Integer overflow
    @GET
    public Response calculateTotal(@QueryParam("price") int price,
                                   @QueryParam("quantity") int quantity) {
        int total = price * quantity;  // Can overflow
        
        return Response.ok("Total: " + total).build();
    }
}
