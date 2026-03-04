package com.checkmarx.cheese.vulnerabilities.enum;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;

@Path("/api/cheese/files")
@Produces(MediaType.APPLICATION_JSON)
public class DirectoryListing1 {

    // Vulnerability: Directory traversal and listing
    @GET
    public Response listFiles(@QueryParam("dir") String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        
        StringBuilder result = new StringBuilder("[");
        if (files != null) {
            for (File file : files) {
                result.append("\"").append(file.getName()).append("\",");
            }
        }
        result.append("]");
        
        return Response.ok(result.toString()).build();
    }
}
