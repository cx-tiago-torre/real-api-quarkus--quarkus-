package com.checkmarx.cheese.vulnerabilities.idor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/order")
@Produces(MediaType.APPLICATION_JSON)
public class IDOR1 {

    // Vulnerability: Insecure Direct Object Reference
    @GET
    @Path("/{orderId}")
    public Response getOrder(@PathParam("orderId") String orderId) {
        // No ownership check - any user can access any order
        return Response.ok("{\"orderId\":\"" + orderId + "\",\"total\":100}").build();
    }

    @DELETE
    @Path("/{orderId}")
    public Response cancelOrder(@PathParam("orderId") String orderId) {
        // No authorization check
        return Response.ok("Order cancelled").build();
    }
}
