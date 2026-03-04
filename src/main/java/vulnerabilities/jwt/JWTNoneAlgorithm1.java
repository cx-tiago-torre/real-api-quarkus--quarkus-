package com.checkmarx.cheese.vulnerabilities.jwt;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("/api/cheese/jwt-none")
@Produces(MediaType.APPLICATION_JSON)
public class JWTNoneAlgorithm1 {

    // Vulnerability: JWT with 'none' algorithm
    @POST
    public Response createToken(@QueryParam("username") String username) {
        String token = Jwts.builder()
            .setSubject(username)
            .signWith(SignatureAlgorithm.NONE, "")
            .compact();
        
        return Response.ok("{\"token\":\"" + token + "\"}").build();
    }
}
