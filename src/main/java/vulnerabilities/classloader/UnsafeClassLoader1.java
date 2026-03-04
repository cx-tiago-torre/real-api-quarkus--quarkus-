package com.checkmarx.cheese.vulnerabilities.classloader;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URLClassLoader;
import java.net.URL;

@Path("/api/cheese/loadclass")
@Produces(MediaType.TEXT_PLAIN)
public class UnsafeClassLoader1 {

    // Vulnerability: Unsafe class loading
    @GET
    public Response loadClass(@QueryParam("url") String url,
                             @QueryParam("className") String className) {
        try {
            URL[] urls = {new URL(url)};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class<?> clazz = classLoader.loadClass(className);
            
            return Response.ok("Class loaded: " + clazz.getName()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
