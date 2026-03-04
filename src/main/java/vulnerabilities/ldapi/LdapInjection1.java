package com.checkmarx.cheese.vulnerabilities.ldapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import java.util.Hashtable;

@Path("/api/cheese/ldap")
@Produces(MediaType.APPLICATION_JSON)
public class LdapInjection1 {

    // Vulnerability: LDAP Injection
    @GET
    public Response searchUser(@QueryParam("username") String username) {
        try {
            Hashtable<String, String> env = new Hashtable<>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.PROVIDER_URL, "ldap://localhost:389");
            
            DirContext ctx = new InitialDirContext(env);
            
            String filter = "(uid=" + username + ")";
            SearchControls searchControls = new SearchControls();
            searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            
            var results = ctx.search("dc=example,dc=com", filter, searchControls);
            
            return Response.ok("Search completed").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
