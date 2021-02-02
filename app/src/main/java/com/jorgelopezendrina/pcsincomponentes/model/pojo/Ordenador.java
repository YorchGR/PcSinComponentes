package com.jorgelopezendrina.pcsincomponentes.model.pojo;

public class Ordenador {

    private long id,idInfor;
    private String marcaPc, modeloPc, created_at,updated_at;

    public Ordenador() {
    }

    public Ordenador(long id, long idInfor, String marcaPc, String modeloPc, String created_at, String updated_at) {
        this.id = id;
        this.idInfor = idInfor;
        this.marcaPc = marcaPc;
        this.modeloPc = modeloPc;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdInfor() {
        return idInfor;
    }

    public void setIdInfor(long idInfor) {
        this.idInfor = idInfor;
    }

    public String getMarcaPc() {
        return marcaPc;
    }

    public void setMarcaPc(String marcaPc) {
        this.marcaPc = marcaPc;
    }

    public String getModeloPc() {
        return modeloPc;
    }

    public void setModeloPc(String modeloPc) {
        this.modeloPc = modeloPc;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "id=" + id +
                ", idInfor=" + idInfor +
                ", marcaPc='" + marcaPc + '\'' +
                ", modeloPc='" + modeloPc + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
