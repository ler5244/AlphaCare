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
public class CreateAccountController {
    /**
    * Default constructor for the createAccountController class
    */
    public CreateAccountController() {

    }



    /**
    * Create a new record forCreateAccount the user
    * @param passWord sets the password for the user
    * @param userName sets the username for the user
    */
    public void createAccount(String userName, String passWord){
        CreateAccount account = new CreateAccount(userName, passWord);
    }
    

}


