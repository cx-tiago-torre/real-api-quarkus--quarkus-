package com.checkmarx.cheese.vulnerabilities.temp;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;

@Path("/api/cheese/temp")
@Produces(MediaType.TEXT_PLAIN)
public class InsecureTempFile1 {

    // Vulnerability: Insecure temporary file creation
    @POST
    public Response createTempFile(String data) {
        try {
            File tempFile = File.createTempFile("cheese", ".txt");
            // File is predictable and may have insecure permissions
            
            FileWriter writer = new FileWriter(tempFile);
            writer.write(data);
            writer.close();
            
            return Response.ok("File created: " + tempFile.getAbsolutePath()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
