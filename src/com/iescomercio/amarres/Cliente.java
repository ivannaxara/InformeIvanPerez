/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

/**
 *
 * @author ivan
 */
public class Cliente {

    private String dni, nombre, apellidos, direccion, estadoCivil;
    private int edad, codigo;
    private char operacion;
    private float telefonoFijo, telefonoMovil;

    public Cliente() {
    }

    public char getOperacion() {
        return operacion;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    public Cliente(int codigo, String dni, String nombre, String apellidos, String estadoCivil, String direccion, float telefonoFijo, float telefonoMovil, int edad) {
        this.codigo = codigo;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public float getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(float telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public float getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(float telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString(){
        return "'"+getCodigo() + "', '" +getDni() + "', '" +getNombre() +  "', '"  +getApellidos() +  "', '"  +getDireccion()+  "', '"  +getTelefonoFijo() + "', '"  +getTelefonoMovil() +  "', '"  +getEdad()+"', '"+getEstadoCivil()+"'";
    }
}
