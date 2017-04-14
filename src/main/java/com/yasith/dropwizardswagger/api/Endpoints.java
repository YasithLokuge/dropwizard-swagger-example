package com.yasith.dropwizardswagger.api;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 * Created by yasith on 1/18/17.
 */
@Api("/upload")
@Path("/upload")
public class Endpoints {

    final static Logger log = LoggerFactory.getLogger(Endpoints.class);

    public Endpoints() {
    }

    @Context
    private UriInfo context;

    @GET
    @ApiOperation("Sample GET endpoint")
    @Path("/version")
    public String printVersion(){
        return "v1.0";
    }

    @POST
    @ApiOperation(
        value = "Sample POST endpoint",
        notes = "Sample POST endpoint with Response",
        response = Response.class
    )
    @Consumes(MediaType.APPLICATION_JSON)
    public Response testPost(String data){
        log.info("data recieved : " + data);
        return Response.status(200).entity("Success").build();
    }
}
