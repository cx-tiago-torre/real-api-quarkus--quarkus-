package com.checkmarx.cheese.vulnerabilities.timing;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/verify")
@Produces(MediaType.TEXT_PLAIN)
public class TimingAttack1 {

    private static final String SECRET_TOKEN = "my-secret-token-12345";

    // Vulnerability: Timing attack in token comparison
    @POST
    public Response verifyToken(@QueryParam("token") String token) {
        if (SECRET_TOKEN.equals(token)) {
            return Response.ok("Valid token").build();
        }
        return Response.status(401).entity("Invalid token").build();
    }
}
