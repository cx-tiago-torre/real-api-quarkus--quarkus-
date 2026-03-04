package com.checkmarx.cheese.vulnerabilities.deserialization;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

@Path("/api/cheese/deserialize")
@Produces(MediaType.APPLICATION_JSON)
public class UnsafeDeserialization1 {

    // Vulnerability: Insecure Deserialization
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deserializeObject(String data) {
        try {
            byte[] bytes = Base64.getDecoder().decode(data);
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            
            Object obj = ois.readObject();
            ois.close();
            
            return Response.ok("Object deserialized: " + obj.toString()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
