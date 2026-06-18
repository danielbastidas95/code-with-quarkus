package quarkus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.quarkus.runtime.Application;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/temperaturas")
public class TemperaturaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Temperatura> list(){
        return Arrays.asList(
            new Temperatura("Bogotá", 28, 15),
            new Temperatura("Neiva", 40, 20),
            new Temperatura("Medellín", 15, 28)
        );

    }


    @GET
    @Path("/una")
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura medicion(){
        return new Temperatura("Bogotá", 15, 28); 
    }
    

}
