package com.umariana.sistemas.camiloservice.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sistemas on 5/06/17.
 */

public class Presidentes {

    @SerializedName("idnombre")
    @Expose
    private String idnombre;
    @SerializedName("idmunicipio")
    @Expose
    private String idmunicipio;
    @SerializedName("iddepartamento")
    @Expose
    private String iddepartamento;
    @SerializedName("idveredabarrio")
    @Expose
    private String idveredabarrio;

    public String getIdnombre() {
        return "Sr. " +  idnombre;
    }

    public void setIdnombre(String idnombre) {
        this.idnombre = idnombre;
    }

    public String getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(String idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(String iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getIdveredabarrio() {
        return idveredabarrio;
    }

    public void setIdveredabarrio(String idveredabarrio) {
        this.idveredabarrio = idveredabarrio;
    }

}