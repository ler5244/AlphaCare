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
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    /**
     * This is the constructor for the User object class.
     * @param newUsername Set as the new value for username.
     * @param newPassword Set as the new value for password.
     * @param fName set as the new value for first name
     * @param lName set as the new value for last name 
     */
    public User(String newUsername, String newPassword, String fName, String lName){
        this.username = newUsername;
        this.password = newPassword;
        this.firstName = fName;
        this.lastName = lName;
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

    /**
     * Gets the String value of first name.
     * @return Returns the String value of first name in this User object.
    */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the String value for first name in this User object.
     * @param firstName Set as the new String value for the first name.
    */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the String value of last name.
     * @return Returns the String value of last name in this User object.
    */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the String value for last name in this User object.
     * @param lastName Set as the new String value for the last name.
    */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}

