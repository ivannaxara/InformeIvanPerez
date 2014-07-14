/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

/**
 *
 * @author ivan
 */
public class Deportiva extends Barco {

    private short potencia;

    public Deportiva(short potencia, String matricula, String materialConstruccion, String descripcion, float eslora, float manga, float puntal, int maxTripulacion, short año) {
        super(matricula, materialConstruccion, descripcion, eslora, manga, puntal, maxTripulacion, año);
        this.potencia = potencia;
    }

    public short getPotencia() {
        return potencia;
    }

    public void setPotencia(short potencia) {
        this.potencia = potencia;
    }

    @Override
    public float calculaAlquiler() {
        return super.calculaAlquiler() + getPotencia();
    }
}
