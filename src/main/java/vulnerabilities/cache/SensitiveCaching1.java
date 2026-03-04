package com.checkmarx.cheese.vulnerabilities.cache;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.CacheControl;

@Path("/api/cheese/sensitive-data")
@Produces(MediaType.APPLICATION_JSON)
public class SensitiveCaching1 {

    // Vulnerability: Caching sensitive data
    @GET
    public Response getSensitiveData(@HeaderParam("Authorization") String auth) {
        CacheControl cacheControl = new CacheControl();
        cacheControl.setMaxAge(3600);  // Cache for 1 hour
        
        return Response.ok("{\"ssn\":\"123-45-6789\",\"creditCard\":\"4111111111111111\"}")
            .cacheControl(cacheControl)
            .build();
    }
}
