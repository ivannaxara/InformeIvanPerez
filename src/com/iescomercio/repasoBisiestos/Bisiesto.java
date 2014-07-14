/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.repasoBisiestos;

import java.sql.*;
import java.util.*;
import com.iescomercio.repasoBisiestos.*;

/**
 *
 * @author ivan
 */
public class Bisiesto {

    public static void main(String[] args) {
        //Aqui haremos las pruebas de los diferentes metodos

    }

    //Ejercicio 1 
    public static boolean esbisisesto(int ano) {
        if (ano % 4 == 0 && ano % 100 != 0) { //Si el modulo 4 del año es igual a 0 y el modulo 100 del año es diferente de cero ya tendremos un año bisiesto
            return true;
        } else if (ano % 100 == 0 && ano % 400 == 0) { //Si el modulo 100 del año es 0 pero tambien lo es el modulo 400 de este tambien sera bisiesto
            return true;
        } else {
            return false;
        }
    }
    
    //Ejercicio 2
    public static boolean rellenaTabla(int numreg) {
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //Establecemos la conexion
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.80.136:1521:XE",
                    "system",
                    "system");
            stmt = con.createStatement();
            int aux = 0;
            while (aux < numreg) {    //Creamos el bucle para añadir "x" fechas
                Fecha f = new Fecha();
                stmt.executeUpdate("INSERT INTO FECHAS.FECHAS VALUES (" + f.getD() + ", " + f.getM() + ", " + f.getA() + ")");
                aux++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());

        } catch (ClassNotFoundException ex) {
            System.out.println("holi");

        } finally {
            try {
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println("holo");
                return false;
            }
        }

        return true;
    }

    //Ejercicio 3
    public static int cuantosBisiestos(String nombreTabla) {
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        int aux = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//Creamos la conexion
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.80.136:1521:XE",
                    "system",
                    "system");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM FECHAS." + nombreTabla); //Pasamos el nombre de la tabla a la consulta SQL

            while (rs.next()) {  //Establecemos un bucle para recorrer el resultset y contar los bisiestos
                if (esbisisesto(rs.getInt("año"))) {
                    aux++;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());

        } catch (ClassNotFoundException ex) {
            System.out.println("holi");

        } finally {
            try {
                stmt.close();
                con.close();

            } catch (SQLException ex) {
                System.out.println("holo");
            }
        }
        return aux;
    }

    //Ejercicio 4
    public static int diasHastaNocheVieja(int dia, int mes, int año) {
        int aux = 0, dm;
        dm = Fecha.diasMaximos(mes, año); //Primero conseguisos los dias maximos del mes de la fecha
        aux = dm - dia;                   //Contamos los dias que faltan para que el mes acabe

        while (mes < 12) {                //Del mismo modo creamos un bucle que se repita una vez cada mes hasta llegar a diciembre
            mes++;
            aux = aux + Fecha.diasMaximos(mes, año);
        }
        return aux;

    }

    //Ejercicio 5
    public static HashSet<Fecha> rellenaColeccion(String nombreTabla) {
        Connection con = null;
        ResultSet rs;
        Statement stmt = null;
        HashSet<Fecha> aux =new HashSet();      //Inicializamos la coleccion que luego devolveremos
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Creamos la conexion
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.80.136:1521:XE",
                    "system",
                    "system");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM FECHAS." + nombreTabla);

            while (rs.next()) {
                if (esbisisesto(rs.getInt("año"))) {
                    Fecha fecha1=new Fecha(rs.getInt("dia"), rs.getInt("mes"), rs.getInt("año"));
                    aux.add(fecha1);
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());

        } catch (ClassNotFoundException ex) {
            System.out.println("holi");

        } finally {
            try {
                stmt.close();
                con.close();
                

            } catch (SQLException ex) {
                System.out.println("holo");
            }
        }
        return aux;
    }

    //Ejercicio6
    public static Fecha[] coleccionToArray(HashSet<Fecha> c) {
        Fecha[] f = new Fecha[100];
        int x = 0;
        Iterator it = c.iterator();
        while (it.hasNext()) {
            Fecha t = (Fecha) it.next();
            String aux, aux2;
            if (t.getM() < 10) {
                aux = "" + t.getD() + "0" + t.getM();
            } else {
                aux = "" + t.getD() + "" + t.getM();
            }
            aux2 = "" + t.getA();
   
            if (Integer.parseInt(aux)==Integer.parseInt(aux2)) {
                f[x] = t;
                x++;
            }
        }
        return f;

    }
}
