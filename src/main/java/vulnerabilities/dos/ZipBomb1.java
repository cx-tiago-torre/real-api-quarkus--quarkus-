package com.checkmarx.cheese.vulnerabilities.dos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.zip.ZipInputStream;
import java.io.ByteArrayInputStream;

@Path("/api/cheese/unzip")
@Consumes(MediaType.APPLICATION_OCTET_STREAM)
@Produces(MediaType.TEXT_PLAIN)
public class ZipBomb1 {

    // Vulnerability: Zip Bomb / Zip Slip
    @POST
    public Response unzipFile(byte[] data) {
        try {
            ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(data));
            var entry = zis.getNextEntry();
            
            while (entry != null) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    // No size limit check
                }
                entry = zis.getNextEntry();
            }
            
            return Response.ok("Unzipped successfully").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
