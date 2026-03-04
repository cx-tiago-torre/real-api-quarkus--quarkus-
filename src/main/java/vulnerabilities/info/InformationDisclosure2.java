package com.checkmarx.cheese.vulnerabilities.info;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;

@Path("/api/cheese/debug")
@Produces(MediaType.APPLICATION_JSON)
public class InformationDisclosure2 {

    // Vulnerability: Exposing system information
    @GET
    public Response getSystemInfo() {
        String info = "{" +
            "\"os\": \"" + System.getProperty("os.name") + "\"," +
            "\"user\": \"" + System.getProperty("user.name") + "\"," +
            "\"home\": \"" + System.getProperty("user.home") + "\"," +
            "\"java_version\": \"" + System.getProperty("java.version") + "\"," +
            "\"working_dir\": \"" + System.getProperty("user.dir") + "\"" +
            "}";
        
        return Response.ok(info).build();
    }
}
