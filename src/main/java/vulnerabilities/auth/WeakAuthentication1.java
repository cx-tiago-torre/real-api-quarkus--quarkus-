package com.checkmarx.cheese.vulnerabilities.auth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Base64;

@Path("/api/cheese/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class WeakAuthentication1 {

    // Vulnerability: Hardcoded Credentials
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";

    @POST
    public Response login(@HeaderParam("Authorization") String authHeader) {
        try {
            String credentials = new String(Base64.getDecoder().decode(
                authHeader.substring("Basic ".length())));
            
            String[] parts = credentials.split(":");
            if (parts[0].equals(ADMIN_USERNAME) && parts[1].equals(ADMIN_PASSWORD)) {
                return Response.ok("{\"token\":\"12345\"}").build();
            }
            
            return Response.status(401).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
