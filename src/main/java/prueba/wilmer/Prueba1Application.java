package prueba.wilmer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Prueba1Application {

    public static void main(String[] args) {
        SpringApplication.run(Prueba1Application.class, args);
    }

    @GetMapping("/hello")
    public static String hello(
            @RequestParam(value = "nombre", defaultValue = "Wilmer") String nombre,
            @RequestParam(value = "apellido", defaultValue = "Shagñay") String apellido,
            @RequestParam(value = "direccion", defaultValue = "Santa Martha") String direccion,
            @RequestParam(value = "telefono", defaultValue = "0932839238") String telefono,
            @RequestParam(value = "fechaNac", defaultValue = "1992/03/23") String fechaNac
    ){
        String mensaje = "";
         mensaje = String.format(
                "<h1>Datos personales</h1>" +
                        "<b>Nombre:</b> %s" +
                        "<br><b>Apellido:</b> %s " +
                        "<br><b>Dirección:</b> %s " +
                        "<br><b>Telefono:</b> %s" +
                        "<br><b>Fecha Nacimiento:</b> %s",
                nombre,
                apellido,
                direccion,
                telefono,
                fechaNac
        );
        return mensaje;
    }

}
