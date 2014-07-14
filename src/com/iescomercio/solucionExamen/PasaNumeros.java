/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.solucionExamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author ivan
 */
public class PasaNumeros {

    public static void main(String[] args) {
        pasaNumeros("C:\\\\Users\\ivan\\Documents\\hola.txt", "C:\\\\Users\\ivan\\Documents\\adios.txt");
    }

    public static void pasaNumeros(String nomfile1, String nomfile2) {
        HashSet t = new HashSet();

        t = filtradoNumeros(nomfile1);
        t = filtraColeccion(t);
        rellenaDestino(t, nomfile2);
        Iterator it = t.iterator();
        it.next().toString();
    }

    public static HashSet<Integer> filtradoNumeros(String nomfile1) {
        HashSet<Integer> st = new HashSet();
        FileReader ir = null;
        BufferedReader br = null;
        try {
            ir = new FileReader(nomfile1);
            br = new BufferedReader(ir);
            String cadena = null;
            do {
                cadena = br.readLine();
                if (cadena.charAt(0) == cadena.charAt(cadena.length() - 1)) {
                    Integer aux = Integer.parseInt(cadena);
                    st.add(aux);
                }
            } while (cadena != "");
        } catch (IOException ex) {
            System.out.println("no se ha encontrado el archivo");
        } finally {
            try {
                ir.close();
                br.close();
            } catch (Exception ex) {
                System.out.println("no se ha podido cerrar el archivo");
            } finally {
                return st;
            }
        }

    }

    public static HashSet<Integer> filtraColeccion(Set<Integer> t) {
        HashSet<Integer> hs = new HashSet();
        Iterator itera = t.iterator();

        while (itera.hasNext()) {
            Integer aux = (Integer) itera.next();
            if (aux > 10 && aux < 999999) {
                hs.add(aux);
            }
        }
        return hs;
    }

    public static void rellenaDestino(Set<Integer> t, String salida) {
        HashSet<Integer> st = new HashSet();
        FileWriter ir = null;
        BufferedWriter br = null;
        Iterator iter = t.iterator();
        try {
            ir = new FileWriter(salida);
            br = new BufferedWriter(ir);
            try {
                String cadena = "";

                while (cadena != null) {
                    cadena = "" + iter.next();
                    StringBuilder devuelve = new StringBuilder();
                    int numero = 0;
                    int aux = cadena.length();
                    int cont = 0;
                    while (cont < aux) {
                        numero = numero + Integer.parseInt("0" + cadena.charAt(cont));
                        if (cont != aux - 1) {
                            devuelve.append(cadena.charAt(cont) + " + ");
                        } else {
                            devuelve.append(cadena.charAt(cont) + " = " + numero);
                        }
                        cont++;

                    }
                    br.write(devuelve.toString());
                    br.newLine();
                }
            } catch (NoSuchElementException ex) {
                System.out.println("Se acabo");
            }
        } catch (IOException ex) {
            System.out.println("no se ha encontrado el archivo");
        } finally {
            try {
                br.close();
                ir.close();
            } catch (Exception ex) {
                System.out.println("no se ha podido cerrar el archivo");
            } finally {
//                return st;
            }
        }

    }
}
