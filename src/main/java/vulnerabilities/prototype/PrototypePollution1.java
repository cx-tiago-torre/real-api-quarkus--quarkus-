package com.checkmarx.cheese.vulnerabilities.prototype;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Path("/api/cheese/merge")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PrototypePollution1 {

    // Vulnerability: Prototype pollution-like behavior
    @POST
    public Response mergeObjects(String jsonData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode node = (ObjectNode) mapper.readTree(jsonData);
            
            // Merging without validation
            return Response.ok(node).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
