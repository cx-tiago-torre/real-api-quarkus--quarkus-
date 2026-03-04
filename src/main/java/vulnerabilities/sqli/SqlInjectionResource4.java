package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Path("/api/cheese/delete")
public class SqlInjectionResource4 {

    @Inject
    DataSource dataSource;

    // Vulnerability: SQL Injection in DELETE statement
    @DELETE
    @Path("/{id}")
    public Response deleteCheese(@PathParam("id") String id) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String query = "DELETE FROM cheese WHERE id = " + id;
            stmt.executeUpdate(query);
            
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
