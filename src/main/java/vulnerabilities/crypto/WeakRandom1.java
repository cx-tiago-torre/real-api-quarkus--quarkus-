package com.checkmarx.cheese.vulnerabilities.crypto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.SecureRandom;
import java.util.Random;

@Path("/api/cheese/random")
@Produces(MediaType.TEXT_PLAIN)
public class WeakRandom1 {

    // Vulnerability: Using weak random number generator
    @GET
    public Response generateToken() {
        Random random = new Random();
        long token = random.nextLong();
        
        return Response.ok(String.valueOf(token)).build();
    }
}
