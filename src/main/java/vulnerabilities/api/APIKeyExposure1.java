package com.checkmarx.cheese.vulnerabilities.api;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/api-key")
@Produces(MediaType.APPLICATION_JSON)
public class APIKeyExposure1 {

    // Vulnerability: Hardcoded API key
    private static final String API_KEY = "sk-1234567890abcdefghijklmnopqrstuv";
    private static final String AWS_ACCESS_KEY = "AKIAIOSFODNN7EXAMPLE";
    private static final String AWS_SECRET_KEY = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

    @GET
    public Response getConfig() {
        return Response.ok("{\"apiKey\":\"" + API_KEY + "\"}").build();
    }
}
