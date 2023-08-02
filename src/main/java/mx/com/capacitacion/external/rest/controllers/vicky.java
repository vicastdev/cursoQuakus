package mx.com.capacitacion.external.rest.controllers;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/vicky")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name="Mi propio end point")
public class vicky {
    @ConfigProperty(name = "vicky.message")
    String message;
    @ConfigProperty(name = "vicky.suffix", defaultValue = "!")
    String suffix;

    @ConfigProperty(name = "vicky.name")
    Optional<String> name;
        @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String mensaje(){
    return message +" "+ name.orElse("BB") +suffix;
        }

}
