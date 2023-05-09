package Dto;

public class Circunscripcion {
    private String nombre;
    private int municipio_id;

    private int id;

    public Circunscripcion(int id,String nombre, int municipio_id) {
        this.nombre = nombre;
        this.municipio_id = municipio_id;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
