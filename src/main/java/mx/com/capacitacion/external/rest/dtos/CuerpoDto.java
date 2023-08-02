package mx.com.capacitacion.external.rest.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import mx.com.capacitacion.core.entity.Cuerpo;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@NoArgsConstructor//puede no tener ninguno de los elementos
@AllArgsConstructor //tiene que estar todos los elementos (not null)
@Builder //construcctor
@Getter //getters
@Setter //Setters
@Schema(name = "Cuerpo", description = "Entidad para la busqueda por parametros para CCT.")
public class CuerpoDto {
    @JsonProperty
    @Schema(description = "Es el nombre de la entidad")
    private String nombre;

    public Cuerpo toEntity() {
        return Cuerpo.builder()
                .nombre(this.nombre)
                .build();
    }
}

