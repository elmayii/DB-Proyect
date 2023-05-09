package Dto;

import java.sql.Date;

public class Elector {
    protected String nombre;
    protected String apellido;
    protected Date fecha_nacimiento;
    protected String direccion;
    private int cdr_id;
    private int id;
    private int flag;

    public Elector(int id, String nombre, String apellido, Date fecha_nacimiento, String direccion, int cdr_id, int flag) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.cdr_id = cdr_id;
        this.id=id;
        this.flag=flag;
    }

    public Elector(int id,String nombre, String apellido, Date fecha_nacimiento, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCdr_id() {
        return cdr_id;
    }

    public void setCdr_id(int cdr_id) {
        this.cdr_id = cdr_id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
