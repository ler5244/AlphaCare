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
public class PatientUser extends User {
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public PatientUser(String username, String password, String fName, String lName) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }
    
}
