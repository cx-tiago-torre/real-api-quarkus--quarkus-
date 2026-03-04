package com.checkmarx.cheese.vulnerabilities.regex;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Path("/api/cheese/validate")
@Produces(MediaType.TEXT_PLAIN)
public class RegexDOS1 {

    // Vulnerability: Regular Expression Denial of Service (ReDoS)
    @GET
    public Response validateEmail(@QueryParam("email") String email) {
        String regex = "(a+)+b";  // Vulnerable regex
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        boolean isValid = matcher.matches();
        return Response.ok("Valid: " + isValid).build();
    }
}
