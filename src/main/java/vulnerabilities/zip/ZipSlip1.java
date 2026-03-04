package com.checkmarx.cheese.vulnerabilities.zip;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.ByteArrayInputStream;

@Path("/api/cheese/extract")
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
@Produces(MediaType.TEXT_PLAIN)
public class ZipSlip1 {

    // Vulnerability: Zip Slip
    @POST
    public Response extractZip(byte[] zipData) {
        try {
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipData));
            ZipEntry entry = zis.getNextEntry();
            
            while (entry != null) {
                String fileName = entry.getName();
                File newFile = new File("/tmp/cheese/" + fileName);  // No path validation
                
                FileOutputStream fos = new FileOutputStream(newFile);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
                entry = zis.getNextEntry();
            }
            
            return Response.ok("Zip extracted").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
