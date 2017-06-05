/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Statement;
import java.util.ArrayList;
import tztbackoffice.Models.KoerierModel;


/**
 *
 * @author Andy
 */
public class DBConnector {
        
    private static Connection connect(){
        try {
            String connectionString = Constants.DB_DRIVER + Constants.DB_ADDRESS + ":" + Constants.DB_PORT + "/" + Constants.DB_NAME + "?zeroDateTimeBehavior=convertToNull";
            System.out.println(connectionString);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(connectionString, Constants.DB_USN, Constants.DB_PW);  
            return con;
        } catch (Exception ex) {
            return null;
        }
            
    }
    
    public static ArrayList<KoerierModel> getAllCouriers(){
        ArrayList<KoerierModel> allCouriers = new ArrayList<>();
        
        Connection con = connect();
        if(con != null){
            try {
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from user");

                while(rs.next()){
                    
                    KoerierModel newCourier = new KoerierModel();
                    newCourier.setIdUser(rs.getInt("idUser"));
                    newCourier.setMailAddress(rs.getString("Email"));
                    newCourier.setFirstName(rs.getString("Firstname"));
                    newCourier.setMiddleName(rs.getString("Middlename"));
                    newCourier.setLastName(rs.getString("Lastname"));
                    newCourier.setStreetName(rs.getString("Street"));
                    newCourier.setHouseNumber(rs.getString("Housenumber"));
                    newCourier.setZipCode(rs.getString("Zipcode"));
                    newCourier.setCity(rs.getString("City"));
                    newCourier.setPhoneNumber(rs.getString("PhoneNumber"));
                    newCourier.setSex(rs.getString("Gender"));
                    newCourier.setDateOfBirth(rs.getDate("Birthday").toString());
                    newCourier.setStatus(rs.getString("State"));

                    allCouriers.add(newCourier);
                    
                }
                
                System.out.println(allCouriers.size());
                
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allCouriers;
    }
    
    public static KoerierModel getCourierDetails(int idUser){
        KoerierModel newCourier = new KoerierModel();
        Connection con = connect();
        
        if(con != null){
            try {
                
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from user where idUser = " + idUser);

                while(rs.next()){
                    
                    newCourier.setIdUser(rs.getInt("idUser"));
                    newCourier.setMailAddress(rs.getString("Email"));
                    newCourier.setFirstName(rs.getString("Firstname"));
                    newCourier.setMiddleName(rs.getString("Middlename"));
                    newCourier.setLastName(rs.getString("Lastname"));
                    newCourier.setStreetName(rs.getString("Street"));
                    newCourier.setHouseNumber(rs.getString("Housenumber"));
                    newCourier.setZipCode(rs.getString("Zipcode"));
                    newCourier.setCity(rs.getString("City"));
                    newCourier.setPhoneNumber(rs.getString("PhoneNumber"));
                    newCourier.setSex(rs.getString("Gender"));
                    newCourier.setDateOfBirth(rs.getDate("Birthday").toString());
                    newCourier.setStatus(rs.getString("State"));
                    
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return newCourier;
    }
    
    
//    public static void connect(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");     
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8889/tzt?zeroDateTimeBehavior=convertToNull","tzt_admin","tzt_admin");         
//            Statement stmt=con.createStatement();            
//            ResultSet rs=stmt.executeQuery("Select * from loginfail");  
//            int i = 0;
//            while(rs.next()){
//                System.out.println(rs.getString("email") + " -- " + rs.getString("IP") + " -- " + rs.getString("dateAndTime"));
//            }
//            con.close();
//        } catch (Exception ex) {
//            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    try {
//            Class.forName("com.mysql.jdbc.Driver");     
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8889/tzt","tzt_admin","tzt_admin");         
//            Statement stmt=con.createStatement();            
//            int test = stmt.executeUpdate("insert into loginfail VALUES(NOW(), 'koek', '1,1,1,1')");  
////            ResultSet rs=stmt.executeUpdate("insert into loginfail VALUES(NOW(), 'koek', '12212121')");  
//            con.close();
//        } catch (Exception ex) {
//            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
    
}

