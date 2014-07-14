/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.solucionExamen;

/**
 *
 * @author ivan
 */
public class Traza {
    public static void main(String[] args) {
        int x=0,c=5;
        try{
            x=c++;     //CAZADO c++ primero asigna el valor de c a x y luego suma en c (1+)
            x=x/0;     //No se puede dividir entre 0, esto retorna una ArithmeticException
            x=x+2;
        }catch(java.lang.ArithmeticException e){  //Entra en la primera excepcion
            x--;
        }catch(Exception e){
            x=x+2;
        }finally{      //También entra al apartado finally
            x=x+3;
        }
        x=x+3;         //No nos olvidemos de la ultima instruccion
        System.out.println("Valor de x: "+x);
    }
}
