/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author ags12
 */
public class DoctorUser extends User {
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public DoctorUser(String username, String password, String fName, String lName) {
        super(username, password, fName, lName);
    }
    
    /**
     * Sets the String value for username in this User object.
     * @param newUsername Set as the new String value for username.
     */
    public void setUsername(String newUsername){
        super.setUsername(newUsername);
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
        super.setPassword(newPassword);
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
        super.setFirstName(firstName);
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
        super.setLastName(lastName);
    }
    
}
