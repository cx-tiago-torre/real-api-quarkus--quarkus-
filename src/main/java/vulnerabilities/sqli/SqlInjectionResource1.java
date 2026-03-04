package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Path("/api/cheese/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SqlInjectionResource1 {

    @Inject
    DataSource dataSource;

    // Vulnerability: SQL Injection via String concatenation
    @GET
    public Response searchCheese(@QueryParam("name") String name) {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            
            String query = "SELECT * FROM cheese WHERE name = '" + name + "'";
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
