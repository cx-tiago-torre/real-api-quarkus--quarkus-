package com.checkmarx.cheese.vulnerabilities.el;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.el.ExpressionFactory;
import jakarta.el.ValueExpression;
import jakarta.el.ELContext;
import jakarta.el.StandardELContext;

@Path("/api/cheese/expression")
@Produces(MediaType.TEXT_PLAIN)
public class ELInjection1 {

    // Vulnerability: Expression Language Injection
    @GET
    public Response evaluateExpression(@QueryParam("expr") String expression) {
        try {
            ExpressionFactory factory = ExpressionFactory.newInstance();
            ELContext context = new StandardELContext(factory);
            
            ValueExpression ve = factory.createValueExpression(
                context, expression, Object.class);
            Object result = ve.getValue(context);
            
            return Response.ok("Result: " + result).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
