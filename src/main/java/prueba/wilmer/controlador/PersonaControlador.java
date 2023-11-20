package prueba.wilmer.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import prueba.wilmer.servicio.PersonaServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import prueba.wilmer.modelo.Persona;

//Para tener acceso
@RestController
public class PersonaControlador {

    @PostMapping("/guardarPersona")
    public String guardarPersona(
            @RequestParam(value = "ide") String identificacion,
            @RequestParam(value = "nom") String nombre,
            @RequestParam(value = "ape") String apellido,
            @RequestParam(value = "dir") String direccion,
            @RequestParam(value = "tel") String telefono,
            @RequestParam(value = "fechaNac") String fechaNacimiento)
            {
        String msj = "";
        Persona obj = null;
        if(PersonaServicio.verificarCedulaEcuatoriana(identificacion)){
            obj = new Persona(
                    PersonaServicio.convertirMayusculas(identificacion),
                    PersonaServicio.convertirMayusculas(nombre),
                    PersonaServicio.convertirMayusculas(apellido),
                    PersonaServicio.convertirMayusculas(direccion),
                    PersonaServicio.convertirMayusculas(telefono),
                    PersonaServicio.convertirMayusculas(fechaNacimiento)
            );
            msj = String.format(
                    "<h1 Style='color:green'>Ingreso exitoso</h1> " +
                    "<br><b>Identificacion:</b>  %s " +
                    "<br><b>Nombre:</b> %s " +
                    "<br><b>Apellido:</b>  %s " +
                    "<br><b>Direccion:</b> %s " +
                    "<br><b>Telefono:</b>  %s " +
                    "<br><b>Fecha de Nacimiento:</b>  %s ",
                    obj.getIdentificacion(), obj.getNombre(), obj.getApellido(), obj.getDireccion(), obj.getTelefono(), obj.getFechaNac()
                   );
        }else {
            msj = String.format("<h1 Style='color:red'>Error</h1> La cédula %s de identificacion no es ecuatoriana", identificacion);
        }
        return msj;
    }


    @PostMapping("/guardarPersona2")
    public ResponseEntity<String> guardarPersona(@RequestBody Persona persona){
        String msj = "";
        Persona obj = null;
        if(PersonaServicio.verificarCedulaEcuatoriana(persona.getIdentificacion())){
            obj = new Persona(
                    PersonaServicio.convertirMayusculas(persona.getIdentificacion()),
                    PersonaServicio.convertirMayusculas(persona.getNombre()),
                    PersonaServicio.convertirMayusculas(persona.getApellido()),
                    PersonaServicio.convertirMayusculas(persona.getDireccion()),
                    PersonaServicio.convertirMayusculas(persona.getTelefono()),
                    PersonaServicio.convertirMayusculas(persona.getFechaNac())
            );
            msj = "identificacion: " + obj.getIdentificacion() + "\n" +
                    "Nombre: " + obj.getNombre() + "\n" +
                    "Apellido: " + obj.getApellido() + "\n" +
                    "Direccion: " + obj.getDireccion() + "\n" +
                    "Telefono: " + obj.getTelefono() + "\n";
            System.out.println(msj);


        }else {
            msj = " Ingrese una cedula ecuatoriana ";
            System.out.println(msj);
        }
        return new ResponseEntity<String>(msj, HttpStatus.OK);
    }

    @PostMapping(value = "/guardarPersona3", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> guardarPersona3(@RequestBody MultiValueMap<String, String> persona){
        String msj = "";
        Persona obj = null;
        if(PersonaServicio.verificarCedulaEcuatoriana(persona.getFirst("id"))){
            obj = new Persona(
                    PersonaServicio.convertirMayusculas(persona.getFirst("id")),
                    PersonaServicio.convertirMayusculas(persona.getFirst("nombre")),
                    PersonaServicio.convertirMayusculas(persona.getFirst("apellido")),
                    PersonaServicio.convertirMayusculas(persona.getFirst("direccion")),
                    PersonaServicio.convertirMayusculas(persona.getFirst("telefono")),
                    PersonaServicio.convertirMayusculas(persona.getFirst("fechaNac"))
            );
            msj = "identificacion: " + obj.getIdentificacion() + "\n" +
                    "Nombre: " + obj.getNombre() + "\n" +
                    "Apellido: " + obj.getApellido() + "\n" +
                    "Direccion: " + obj.getDireccion() + "\n" +
                    "Telefono: " + obj.getTelefono() + "\n";
            System.out.println(msj);


        }else {
            msj = " Ingrese una cedula ecuatoriana ";
            System.out.println(msj);
        }
        return new ResponseEntity<String>(msj, HttpStatus.OK);
    }

}
