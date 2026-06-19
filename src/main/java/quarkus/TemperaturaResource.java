package quarkus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/temperaturas")
public class TemperaturaResource {

    private TemperaturaService temperaturas;

    @Inject
    public TemperaturaResource(TemperaturaService temperaturas) {
        this.temperaturas = temperaturas;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura agregar(Temperatura temp){
        temperaturas.addTemperatura(temp);
        return temp;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list(){
        return temperaturas.obtenerTemperaturas();
    }

    @GET
    @Path("/maximo")
    public Response maxima(){
        if(temperaturas.IsEmpty()){
            return Response.status(404).entity("No hay temperaturas registradas").build();
        } else {
            int temperaturaMax = temperaturas.maxima();
            return Response.ok().entity(temperaturaMax).build();
        }
    }

    @GET
    @Path("/{ciudad}")
    public Temperatura temperaturaCiudad(@PathParam("ciudad") String ciudad){
        return temperaturas.sacarTemperatura(ciudad)
        .get();

    }
    
}
