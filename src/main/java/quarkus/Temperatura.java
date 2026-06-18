package quarkus;

public class Temperatura {
    private String ciudad;
    private int maximo;
    private int minimo;

    
    public Temperatura() {
    }

    public Temperatura(String ciudad, int maximo, int minimo) {
        this.ciudad = ciudad;
        this.maximo = maximo;
        this.minimo = minimo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
        result = prime * result + maximo;
        result = prime * result + minimo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Temperatura other = (Temperatura) obj;
        if (ciudad == null) {
            if (other.ciudad != null)
                return false;
        } else if (!ciudad.equals(other.ciudad))
            return false;
        if (maximo != other.maximo)
            return false;
        if (minimo != other.minimo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Temperatura [ciudad=" + ciudad + ", maximo=" + maximo + ", minimo=" + minimo + "]";
    }

    

    

    

}
