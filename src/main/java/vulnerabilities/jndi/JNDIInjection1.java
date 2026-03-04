package com.checkmarx.cheese.vulnerabilities.jndi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.naming.Context;
import javax.naming.InitialContext;

@Path("/api/cheese/lookup")
@Produces(MediaType.TEXT_PLAIN)
public class JNDIInjection1 {

    // Vulnerability: JNDI Injection
    @GET
    public Response lookupResource(@QueryParam("name") String name) {
        try {
            Context context = new InitialContext();
            Object obj = context.lookup(name);
            
            return Response.ok("Resource found: " + obj.toString()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
