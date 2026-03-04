package com.checkmarx.cheese.vulnerabilities.deserialization;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/api/cheese/json")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UnsafeDeserialization2 {

    // Vulnerability: Insecure JSON deserialization with polymorphic types
    @POST
    public Response deserializeJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enableDefaultTyping();  // Vulnerable configuration
            
            Object obj = mapper.readValue(json, Object.class);
            
            return Response.ok(obj).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
