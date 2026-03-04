package com.checkmarx.cheese.vulnerabilities.dos;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/api/cheese/allocate")
@Produces(MediaType.TEXT_PLAIN)
public class MemoryExhaustion1 {

    // Vulnerability: Uncontrolled memory allocation
    @GET
    public Response allocateMemory(@QueryParam("size") int size) {
        List<byte[]> list = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            list.add(new byte[1024 * 1024]);  // 1MB per iteration
        }
        
        return Response.ok("Allocated: " + list.size() + " MB").build();
    }
}
