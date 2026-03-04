package com.checkmarx.cheese.vulnerabilities.debug;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Path("/api/cheese/metrics")
@Produces(MediaType.APPLICATION_JSON)
public class DebugEndpointExposure1 {

    // Vulnerability: Exposing debug/metrics endpoint
    @GET
    public Response getMetrics() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        
        return Response.ok("{" +
            "\"heapMemory\":\"" + memoryBean.getHeapMemoryUsage() + "\"," +
            "\"threads\":\"" + ManagementFactory.getThreadMXBean().getThreadCount() + "\"," +
            "\"runtime\":\"" + ManagementFactory.getRuntimeMXBean().getUptime() + "\"" +
            "}").build();
    }
}
