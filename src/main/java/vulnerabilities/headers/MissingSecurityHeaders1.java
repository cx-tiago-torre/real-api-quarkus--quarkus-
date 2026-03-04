package com.checkmarx.cheese.vulnerabilities.headers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/response")
@Produces(MediaType.TEXT_PLAIN)
public class MissingSecurityHeaders1 {

    // Vulnerability: Missing security headers
    @GET
    public Response getData() {
        return Response.ok("Data retrieved")
            // No X-Frame-Options
            // No X-Content-Type-Options
            // No Content-Security-Policy
            // No Strict-Transport-Security
            .build();
    }
}
