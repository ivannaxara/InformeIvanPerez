/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.solucionExamen;

/**
 *
 * @author ivan
 */
public class Hexagono {

    public static void main(String[] args) {
        int x = 4;
        char c = 'g';
        muestraHexagono(x, c);
    }

    public static void muestraHexagono(int n, char c) {
        int cont = 0, conte = 0, contl = 0, ce = n - 1, cl = n;
        if (n > 0) {
            while (cont < n) {
                while (conte < ce) {
                    System.out.print(" ");
                    conte++;
                }
                conte = 0;
                while (contl < cl) {
                    System.out.print(c);
                    contl++;
                }
                contl = 0;
                cont++;
                ce--;
                cl = cl + 2;
                System.out.println("");
            }
            ce = 1;
            cl = cl - 4;
            while (cont > 1) {

                while (conte < ce) {
                    System.out.print(" ");
                    conte++;
                }
                conte = 0;
                while (contl < cl) {
                    System.out.print(c);
                    contl++;
                }
                contl = 0;
                cont--;
                ce++;
                cl = cl - 2;
                System.out.println("");
            }

        }
    }
}
