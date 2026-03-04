package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.persistence.EntityManager;

@Path("/api/cheese/native")
@Produces(MediaType.APPLICATION_JSON)
public class SqlInjectionResource6 {

    @Inject
    EntityManager entityManager;

    // Vulnerability: SQL Injection with JPA Native Query
    @GET
    public Response getNativeCheese(@QueryParam("id") String id) {
        try {
            String query = "SELECT * FROM cheese WHERE id = " + id;
            var result = entityManager.createNativeQuery(query).getResultList();
            
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
