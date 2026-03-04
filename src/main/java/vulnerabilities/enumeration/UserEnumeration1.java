package com.checkmarx.cheese.vulnerabilities.enumeration;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/user-exists")
@Produces(MediaType.APPLICATION_JSON)
public class UserEnumeration1 {

    // Vulnerability: User enumeration via different responses
    @POST
    @Path("/login")
    public Response login(@FormParam("username") String username,
                         @FormParam("password") String password) {
        // Different error messages reveal user existence
        if (!"admin".equals(username)) {
            return Response.status(401).entity("{\"error\":\"Username not found\"}").build();
        }
        
        if (!"password".equals(password)) {
            return Response.status(401).entity("{\"error\":\"Invalid password\"}").build();
        }
        
        return Response.ok("{\"token\":\"abc123\"}").build();
    }
}
