package com.checkmarx.cheese.vulnerabilities.business_logic;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/wallet")
@Produces(MediaType.APPLICATION_JSON)
public class BusinessLogicFlaw2 {

    private double balance = 1000.0;

    // Vulnerability: Race condition in balance update
    @POST
    @Path("/withdraw")
    public Response withdraw(@QueryParam("amount") double amount) {
        if (balance >= amount) {
            // Race condition window
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            
            balance -= amount;
            return Response.ok("{\"balance\":" + balance + "}").build();
        }
        
        return Response.status(400).entity("Insufficient funds").build();
    }
}
