package com.checkmarx.cheese.vulnerabilities.jwt;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Path("/api/cheese/jwt-weak")
@Produces(MediaType.APPLICATION_JSON)
public class JWTWeakSecret1 {

    // Vulnerability: JWT with weak secret
    @POST
    public Response generateJWT(@QueryParam("user") String user) {
        Algorithm algorithm = Algorithm.HMAC256("12345");
        
        String token = JWT.create()
            .withSubject(user)
            .withClaim("role", "admin")
            .sign(algorithm);
        
        return Response.ok("{\"token\":\"" + token + "\"}").build();
    }
}
