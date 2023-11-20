package prueba.wilmer.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
//Constructor de lombok
@AllArgsConstructor
public class Persona {
    @JsonProperty("id")
    private String identificacion;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("fechaNac")
    private String fechaNac;
}