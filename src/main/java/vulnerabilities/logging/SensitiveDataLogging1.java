package com.checkmarx.cheese.vulnerabilities.logging;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@Path("/api/cheese/sensitive")
@Produces(MediaType.TEXT_PLAIN)
public class SensitiveDataLogging1 {

    private static final Logger LOG = Logger.getLogger(SensitiveDataLogging1.class);

    // Vulnerability: Logging sensitive data
    @POST
    @Path("/login")
    public Response login(@QueryParam("username") String username,
                         @QueryParam("password") String password) {
        LOG.info("Login attempt - Username: " + username + ", Password: " + password);
        
        return Response.ok("Login processed").build();
    }
}
