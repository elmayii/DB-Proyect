package Dto;

import java.sql.Date;

public class Parte {

    private int id;
    private Date fecha_hora;
    private int votos_total;
    private int electores_eliminados;
    private int electores_agregados;
    private int electores_actual;
    private int colegio_id;

    public Parte(int id, Date fecha_hora, int votos_total, int electores_eliminados, int electores_agregados, int electores_actual, int colegio_id) {
        this.id = id;
        this.fecha_hora = fecha_hora;
        this.votos_total = votos_total;
        this.electores_eliminados = electores_eliminados;
        this.electores_agregados = electores_agregados;
        this.electores_actual = electores_actual;
        this.colegio_id = colegio_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getVotos_total() {
        return votos_total;
    }

    public void setVotos_total(int votos_total) {
        this.votos_total = votos_total;
    }

    public int getElectores_eliminados() {
        return electores_eliminados;
    }

    public void setElectores_eliminados(int electores_eliminados) {
        this.electores_eliminados = electores_eliminados;
    }

    public int getElectores_agregados() {
        return electores_agregados;
    }

    public void setElectores_agregados(int electores_agregados) {
        this.electores_agregados = electores_agregados;
    }

    public int getElectores_actual() {
        return electores_actual;
    }

    public void setElectores_actual(int electores_actual) {
        this.electores_actual = electores_actual;
    }

    public int getColegio_id() {
        return colegio_id;
    }

    public void setColegio_id(int colegio_id) {
        this.colegio_id = colegio_id;
    }
}
