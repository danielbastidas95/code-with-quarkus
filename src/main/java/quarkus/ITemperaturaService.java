package quarkus;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.core.Response;

public interface ITemperaturaService {

     List<Temperatura> obtenerTemperaturas();
    
     void addTemperatura(Temperatura temp);

     int maxima();

     boolean IsEmpty();

     Optional<Temperatura> sacarTemperatura(String ciudad);

}
