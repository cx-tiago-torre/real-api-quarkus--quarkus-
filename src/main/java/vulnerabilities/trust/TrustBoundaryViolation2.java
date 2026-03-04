package com.checkmarx.cheese.vulnerabilities.trust;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

@Path("/api/cheese/hostname")
@Produces(MediaType.TEXT_PLAIN)
public class TrustBoundaryViolation2 {

    // Vulnerability: Disabling hostname verification
    @GET
    public Response connectInsecure(@QueryParam("url") String url) {
        try {
            HostnameVerifier allHostsValid = (hostname, session) -> true;
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
            
            URL urlObj = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            
            return Response.ok("Connected").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
