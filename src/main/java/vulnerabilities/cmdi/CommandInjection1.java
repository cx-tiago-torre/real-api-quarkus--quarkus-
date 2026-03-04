package com.checkmarx.cheese.vulnerabilities.cmdi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Path("/api/cheese/ping")
@Produces(MediaType.TEXT_PLAIN)
public class CommandInjection1 {

    // Vulnerability: Command Injection
    @GET
    public Response pingServer(@QueryParam("host") String host) {
        try {
            Process process = Runtime.getRuntime().exec("ping -c 3 " + host);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            return Response.ok(output.toString()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
