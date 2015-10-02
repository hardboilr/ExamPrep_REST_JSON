/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import utility.RandomDataGenerator;

/**
 * REST Web Service
 *
 * @author Tobias Jacobsen
 */
@Path("/addresses")
public class RestService {

    @Context
    private UriInfo context;
    Gson gson;
    JsonObject jsonObj;

    public RestService() {
    }

    @GET
    @Path("{number}/{person}")
    @Produces("application/json")
    public Response getQuote(@PathParam("number") int number, @PathParam("person") String person) {
        String data = RandomDataGenerator.getData(number, person);
        return Response.status(Response.Status.OK).entity(data).build();
    }
}
