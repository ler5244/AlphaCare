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
public class User {
    String username = "";
    String password = "";
    
    /**
     * This is the constructor for the User object class.
     * @param newUsername Set as the new value for username.
     * @param newPassword Set as the new value for password.
     */
    public User(String newUsername, String newPassword){
        username = newUsername;
        password = newPassword;
    }
    
    /**
     * Sets the String value for username in this User object.
     * @param newUsername Set as the new String value for username.
     */
    public void setUsername(String newUsername){
        username = newUsername;
    }
    
    /**
     * Gets the String value of password.
     * @return Returns the String value of username in this User object.
     */
    public String getUsername(){
        return username;
    }
    
    /**
     * Sets the String value for password in this User object.
     * @param newPassword Set as the new String value for password.
     */
    public void setPassword(String newPassword){
        password = newPassword;
    }
    
    /**
     * Gets the String value of password.
     * @return Returns the String value of password in this User object.
     */
    public String getPassword(){
        return password;
    }
    
}

