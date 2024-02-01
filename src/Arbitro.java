public class Arbitro {
    private String nombre;

    private String colegio;

    private int velocidad;

    private int acierto;

    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = (int) Math.floor(Math.random()*(100-0+1)+0);
    }

    public int getAcierto() {
        return acierto;
    }

    public void setAcierto(int acierto) {
        this.acierto = (int) Math.floor(Math.random()*(100-0+1)+0);
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "nombre='" + nombre + '\'' +
                ", colegio='" + colegio + '\'' +
                ", velocidad=" + velocidad +
                ", acierto=" + acierto +
                ", activo=" + activo +
                '}';
    }
}
