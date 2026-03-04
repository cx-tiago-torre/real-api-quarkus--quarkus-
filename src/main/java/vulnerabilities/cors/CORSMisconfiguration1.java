package com.checkmarx.cheese.vulnerabilities.cors;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/data")
@Produces(MediaType.APPLICATION_JSON)
public class CORSMisconfiguration1 {

    // Vulnerability: Overly permissive CORS
    @GET
    public Response getData() {
        return Response.ok("{\"data\":\"sensitive\"}")
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Credentials", "true")
            .build();
    }
}
