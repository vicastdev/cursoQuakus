package mx.com.capacitacion.external.rest.controllers;

import mx.com.capacitacion.external.rest.dtos.CuerpoDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/saludar")
public class Saludo {
    @GET
    //Este metodo se encuentra en la ruta /saludar y recibe un mensaje mediante la url
    // , si lo recibe, escribe el mensaje en pantalla, si no (orelse) escribe "no recibi mensaje"
    public String hola(@QueryParam("mensaje") String mensaje){
        return Optional.ofNullable(mensaje).orElse("No recibi mensaje");
    }
    @GET
    //en este nuevo end point estamos pasando el parametro de la url al parametro del metodo
    //tomamos el parametro de la url con el Pathparam y se lo damos al parametro de string nombre
    @Path("/{nombre}")
    public String saludo (@PathParam("nombre")String nombre) {
        return "Hola, " + nombre;
    }
    @GET
    @Path("/{nombre}/gritar")
    public String gritar (@PathParam("nombre")String nombre) {
        return "HOLA, " + nombre.toUpperCase();
    }
    @POST
    @Path("/registrar")
    @APIResponse(responseCode = "200", description = "Operation successful", content = @Content(schema =@Schema( implementation = String.class)))
    @APIResponse(responseCode = "404", description = "Recurso no encontrado", content = @Content(schema = @Schema(implementation = String.class)))
    @Operation(operationId = "postHello", summary = "Post Hello", description="Post Hello")
    public String registro(CuerpoDto cuerpoDto){
        var cuerpo = cuerpoDto.toEntity();
        return cuerpo.getNombre();
    }

}
