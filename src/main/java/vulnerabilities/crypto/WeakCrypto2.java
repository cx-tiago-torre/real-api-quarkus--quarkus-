package com.checkmarx.cheese.vulnerabilities.crypto;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Path("/api/cheese/aes")
@Produces(MediaType.TEXT_PLAIN)
public class WeakCrypto2 {

    // Vulnerability: Hardcoded encryption key
    private static final String AES_KEY = "1234567890123456";

    @POST
    @Path("/encrypt")
    public Response encryptAES(String data) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(AES_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");  // ECB mode is weak
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Response.ok(Base64.getEncoder().encodeToString(encrypted)).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
