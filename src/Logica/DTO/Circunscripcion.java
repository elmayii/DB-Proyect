package Logica.DTO;

public class Circunscripcion {
    private String nombre;
    private int municipio_id;

    public Circunscripcion(String nombre, int municipio_id) {
        this.nombre = nombre;
        this.municipio_id = municipio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(int municipio_id) {
        this.municipio_id = municipio_id;
    }
}
