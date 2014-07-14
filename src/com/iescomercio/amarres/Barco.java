/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

import java.io.Serializable;

/**
 *
 * @author ivan
 */
public class Barco implements Serializable {

    private String matricula, materialConstruccion, descripcion;
    private float eslora, manga, puntal;
    private int maxTripulacion;
    private short año;

    public Barco() {
    }

    public Barco(String matricula, String materialConstruccion, String descripcion, float eslora, float manga, float puntal, int maxTripulacion, short año) {
        this.matricula = matricula;
        this.materialConstruccion = materialConstruccion;
        this.descripcion = descripcion;
        this.eslora = eslora;
        this.manga = manga;
        this.puntal = puntal;
        this.maxTripulacion = maxTripulacion;
        this.año = año;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public void setMaterialConstruccion(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getEslora() {
        return eslora;
    }

    public void setEslora(float eslora) {
        this.eslora = eslora;
    }

    public float getManga() {
        return manga;
    }

    public void setManga(float manga) {
        this.manga = manga;
    }

    public float getPuntal() {
        return puntal;
    }

    public void setPuntal(float puntal) {
        this.puntal = puntal;
    }

    public int getMaxTripulacion() {
        return maxTripulacion;
    }

    public void setMaxTripulacion(int maxTripulacion) {
        this.maxTripulacion = maxTripulacion;
    }

    public short getAño() {
        return año;
    }

    public void setAño(short año) {
        this.año = año;
    }

    public float calculaAlquiler() {
        return 10 * 2 * getEslora();
    }
    
    @Override
    public String toString() {
        return "'" + matricula + "', '" + materialConstruccion + "', '" + descripcion + "', " + eslora + ", " + manga + ", " + puntal + ", " + maxTripulacion + ", " + año +", ";
    }
}