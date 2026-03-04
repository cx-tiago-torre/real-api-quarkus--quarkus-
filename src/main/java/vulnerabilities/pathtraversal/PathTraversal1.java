package com.checkmarx.cheese.vulnerabilities.pathtraversal;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.nio.file.Files;

@Path("/api/cheese/download")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class PathTraversal1 {

    // Vulnerability: Path Traversal
    @GET
    public Response downloadFile(@QueryParam("filename") String filename) {
        try {
            File file = new File("/var/cheese/files/" + filename);
            byte[] data = Files.readAllBytes(file.toPath());
            
            return Response.ok(data)
                .header("Content-Disposition", "attachment; filename=" + filename)
                .build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
