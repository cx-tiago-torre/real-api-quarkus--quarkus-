package com.checkmarx.cheese.vulnerabilities.email;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;

@Path("/api/cheese/mail")
@Produces(MediaType.TEXT_PLAIN)
public class EmailInjection1 {

    @Inject
    Mailer mailer;

    // Vulnerability: Email header injection
    @POST
    public Response sendEmail(@FormParam("to") String to,
                             @FormParam("subject") String subject,
                             @FormParam("body") String body) {
        mailer.send(Mail.withText(to, subject, body));
        return Response.ok("Email sent").build();
    }
}
