/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.saiifly.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String institucionE;
    @NotBlank
    private String tituloE;
    @NotBlank
    private Integer fechaInE;
    @NotBlank
    private Integer fechaFinE;
    @NotBlank
    private String imgLinkE;

    public dtoEducacion() {
    }

    public dtoEducacion(String institucionE, String tituloE, Integer fechaInE, Integer fechaFinE, String imgLinkE) {
        this.institucionE = institucionE;
        this.tituloE = tituloE;
        this.fechaInE = fechaInE;
        this.fechaFinE = fechaFinE;
        this.imgLinkE = imgLinkE;
    }

    public String getInstitucionE() {
        return institucionE;
    }

    public void setInstitucionE(String institucionE) {
        this.institucionE = institucionE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }

    public Integer getFechaInE() {
        return fechaInE;
    }

    public void setFechaInE(Integer fechaInE) {
        this.fechaInE = fechaInE;
    }

    public Integer getFechaFinE() {
        return fechaFinE;
    }

    public void setFechaFinE(Integer fechaFinE) {
        this.fechaFinE = fechaFinE;
    }

    public String getImgLinkE() {
        return imgLinkE;
    }

    public void setImgLinkE(String imgLinkE) {
        this.imgLinkE = imgLinkE;
    }

    
    
    
}
