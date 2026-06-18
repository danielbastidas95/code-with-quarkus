package quarkus;

import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/saludar")
public class EcoResources {
    
    @GET
    public String saludar(@QueryParam("mensaje") String mensaje){
        return Optional.ofNullable(mensaje)
        .orElse("No se encontraron datos");
    }

    @GET
    @Path("/{nombre}")
    public String saludarNombre(@PathParam("nombre") String nombre){
        return "Hola: " + nombre;
    }


}
