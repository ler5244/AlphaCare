/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author ajp5922
 */
public class CreateAccount {
    private String userName;
    private String passWord;
    
    
    /**
    * Constructor for the Record model class
    * Takes in all class attributes as parameters
    * @param userName sets the user's username
    * @param passWord sets the user's password
    */ 
    
    public CreateAccount(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    
    
    /* 
    *Returns the UserName for the login.
    *return a String representing the user name for the login.
    */
    public String getUserName() {
        return userName;
        
    }
    
    /* 
    *Sets the user name for the login.
    *@param userName sets the user name for login.
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    /* 
    *Returns the PassWord for the login.
    *return a String representing the password for the login.
    */
    public String getPassWord() {
        return passWord;
    }

     /* 
    *Sets the pass word for the login.
    *@param passWord sets the password for login.
    */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
