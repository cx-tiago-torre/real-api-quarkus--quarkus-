package com.checkmarx.cheese.vulnerabilities.permissions;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;

@Path("/api/cheese/permissions")
@Produces(MediaType.TEXT_PLAIN)
public class InsecureFilePermissions1 {

    // Vulnerability: Insecure file permissions
    @POST
    public Response createFile(@QueryParam("filename") String filename, String content) {
        try {
            File file = new File("/var/cheese/data/" + filename);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
            
            // Setting overly permissive permissions
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
            
            return Response.ok("File created with permissions").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
