package mx.com.capacitacion.external.rest.controllers;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name= "Control de capacitacion")
public class test {
    @POST
    @Path("/{ID}")
    @APIResponse(responseCode = "200", description = "Operation successful", content = @Content(schema =@Schema(type = SchemaType.ARRAY, implementation = test.class)))
    @APIResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content(schema = @Schema(implementation = test.class)))
    @Operation(operationId = "postHello", summary = "Post Hello", description="Post Hello")
    public String hello (@PathParam("ID") Integer id, @QueryParam("message")String message){
        return id + " " + message;
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hola como vas";
    }

}
