/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.solucionExamen;

/**
 *
 * @author ivan
 */
public class Matriz {
    public static void main(String[] args) {
        int[][] aux=new int[3][3];
        int x=3;
        aux[0][0] = 1;
        aux[0][1] = 0;
        aux[0][2] = 0;
        aux[1][0] = 0;
        aux[1][1] = 1;
        aux[1][2] = 0;
        aux[2][0] = 0;
        aux[2][1] = 0;
        aux[2][2] = 1;
        
        System.out.println(dimeSiEsIdentidad(aux, x));
    }
    public static boolean dimeSiEsIdentidad(int[][] matriz, int tam) {
        int aux1 = 0, aux2 = 0;
        while (aux1 < tam) {
            while (aux2 < tam) {
                if (aux1 == aux2) {
                    if (matriz[aux1][aux2]!=1)
                        return false;
                }else{
                    if (matriz[aux1][aux2]!=0)
                        return false;
                }
                aux2++;
            }
            aux2=0;
            aux1++;
        }
        return true;
    }
}
