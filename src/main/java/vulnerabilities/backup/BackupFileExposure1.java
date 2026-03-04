package com.checkmarx.cheese.vulnerabilities.backup;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.nio.file.Files;

@Path("/api/cheese/backup")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class BackupFileExposure1 {

    // Vulnerability: Exposing backup files
    @GET
    public Response downloadBackup(@QueryParam("file") String filename) {
        try {
            File file = new File("/var/backups/" + filename);
            byte[] data = Files.readAllBytes(file.toPath());
            
            return Response.ok(data)
                .header("Content-Disposition", "attachment; filename=" + filename)
                .build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
