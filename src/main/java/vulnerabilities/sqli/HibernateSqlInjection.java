package com.checkmarx.cheese.vulnerabilities.sqli;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Path("/api/cheese/hibernate")
@Produces(MediaType.APPLICATION_JSON)
public class HibernateSqlInjection {

    @Inject
    SessionFactory sessionFactory;

    // Vulnerability: Hibernate SQL Injection
    @GET
    public Response searchHibernate(@QueryParam("country") String country) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Cheese WHERE country = '" + country + "'";
            var result = session.createQuery(hql).list();
            
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
