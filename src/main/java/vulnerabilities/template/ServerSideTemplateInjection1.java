package com.checkmarx.cheese.vulnerabilities.template;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/render")
@Produces(MediaType.TEXT_HTML)
public class ServerSideTemplateInjection1 {

    // Vulnerability: Server-Side Template Injection (SSTI)
    @GET
    public Response renderTemplate(@QueryParam("name") String name) {
        String template = "Hello, " + name + "!";
        // Directly using user input in template
        return Response.ok("<html><body>" + template + "</body></html>").build();
    }
}
