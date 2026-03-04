package com.checkmarx.cheese.vulnerabilities.redirect;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/forward")
@Produces(MediaType.TEXT_HTML)
public class OpenRedirect2 {

    // Vulnerability: URL Redirect via JavaScript
    @GET
    public Response forwardTo(@QueryParam("target") String target) {
        String html = "<html><head>" +
                     "<script>window.location.href='" + target + "';</script>" +
                     "</head><body>Redirecting...</body></html>";
        
        return Response.ok(html).build();
    }
}
