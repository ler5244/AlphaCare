/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author jdq5016
 */
public class LoginController {
    
    
    /**
     * compares Strings username and password to the usernames and passwords
     * of the User objects stored in User Directory.
     * @return true or false depending on if the username and password 
     * combination exists in the UserDirectory.
     */
    public boolean authenticate(){
        String username = "example";
        String password = "example";
        
        //To be used when login user input is included.
        /*
        String username = Login.getUsername();
        String password = Login.getPassword();
        */
        return UserDirectory.contains(username, password);
    }
    
}


