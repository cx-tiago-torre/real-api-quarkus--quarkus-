package com.checkmarx.cheese.vulnerabilities.type_confusion;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/cast")
@Produces(MediaType.TEXT_PLAIN)
public class TypeConfusion1 {

    // Vulnerability: Unsafe type casting
    @POST
    public Response processData(@QueryParam("type") String type, String data) {
        Object obj = data;
        
        if ("number".equals(type)) {
            Integer num = (Integer) obj;  // Unsafe cast
            return Response.ok("Number: " + num).build();
        }
        
        return Response.ok("Processed").build();
    }
}
