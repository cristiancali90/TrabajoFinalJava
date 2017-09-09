
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Gobierno {
  
     private static Apartamento apartamento;
     
     private static Ciudadano ciudadano;

   
    
    
    
    public static void main(String args[]){
    
     ciudadano= new Ciudadano("5555","cristian","idrobo");
     
     BigDecimal valorComercial= new BigDecimal(45000);
     
     apartamento= new Apartamento("1234","calle 11", 23, valorComercial, 4, TipoInmuebleEnum.APTO);
     
     crearCiudadano(ciudadano);
     
     
     crearInmueble(ciudadano, apartamento);
        
        
        
    
   }
    
    public static void reporteInmueblesPorCiudadano(Ciudadano ciudadano){
        
        
          
        Connection conn = null;
        try {
            // TODO code application logic here
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajo","root", "");
            
            String sql="SELECT a.id, b.codigo_nacional, b.estrato, c.valor_comercial from inmuebles"+
            "where a.id='"+ciudadano.getId()+"' "+
            "and a.id= b.id_ciudadano";
            Statement stm= conn.createStatement();
            ResultSet rs= stm.executeQuery(sql);
            
            String out="Pais %s, Id %s \n";
            
            while(rs.next()){
                
                
                
                System.out.printf(out, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            
        
            
            
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public static void crearCiudadano(Ciudadano ciudadano){
        
         
        Connection conn = null;
        try {
            // TODO code application logic here
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajo","root", "");
            
            String sql="INSERT INTO ciudadanos (id, nombres, apellidos) values('"+ciudadano.getId()+"','"+ciudadano.getNombres()+"','"+ciudadano.getApellidos()+"')";
            Statement stm= conn.createStatement();
            boolean rs= stm.execute(sql);
            
             System.out.println("Inserción exitosa");
            
          
            
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    public static void crearInmueble(Ciudadano ciudadano, Inmueble inmueble){
        
        
        
         Connection conn = null;
        try {
            // TODO code application logic here
            
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trabajo","root", "");
            
            String sql="INSERT INTO inmuebles (codigo_nacional, id_ciudadano, tipo, direccion, area, valor_comercial, estrato) "+
                    
           "values('"+inmueble.getCodigoNacional()+"','"+ciudadano.getId()+"','"+inmueble.getTipo()+"'"+
           ",'"+inmueble.getDireccion()+"',"+inmueble.getArea()+","+inmueble.getValorComercial()+","+inmueble.getEstrato()+")";
            Statement stm= conn.createStatement();
            boolean rs= stm.execute(sql);
            
             System.out.println("Inserción exitosa, inmueble cargado a ciudadano");
            
          
            
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Gobierno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    
    
    
}
