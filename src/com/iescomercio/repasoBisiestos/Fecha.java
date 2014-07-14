/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.repasoBisiestos;

/**
 *
 * @author ivan
 */
public class Fecha {
    private int d, m, a;
    public Fecha (){
        
        m=this.nuevoMes();
        a=this.nuevoAño();
        d=this.nuevoDia();
    }

    public Fecha(int d, int m, int a) {
        this.d = d;
        this.m = m;
        this.a = a;
    }

    public int getD() {
        return d;
    }

    public int getM() {
        return m;
    }

    public int getA() {
        return a;
    }
    
    public int nuevoDia(){
        int nd=(int)(Math.random()*31+1);
        
        while (nd>=diasMaximos(this.getM(),this.getA()))
            nd=(int)(Math.random()*31+1);
            
        return nd;
    }
    public static int nuevoMes(){
        int m;
        m=(int)(Math.random()*12+1);
        return m;
    }
    public static int nuevoAño(){
        int a;
        a=(int)(Math.random()*2424+0);
        return a;
    } 
    public static int diasMaximos(int m, int a){
        int d;
        if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
            d=31;
        else if(m==2){
            if (Bisiesto.esbisisesto(a)==true)
                d=29;
            else
                d=28;
        }else
            d=30;           
        return d;
    }

    @Override
    public String toString() {
        return "Fecha{" + "d=" + d + ", m=" + m + ", a=" + a + '}';
    }
}
