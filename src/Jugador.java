public class Jugador {
    private String nombre;
    private String posicion;
    private int velocidad;
    private int regate;

    private boolean lesionado;

    /*public Jugador(String nombre, String posicion, int velocidad, int regate, boolean lesionado) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.velocidad = velocidad;
        this.regate = regate;
        this.lesionado = lesionado;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = (int) Math.floor(Math.random()*(100-0+1)+0);
    }

    public int getRegate() {
        return regate;
    }

    public void setRegate(int regate) {
        this.regate = (int) Math.floor(Math.random()*(100-0+1)+0);    }

    public boolean isLesionado() {
        return lesionado;
    }

    public void setLesionado(boolean lesionado) {
        this.lesionado = lesionado;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", velocidad=" + velocidad +
                ", regate=" + regate +
                ", lesionado=" + lesionado +
                '}';
    }
}
