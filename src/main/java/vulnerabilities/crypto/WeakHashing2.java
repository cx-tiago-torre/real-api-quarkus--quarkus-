package com.checkmarx.cheese.vulnerabilities.crypto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.MessageDigest;
import java.util.Base64;

@Path("/api/cheese/sha1")
@Produces(MediaType.TEXT_PLAIN)
public class WeakHashing2 {

    // Vulnerability: Using SHA1 for hashing
    @POST
    public Response hashSHA1(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(data.getBytes());
            
            return Response.ok(Base64.getEncoder().encodeToString(hash)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
