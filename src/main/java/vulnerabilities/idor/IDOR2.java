package com.checkmarx.cheese.vulnerabilities.idor;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/account")
@Produces(MediaType.APPLICATION_JSON)
public class IDOR2 {

    // Vulnerability: IDOR with predictable IDs
    @GET
    @Path("/{userId}")
    public Response getUserAccount(@PathParam("userId") int userId) {
        // Sequential user IDs with no access control
        return Response.ok("{\"userId\":" + userId + ",\"balance\":5000}").build();
    }
}
