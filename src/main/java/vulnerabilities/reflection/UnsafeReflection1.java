package com.checkmarx.cheese.vulnerabilities.reflection;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.reflect.Method;

@Path("/api/cheese/reflect")
@Produces(MediaType.TEXT_PLAIN)
public class UnsafeReflection1 {

    // Vulnerability: Unsafe use of reflection
    @GET
    public Response invokeMethod(@QueryParam("className") String className,
                                 @QueryParam("method") String methodName) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getMethod(methodName);
            Object result = method.invoke(clazz.newInstance());
            
            return Response.ok("Result: " + result).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
