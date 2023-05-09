package Dto;

public class CDR {

    private int id;
    private String nombre;
    private String nombre_presidente;
    private int colegio_id;

    public CDR(int id, String nombre, String nombre_presidente, int colegio_id) {
        this.id = id;
        this.nombre = nombre;
        this.nombre_presidente = nombre_presidente;
        this.colegio_id = colegio_id;
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

    public String getNombre_presidente() {
        return nombre_presidente;
    }

    public void setNombre_presidente(String nombre_presidente) {
        this.nombre_presidente = nombre_presidente;
    }

    public int getColegio_id() {
        return colegio_id;
    }

    public void setColegio_id(int colegio_id) {
        this.colegio_id = colegio_id;
    }
}
