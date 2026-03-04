package com.checkmarx.cheese.vulnerabilities.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Path("/api/cheese/connection")
@Produces(MediaType.TEXT_PLAIN)
public class ResourceLeak2 {

    // Vulnerability: Database connection not properly closed
    @GET
    public Response queryDatabase() {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "user", "pass");
            Statement stmt = conn.createStatement();
            // Connection and statement not closed
            
            return Response.ok("Query executed").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
