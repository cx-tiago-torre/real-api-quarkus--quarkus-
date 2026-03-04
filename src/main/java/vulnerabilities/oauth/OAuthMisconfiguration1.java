package com.checkmarx.cheese.vulnerabilities.oauth;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;

@Path("/api/cheese/oauth")
public class OAuthMisconfiguration1 {

    // Vulnerability: OAuth redirect URI not validated
    @GET
    @Path("/callback")
    public Response oauthCallback(@QueryParam("code") String code,
                                  @QueryParam("redirect_uri") String redirectUri) {
        return Response.seeOther(URI.create(redirectUri + "?code=" + code)).build();
    }
}
