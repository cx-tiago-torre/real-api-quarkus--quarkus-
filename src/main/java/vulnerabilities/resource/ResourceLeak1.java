package com.checkmarx.cheese.vulnerabilities.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.InputStream;

@Path("/api/cheese/resource")
@Produces(MediaType.TEXT_PLAIN)
public class ResourceLeak1 {

    // Vulnerability: Resource not properly closed
    @GET
    public Response readResource(@QueryParam("file") String file) {
        try {
            InputStream is = new FileInputStream(file);
            String content = new String(is.readAllBytes());
            // InputStream not closed
            
            return Response.ok(content).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
