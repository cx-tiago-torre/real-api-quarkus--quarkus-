package com.checkmarx.cheese.vulnerabilities.config;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/config")
@Produces(MediaType.APPLICATION_JSON)
public class ConfigurationExposure1 {

    // Vulnerability: Exposing configuration details
    @GET
    public Response getConfiguration() {
        return Response.ok("{" +
            "\"database\":\"jdbc:postgresql://prod-db.internal:5432/cheese\"," +
            "\"db_user\":\"admin\"," +
            "\"db_password\":\"ProdPass2024!\"," +
            "\"redis\":\"redis://prod-cache.internal:6379\"," +
            "\"smtp_server\":\"smtp.company.com\"," +
            "\"api_endpoint\":\"https://internal-api.company.com\"" +
            "}").build();
    }
}
