package com.checkmarx.cheese.vulnerabilities.dom;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/dom")
@Produces(MediaType.TEXT_HTML)
public class DOMBasedXSS1 {

    // Vulnerability: DOM-based XSS
    @GET
    public Response getDOMPage(@QueryParam("name") String name) {
        String html = "<html><head>" +
                     "<script>" +
                     "var userName = '" + name + "';" +
                     "document.write('Welcome ' + userName);" +
                     "</script>" +
                     "</head><body></body></html>";
        
        return Response.ok(html).build();
    }
}
