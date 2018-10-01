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
    UserDirectory directory = new UserDirectory();
    
    /**
     * compares Strings username and password to the usernames and passwords
     * of the User objects stored in User Directory.
     * @return true or false depending on if the username and password 
     * combination exists in the UserDirectory.
     */
    public LoginController(){
        
    }
    
    /*
    Authenticates theUserName and the String to any existing Users.
    If they exist, returns true, otherwise false
    */
    public boolean authenticate(String theUserName, String thePassword){
        
        String username = theUserName;
        String password = thePassword;
        
        //To be used when login user input is included.
        /*
        String username = Login.getUsername();
        String password = Login.getPassword();
        */
        return directory.contains(username, password);
    }
    
}


