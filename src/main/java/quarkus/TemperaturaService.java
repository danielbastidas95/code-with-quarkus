package quarkus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TemperaturaService implements ITemperaturaService {

    private List<Temperatura> valores = new ArrayList<>();

    public void addTemperatura(Temperatura temp){
        valores.add(temp);
    }

    public int maxima(){     
        return valores.stream().mapToInt(Temperatura::getMaximo).max().getAsInt();
    }

    public boolean IsEmpty(){
        return valores.isEmpty();

    }

    @Override
    public List<Temperatura> obtenerTemperaturas() {
        // TODO Auto-generated method stub
        return Collections.unmodifiableList(valores);
    }

    @Override
    public Optional<Temperatura> sacarTemperatura(String ciudad) {
        return valores.stream().
        filter(t -> t.getCiudad().
        equals(ciudad)).findAny();
    }

    


}
