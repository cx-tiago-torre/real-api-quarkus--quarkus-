package com.checkmarx.cheese.vulnerabilities.graphql;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/graphql")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GraphQLInjection1 {

    // Vulnerability: GraphQL injection
    @POST
    public Response executeQuery(String query) {
        // Directly executing GraphQL query without validation
        String graphqlQuery = "{ cheese(id: \"" + query + "\") { name, price } }";
        
        return Response.ok("{\"data\":{}}").build();
    }
}
