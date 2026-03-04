package com.checkmarx.cheese.vulnerabilities.pathtraversal;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.InputStream;

@Path("/api/cheese/read")
@Produces(MediaType.TEXT_PLAIN)
public class PathTraversal2 {

    // Vulnerability: Path Traversal with FileInputStream
    @GET
    public Response readFile(@QueryParam("path") String path) {
        try {
            InputStream is = new FileInputStream(path);
            String content = new String(is.readAllBytes());
            is.close();
            
            return Response.ok(content).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
