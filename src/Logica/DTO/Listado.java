package Logica.DTO;

public class Listado {
    private int elector_id;
    private int colegio_id;
    private boolean votado;
    private String causa_no_voto;

    public Listado(int elector_id, int colegio_id, boolean votado, String causa_no_voto) {
        this.elector_id = elector_id;
        this.colegio_id = colegio_id;
        this.votado = votado;
        if(!votado){
            this.causa_no_voto = causa_no_voto;
        }
    }

    public int getElector_id() {
        return elector_id;
    }

    public void setElector_id(int elector_id) {
        this.elector_id = elector_id;
    }

    public int getColegio_id() {
        return colegio_id;
    }

    public void setColegio_id(int colegio_id) {
        this.colegio_id = colegio_id;
    }

    public boolean isVotado() {
        return votado;
    }

    public void setVotado(boolean votado) {
        this.votado = votado;
    }

    public String getCausa_no_voto() {
        return causa_no_voto;
    }

    public void setCausa_no_voto(String causa_no_voto) {
        this.causa_no_voto = causa_no_voto;
    }
}
