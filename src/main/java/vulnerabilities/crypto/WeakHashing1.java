package com.checkmarx.cheese.vulnerabilities.crypto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.security.MessageDigest;
import java.util.Base64;

@Path("/api/cheese/hash")
@Produces(MediaType.TEXT_PLAIN)
public class WeakHashing1 {

    // Vulnerability: Using MD5 for hashing
    @POST
    @Path("/md5")
    public Response hashMD5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(data.getBytes());
            
            return Response.ok(Base64.getEncoder().encodeToString(hash)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
