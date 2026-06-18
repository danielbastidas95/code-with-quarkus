package quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/temperaturas")
public class TemperaturaResource {

    @GET
    public Temperatura medicion(){
        return new Temperatura("Bogotá", 15, 28); 
    }
    

}
