package com.checkmarx.cheese.vulnerabilities.nosqli;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.Document;

@Path("/api/cheese/mongo")
@Produces(MediaType.APPLICATION_JSON)
public class NoSqlInjectionMongo {

    @Inject
    MongoClient mongoClient;

    // Vulnerability: NoSQL Injection in MongoDB
    @GET
    public Response searchMongo(@QueryParam("name") String name) {
        try {
            MongoCollection<Document> collection = mongoClient
                .getDatabase("cheesedb")
                .getCollection("cheese");
            
            // Vulnerable: Direct string concatenation
            String query = "{ name: '" + name + "' }";
            Document doc = Document.parse(query);
            
            var result = collection.find(doc).first();
            return Response.ok(result).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
