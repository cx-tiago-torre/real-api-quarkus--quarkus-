package com.checkmarx.cheese.vulnerabilities.logging;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@Path("/api/cheese/log")
@Produces(MediaType.TEXT_PLAIN)
public class LogInjection1 {

    private static final Logger LOG = Logger.getLogger(LogInjection1.class);

    // Vulnerability: Log Injection
    @POST
    public Response logMessage(@QueryParam("message") String message) {
        LOG.info("User message: " + message);
        return Response.ok("Message logged").build();
    }
}
