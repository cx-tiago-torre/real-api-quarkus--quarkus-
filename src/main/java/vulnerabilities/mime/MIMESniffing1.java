package com.checkmarx.cheese.vulnerabilities.mime;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/content")
@Produces(MediaType.TEXT_HTML)
public class MIMESniffing1 {

    // Vulnerability: No X-Content-Type-Options header
    @GET
    public Response getContent(@QueryParam("type") String type) {
        return Response.ok("<html><body>Content</body></html>")
            .type(type)  // User-controlled content type
            .build();
    }
}
