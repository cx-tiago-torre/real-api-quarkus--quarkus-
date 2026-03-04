package com.checkmarx.cheese.vulnerabilities.info;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/comments")
@Produces(MediaType.TEXT_HTML)
public class InformationDisclosure3 {

    // Vulnerability: Sensitive comments in response
    @GET
    public Response getPage() {
        String html = "<html><body>" +
            "<!-- Database: postgres://admin:P@ssw0rd!@localhost:5432/db -->" +
            "<!-- API Key: sk-1234567890abcdef -->" +
            "<h1>Welcome to Cheese App</h1>" +
            "</body></html>";
        
        return Response.ok(html).build();
    }
}
