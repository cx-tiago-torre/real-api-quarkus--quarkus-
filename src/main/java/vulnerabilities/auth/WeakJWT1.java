package com.checkmarx.cheese.vulnerabilities.auth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.smallrye.jwt.build.Jwt;

@Path("/api/cheese/jwt")
@Produces(MediaType.APPLICATION_JSON)
public class WeakJWT1 {

    // Vulnerability: Weak JWT Secret
    private static final String JWT_SECRET = "secret";

    @POST
    @Path("/token")
    public Response generateToken(@QueryParam("username") String username) {
        String token = Jwt.issuer("cheese-app")
            .upn(username)
            .groups("user")
            .sign(JWT_SECRET);
        
        return Response.ok("{\"token\":\"" + token + "\"}").build();
    }
}
