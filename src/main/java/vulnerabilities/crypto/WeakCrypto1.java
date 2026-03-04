package com.checkmarx.cheese.vulnerabilities.crypto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Path("/api/cheese/encrypt")
@Produces(MediaType.TEXT_PLAIN)
public class WeakCrypto1 {

    // Vulnerability: Weak encryption algorithm (DES)
    private static final String KEY = "12345678";

    @POST
    @Path("/des")
    public Response encryptDES(String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Response.ok(Base64.getEncoder().encodeToString(encrypted)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
