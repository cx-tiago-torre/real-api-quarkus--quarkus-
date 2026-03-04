package com.checkmarx.cheese.vulnerabilities.info;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/error")
@Produces(MediaType.APPLICATION_JSON)
public class InformationDisclosure1 {

    // Vulnerability: Detailed error messages
    @GET
    public Response processData(@QueryParam("id") String id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null");
            }
            
            return Response.ok("Data processed").build();
        } catch (Exception e) {
            // Exposing stack trace
            return Response.serverError()
                .entity("{\"error\":\"" + e.toString() + "\", \"stack\":\"" + 
                       java.util.Arrays.toString(e.getStackTrace()) + "\"}")
                .build();
        }
    }
}
