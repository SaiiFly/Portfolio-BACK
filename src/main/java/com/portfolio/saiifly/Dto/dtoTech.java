/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.saiifly.Dto;

import javax.validation.constraints.NotBlank;


public class dtoTech {
    @NotBlank
    private String nombre;
    @NotBlank
    private String imgLink;

    public dtoTech() {
    }

    public dtoTech(String nombre, String imgLink) {
        this.nombre = nombre;
        this.imgLink = imgLink;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    
    
    
}
