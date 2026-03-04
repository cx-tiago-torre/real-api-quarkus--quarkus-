package com.checkmarx.cheese.vulnerabilities.serialization;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

@Path("/api/cheese/serialize")
@Produces(MediaType.TEXT_PLAIN)
public class UnsafeSerialization1 {

    static class SensitiveData implements Serializable {
        public String username;
        public String password;
    }

    // Vulnerability: Serializing sensitive data
    @GET
    public Response serializeData(@QueryParam("user") String user,
                                  @QueryParam("pass") String pass) {
        try {
            SensitiveData data = new SensitiveData();
            data.username = user;
            data.password = pass;
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(data);
            
            String serialized = Base64.getEncoder().encodeToString(baos.toByteArray());
            return Response.ok(serialized).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
