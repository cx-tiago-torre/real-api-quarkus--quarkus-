package com.checkmarx.cheese.vulnerabilities.redis;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.quarkus.redis.client.RedisClient;
import jakarta.inject.Inject;
import io.vertx.redis.client.Request;

@Path("/api/cheese/redis")
@Produces(MediaType.TEXT_PLAIN)
public class RedisInjection1 {

    @Inject
    RedisClient redisClient;

    // Vulnerability: Redis command injection
    @GET
    public Response getRedisValue(@QueryParam("key") String key) {
        Request request = Request.cmd(io.vertx.redis.client.Command.GET).arg(key);
        var response = redisClient.send(request);
        
        return Response.ok("Value retrieved").build();
    }
}
