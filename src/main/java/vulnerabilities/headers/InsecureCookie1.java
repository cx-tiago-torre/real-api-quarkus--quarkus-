package com.checkmarx.cheese.vulnerabilities.headers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/setcookie")
@Produces(MediaType.TEXT_PLAIN)
public class InsecureCookie1 {

    // Vulnerability: Insecure cookie attributes
    @GET
    public Response setCookie(@QueryParam("value") String value) {
        return Response.ok("Cookie set")
            .header("Set-Cookie", "AuthToken=" + value + "; Path=/")
            .build();
    }
}
