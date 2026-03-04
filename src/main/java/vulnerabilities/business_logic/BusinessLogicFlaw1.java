package com.checkmarx.cheese.vulnerabilities.business_logic;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/discount")
@Produces(MediaType.APPLICATION_JSON)
public class BusinessLogicFlaw1 {

    // Vulnerability: Business logic flaw - negative quantity
    @POST
    public Response applyDiscount(@QueryParam("price") double price,
                                  @QueryParam("discount") double discount) {
        double finalPrice = price - discount;
        
        // No validation on discount exceeding price
        return Response.ok("{\"finalPrice\":" + finalPrice + "}").build();
    }
}
