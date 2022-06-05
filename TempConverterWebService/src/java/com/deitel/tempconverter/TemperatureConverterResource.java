/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deitel.tempconverter;

import java.io.StringWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;

/**
 * REST Web Service
 *
 * @author acer
 */
@Path("temperature")
public class TemperatureConverterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TemperatureConverterResource
     */
    public TemperatureConverterResource() {
    }

    /**
     * Retrieves representation of an instance of com.deitel.tempconverter.TemperatureConverterResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{temp}")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@PathParam("temp") float tempC) {
        float tempF = (tempC * 9/5) + 32;
        String message = "Celcius " + tempC + " is " + tempF + " in Farenhite! ";
        StringWriter writer = new StringWriter();
        JAXB.marshal(message, writer);
        return writer.toString();
    }

    /**
     * PUT method for updating or creating an instance of TemperatureConverterResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
