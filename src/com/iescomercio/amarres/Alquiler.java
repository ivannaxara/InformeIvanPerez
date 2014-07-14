/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

import java.util.GregorianCalendar;

/**
 *
 * @author ivan
 */
public class Alquiler {

    private GregorianCalendar fecIni;
    private GregorianCalendar fecFin;
    private int posicion;
    private Barco b;
    private Cliente c;

    public Alquiler(GregorianCalendar fecIni, GregorianCalendar fecFin, int posicion, Barco b, Cliente c) {
        this.fecIni = fecIni;
        this.fecFin = fecFin;
        this.posicion = posicion;
        this.b = b;
        this.c = c;
    }

    public GregorianCalendar getFecIni() {
        return fecIni;
    }

    public void setFecIni(GregorianCalendar fecIni) {
        this.fecIni = fecIni;
    }

    public GregorianCalendar getFecFin() {
        return fecFin;
    }

    public void setFecFin(GregorianCalendar fecFin) {
        this.fecFin = fecFin;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Barco getB() {
        return b;
    }

    public void setB(Barco b) {
        this.b = b;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public float calculo() {
        return getB().calculaAlquiler() * calcularDias();
    }

    private int calcularDias() {
        long numero1 = fecIni.getTimeInMillis();
        long numero2 = fecFin.getTimeInMillis();
        long diferencia = numero2 - numero1;
        int dias = (int) (diferencia) / (1000 * 60 * 60 * 24);
        return dias;
    }
}