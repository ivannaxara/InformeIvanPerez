/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

/**
 *
 * @author ivan
 */
public class Velero extends Barco {

    private byte numMas;
    private String claseVelero;
    private char operacionRealizada;
    private int id;

    public Velero() {
        // operacion realizada sin funcion (X) al instanciar nuevo velero
        operacionRealizada = 'X';
    }

    public Velero(byte numMas, String matricula, String materialConstruccion, String descripcion, float eslora, float manga, float puntal, int maxTripulacion, short año, String tipo, int id) {
        super(matricula, materialConstruccion, descripcion, eslora, manga, puntal, maxTripulacion, año);
        this.numMas = numMas;
        this.claseVelero = tipo;
        this.id = id;
        // operacion realizada sin funcion (X) al instanciar nuevo velero
        operacionRealizada = 'X';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClaseVelero() {
        return claseVelero;
    }

    public void setClaseVelero(String claseVelero) {
        this.claseVelero = claseVelero;
    }

    public byte getNumMas() {
        return numMas;
    }

    public void setNumMas(byte numMas) {
        this.numMas = numMas;
    }

    public char getOperacionRealizada() {
        return operacionRealizada;
    }

    public void setOperacionRealizada(char operacionRealizada) {
        this.operacionRealizada = operacionRealizada;
    }

    @Override
    public float calculaAlquiler() {
        return super.calculaAlquiler() + getNumMas() * 5;
    }

    // sobreescribo toString para hacer el insert
    @Override
    public String toString() {
        return super.toString() + numMas + ", '" + claseVelero + "', '" + id +"'";
    }
}