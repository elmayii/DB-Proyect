package Logica.DTO;

import Logica.DTO.Elector;

import java.sql.Date;

public class Nominado extends Elector {
    private int edad;
    private String integracion_revolucionaria;
    private String telefono;
    private String ocupacion;
    private String profesion;
    private String datos_biograficos;
    private int vuelta;
    private int votos;
    private int circunscripcion;

    private int id;

    public Nominado(int id,String nombre, String apellidos,Date fecha_nacimiento, String direccion, int edad, String integracion_revolucionaria, String telefono, String ocupacion, String profesion, String datos_biograficos, int vuelta, int votos, int circunscripcion) {
        super(id,nombre,apellidos,fecha_nacimiento,direccion);
        this.edad=edad;
        this.integracion_revolucionaria = integracion_revolucionaria;
        this.telefono = telefono;
        this.ocupacion = ocupacion;
        this.profesion = profesion;
        this.datos_biograficos = datos_biograficos;
        this.vuelta = vuelta;
        this.votos = votos;
        this.circunscripcion = circunscripcion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIntegracion_revolucionaria() {
        return integracion_revolucionaria;
    }

    public void setIntegracion_revolucionaria(String integracion_revolucionaria) {
        this.integracion_revolucionaria = integracion_revolucionaria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDatos_biograficos() {
        return datos_biograficos;
    }

    public void setDatos_biograficos(String datos_biograficos) {
        this.datos_biograficos = datos_biograficos;
    }

    public int getVuelta() {
        return vuelta;
    }

    public void setVuelta(int vuelta) {
        this.vuelta = vuelta;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(int circunscripcion) {
        this.circunscripcion = circunscripcion;
    }
}
