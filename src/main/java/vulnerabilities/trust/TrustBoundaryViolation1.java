package com.checkmarx.cheese.vulnerabilities.trust;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.URL;
import java.security.cert.X509Certificate;

@Path("/api/cheese/https")
@Produces(MediaType.TEXT_PLAIN)
public class TrustBoundaryViolation1 {

    // Vulnerability: Disabling SSL certificate validation
    @GET
    public Response fetchHttps(@QueryParam("url") String url) {
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };
            
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            
            URL urlObj = new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObj.openConnection();
            
            return Response.ok("Connection established").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
