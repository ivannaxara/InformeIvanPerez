/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

/**
 *
 * @author ivan
 */
public class Yate extends Deportiva {

    private byte numCam;

    public Yate(byte numCam, short potencia, String matricula, String materialConstruccion, String descripcion, float eslora, float manga, float puntal, int maxTripulacion, short año) {
        super(potencia, matricula, materialConstruccion, descripcion, eslora, manga, puntal, maxTripulacion, año);
        this.numCam = numCam;
    }   

    public byte getNumCam() {
        return numCam;
    }

    public void setNumCam(byte numCam) {
        this.numCam = numCam;
    }

    @Override
    public float calculaAlquiler() {
        return super.calculaAlquiler() + getNumCam() * 20;
    }
}
