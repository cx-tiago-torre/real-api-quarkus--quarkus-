package com.checkmarx.cheese.vulnerabilities.pathtraversal;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.FileOutputStream;

@Path("/api/cheese/upload")
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
public class PathTraversal3 {

    // Vulnerability: Arbitrary File Upload
    @POST
    public Response uploadFile(@QueryParam("filename") String filename, byte[] data) {
        try {
            FileOutputStream fos = new FileOutputStream("/var/cheese/uploads/" + filename);
            fos.write(data);
            fos.close();
            
            return Response.ok("File uploaded").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
