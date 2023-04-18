package Logica.DTO;

public class Colegio {
    private String nombre;
    private String dir;
    private int circunscripcion_id;

    public Colegio(String nombre, String dir, int circunscripcion_id) {
        this.nombre = nombre;
        this.dir = dir;
        this.circunscripcion_id = circunscripcion_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getCircunscripcion_id() {
        return circunscripcion_id;
    }

    public void setCircunscripcion_id(int circunscripcion_id) {
        this.circunscripcion_id = circunscripcion_id;
    }
}
