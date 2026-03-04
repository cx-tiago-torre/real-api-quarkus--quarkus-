package com.checkmarx.cheese.vulnerabilities.mass_assignment;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/api/cheese/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MassAssignment1 {

    // Vulnerability: Mass assignment
    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") String id, String jsonData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Directly deserializing without filtering fields
            Object user = mapper.readValue(jsonData, Object.class);
            
            return Response.ok(user).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
