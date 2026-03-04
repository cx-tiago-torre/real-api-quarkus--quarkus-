package com.checkmarx.cheese.vulnerabilities.input;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/buffer")
@Produces(MediaType.TEXT_PLAIN)
public class BufferOverflow1 {

    // Vulnerability: Buffer overflow potential
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response processData(String data) {
        byte[] buffer = new byte[100];
        byte[] input = data.getBytes();
        
        // No bounds checking
        System.arraycopy(input, 0, buffer, 0, input.length);
        
        return Response.ok("Data processed").build();
    }
}
