package com.checkmarx.cheese.vulnerabilities.cmdi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cheese/eval")
@Produces(MediaType.TEXT_PLAIN)
public class CodeInjection {

    // Vulnerability: Code Injection via Script Evaluation
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response evaluateCode(String code) {
        try {
            javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = manager.getEngineByName("JavaScript");
            Object result = engine.eval(code);
            
            return Response.ok(result.toString()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
