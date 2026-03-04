package com.checkmarx.cheese.vulnerabilities.cmdi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Path("/api/cheese/exec")
@Produces(MediaType.TEXT_PLAIN)
public class CommandInjection2 {

    // Vulnerability: Command Injection with ProcessBuilder
    @GET
    public Response executeCommand(@QueryParam("cmd") String cmd) {
        try {
            ProcessBuilder pb = new ProcessBuilder("sh", "-c", cmd);
            Process process = pb.start();
            
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
