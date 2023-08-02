package mx.com.capacitacion.core.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder //construcctor
@Getter //getters
@Setter
public class Cuerpo {
    private String nombre;
}
