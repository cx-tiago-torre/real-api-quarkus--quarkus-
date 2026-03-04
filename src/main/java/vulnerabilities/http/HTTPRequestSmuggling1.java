package com.checkmarx.cheese.vulnerabilities.http;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Path("/api/cheese/http-request")
@Produces(MediaType.TEXT_PLAIN)
public class HTTPRequestSmuggling1 {

    // Vulnerability: HTTP request smuggling potential
    @POST
    public Response forwardRequest(@HeaderParam("Host") String host,
                                   @QueryParam("path") String path,
                                   String body) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + host + path))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
            
            HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
            
            return Response.ok(response.body()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
