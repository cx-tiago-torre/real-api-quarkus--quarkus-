package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Path("/api/cheese/update")
@Consumes(MediaType.APPLICATION_JSON)
public class SqlInjectionResource3 {

    @Inject
    DataSource dataSource;

    // Vulnerability: SQL Injection in UPDATE statement
    @PUT
    @Path("/{id}")
    public Response updateCheese(@PathParam("id") String id, @QueryParam("price") String price) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String query = "UPDATE cheese SET price = " + price + " WHERE id = " + id;
            stmt.executeUpdate(query);
            
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
