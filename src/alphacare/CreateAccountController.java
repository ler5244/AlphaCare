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
     *
     * @param passWord sets the password for the user
     * @param userName sets the username for the user
     */
    public CreateAccount createAccount(String userName, String passWord) {
        return new CreateAccount(userName, passWord);
    }

}



