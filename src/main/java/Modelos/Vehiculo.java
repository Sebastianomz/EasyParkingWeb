/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author PC_Daniel
 */
public class Vehiculo {
    //ATRIBUTOS 
    private String placaVehiculo; 
    private String tipoVehiculo; 
    
    //CONSTRUCTOR
    public Vehiculo() {
    }

    //ENCAPSULAR 
    
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    } 

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
    //METODOS 
    public void ingresarVehiculo(){
        
        ConexionBD objConector = new ConexionBD(); 
        objConector.conectar();
        
        try {
            
            String sql = "INSERT INTO vehiculos VALUES(?,?);";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            
            stmt.setString(1, this.placaVehiculo);
           
            stmt.setString(2, this.tipoVehiculo);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
        }
    }
    
    
    public String salirVehiculo(){
        ConexionBD objConector = new ConexionBD(); 
        objConector.conectar();
        
        try {
            
            String sql = "DELETE FROM producto "+
                         "WHERE codigoProducto = ?; "; 
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.placaVehiculo);
            
            stmt.execute(); 
            
            objConector.desconectar();
        } catch (Exception error) {
            System.out.println("Error Modelo: "+error);
            return error.toString(); 
        }
        return null; 
    }
}
