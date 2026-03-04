package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Path("/api/cheese/filter")
@Produces(MediaType.APPLICATION_JSON)
public class SqlInjectionResource2 {

    @Inject
    DataSource dataSource;

    // Vulnerability: SQL Injection in ORDER BY clause
    @GET
    public Response filterCheese(@QueryParam("orderBy") String orderBy) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String query = "SELECT * FROM cheese ORDER BY " + orderBy;
            ResultSet rs = stmt.executeQuery(query);
            
            StringBuilder result = new StringBuilder();
            while (rs.next()) {
                result.append(rs.getString("name")).append(",");
            }
            
            return Response.ok(result.toString()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
