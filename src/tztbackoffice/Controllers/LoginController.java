/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tztbackoffice.Controllers;

/**
 *
 * @author Andy
 */
public class LoginController {
    
    //Check if username and password are correct
    public static boolean checkLoginCredentials(String username, String password){
        return password.equals("beheerder") && username.equals("beheerder");
    }
    
}
