package com.checkmarx.cheese.vulnerabilities.sql_second_order;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Path("/api/cheese/second-order")
@Produces(MediaType.APPLICATION_JSON)
public class SecondOrderSQLInjection1 {

    @Inject
    DataSource dataSource;
    
    private Map<String, String> userCache = new HashMap<>();

    // Vulnerability: Second-order SQL injection
    @POST
    @Path("/store")
    public Response storeUserInput(@QueryParam("id") String id,
                                   @QueryParam("name") String name) {
        userCache.put(id, name);
        return Response.ok("Stored").build();
    }

    @GET
    @Path("/execute")
    public Response executeQuery(@QueryParam("id") String id) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String storedName = userCache.get(id);
            String query = "SELECT * FROM cheese WHERE name = '" + storedName + "'";
            stmt.executeQuery(query);
            
            return Response.ok("Query executed").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
