package com.checkmarx.cheese.vulnerabilities.auth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/admin")
@Produces(MediaType.APPLICATION_JSON)
public class BrokenAccessControl1 {

    // Vulnerability: Missing Authorization Check
    @GET
    @Path("/users/{userId}")
    public Response getUserData(@PathParam("userId") String userId) {
        // No authorization check - any user can access any user's data
        String userData = "Sensitive data for user: " + userId;
        return Response.ok(userData).build();
    }

    @DELETE
    @Path("/users/{userId}")
    public Response deleteUser(@PathParam("userId") String userId) {
        // No authorization check - any user can delete any user
        return Response.ok("User deleted: " + userId).build();
    }
}
