package com.checkmarx.cheese.vulnerabilities.redirect;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;

@Path("/api/cheese/redirect")
public class OpenRedirect1 {

    // Vulnerability: Open Redirect
    @GET
    public Response redirect(@QueryParam("url") String url) {
        return Response.seeOther(URI.create(url)).build();
    }
}
