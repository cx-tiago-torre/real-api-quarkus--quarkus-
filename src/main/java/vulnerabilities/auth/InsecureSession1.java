package com.checkmarx.cheese.vulnerabilities.auth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.NewCookie;

@Path("/api/cheese/session")
@Produces(MediaType.APPLICATION_JSON)
public class InsecureSession1 {

    // Vulnerability: Insecure Session Management
    @POST
    @Path("/create")
    public Response createSession(@QueryParam("username") String username) {
        // Predictable session ID
        String sessionId = username + "_" + System.currentTimeMillis();
        
        NewCookie cookie = new NewCookie.Builder("SESSIONID")
            .value(sessionId)
            .path("/")
            .secure(false)  // Not secure
            .httpOnly(false)  // Not httpOnly
            .build();
        
        return Response.ok("Session created").cookie(cookie).build();
    }
}
