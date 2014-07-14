/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.amarres;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class ListaClientes {

    private ResultSet rs;
    private ArrayList<Cliente> ColeccionClientes;
    private int indice, idLista;
    private Connection con;
    private Statement stmt; // Constructores
    private ArrayList<Cliente> ClientesBorrados;

    public ListaClientes() {
        try {
            ColeccionClientes = new ArrayList();
            ClientesBorrados = new ArrayList();
            this.indice = 0;
            // Carga de forma dinámica el driver de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establece la conexión
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.80.136:1521:XE",
                    "system",
                    "system");
            stmt = con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Geters y seters

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public ArrayList<Cliente> getColeccionClientes() {
        return ColeccionClientes;
    }

    public void setColeccionClientes(ArrayList<Cliente> ColeccionClientes) {
        this.ColeccionClientes = ColeccionClientes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void addCliente(Cliente cli) {
        this.ColeccionClientes.add(cli);
    }

    public void removeCliente() {
        // solo entra si la coleccion NO esta vacia
        if (!ColeccionClientes.isEmpty()) {
            // en vez de borrar el velero lo pongo operacion R (remove)

            ClientesBorrados.add(this.ColeccionClientes.get(indice));
            this.ColeccionClientes.remove(indice);
            this.primerCliente();
            //this.veleroColeccion.remove(indice);
        }
    }

    public Cliente primerCliente() {
        if (ColeccionClientes.isEmpty()) {
            return null;
        } else {
            setIndice(0);
            return this.ColeccionClientes.get(0);
        }
    }

    public Cliente ultimoCliente() {
        if (ColeccionClientes.isEmpty()) {
            return null;
        } else {
            setIndice(this.ColeccionClientes.size() - 1);
            return this.ColeccionClientes.get(indice);
        }
    }

    public Cliente obtenerCliente(int indice) {
        if (ColeccionClientes.isEmpty()) {
            return null;
        } else {
            return this.ColeccionClientes.get(indice);
        }
    }

    public Cliente clienteAnterior() {
        if (indice < 1) {
            setIndice(0);
        } else {
            setIndice(getIndice() - 1);
        }
        if (ColeccionClientes.isEmpty()) {
            return null;
        } else {
            return this.ColeccionClientes.get(indice);
        }
    }

    public Cliente clienteSiguiente() {
        if (indice >= ColeccionClientes.size() - 1) {
            setIndice(ColeccionClientes.size() - 1);
        } else {
            setIndice(getIndice() + 1);
        }
        if (ColeccionClientes.isEmpty()) {
            return null;
        } else {
            return this.ColeccionClientes.get(indice);
        }
    }

    public void leeFichero() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM BARCOS.CLIENTE ORDER BY CODIGO");
            // Relleno la coleccion con los campos de la tabla              
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String estadoCivil = rs.getString("estadoCivil");
                String direccion = rs.getString("direccion");
                
                Float telefonoFijo = rs.getFloat("telefonoFijo");
                Float telefonoMovil = rs.getFloat("telefonoMovil");
                int edad = rs.getInt("edad");
                Cliente clien = new Cliente(codigo, dni, nombre, apellidos, estadoCivil, direccion, telefonoFijo, telefonoMovil, edad);
                this.idLista = clien.getCodigo();
                this.ColeccionClientes.add(clien);
            }
        }
         catch (SQLException ex) {
            System.out.println("un error mas");
        }finally{
            try{
                rs.close();  
            }catch(SQLException ex){
                System.out.println("error");
            }
        }
    }
    
    //FALTA ESTO 
    public void escribeFichero() throws IOException, ClassNotFoundException, SQLException {
        String sql;
        int x;


        for (int i = 0; i < this.ColeccionClientes.size(); i++) {
            Cliente cli = this.ColeccionClientes.get(i);
            if (cli.getOperacion() == 'I') {
                sql = "INSERT INTO BARCOS.CLIENTE (codigo, "
                        + "dni, nombre, apellidos, direccion, "
                        + "telefonofijo, telefonomovil, edad, estadocivil) "
                        + "Values (" + cli.toString() + ")";
                //System.out.println(sql);
                x = stmt.executeUpdate(sql);
            } else if (cli.getOperacion() == 'U') {                
                sql = "UPDATE BARCOS.CLIENTE SET codigo = '" + cli.getCodigo()
                        + "', dni = '" + cli.getDni()
                        + "', nombre = '" + cli.getNombre()
                        + "', apellidos = " + cli.getApellidos()
                        + ", direccion = " + cli.getDireccion()
                        + ", telefonofijo = " + cli.getTelefonoFijo()
                        + ", telefonomovil = " + cli.getTelefonoMovil()
                        + ", edad = " + cli.getEdad()
                        + ", estadocivil = '" + cli.getEstadoCivil()
                        // FALTA EL WHERE PARA UPDATE QUE REGISTRO ACTUALIZO ?
                        // REVISAR EL ATRIBUTO ID DE VELERO Y LISTAVELERO
                        + "' WHERE CODIGO = " + cli.getCodigo();
                System.out.println(sql);
                x = stmt.executeUpdate(sql);
            }
            // Eleminando registro borrados
            Iterator it = this.ClientesBorrados.iterator();
            while(it.hasNext()) {                
                sql = "DELETE FROM BARCOS.CLIENTE WHERE CODIGO = '" + ((Cliente)it.next()).getCodigo() + "'";
                //System.out.println(sql);
                x = stmt.executeUpdate(sql);
            }
            
        }
        stmt.close();
        con.close();
    }
}
