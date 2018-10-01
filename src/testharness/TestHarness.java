
package testharness;

import alphacare.CreateAccount;
import alphacare.CreateAccountController;
import alphacare.CreateRecordController;
import alphacare.LoginController;
import alphacare.Record;
import alphacare.UpdateRecordController;
import alphacare.ViewRecordController;
import java.util.ArrayList;

/**
 *
 * @author ags12
 */
public class TestHarness {
    
    public static void main(String[] args) {
        testLoginController();
        testCreateAccountController();
        testViewRecordController();
        testCreateRecordController();
        testupdateRecordController();
        
    }
    
    /**
     * Tests out the CreateRecordController in the alphacare package
     * Outputs if the controller properly created the new record or not
     */
    public static void testCreateRecordController() {
        
        CreateRecordController cntl = new CreateRecordController();
        
        // data for the new record
        String testSickness = "cold";
        
        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add("fever");
        testSymptoms.add("congestion");
        
        String testMiscInfo = "Having trouble sleeping";
        
        Record testRecord = cntl.createRecord(testSickness, testSymptoms, testMiscInfo);
        
        // check if the record was successfully created
        if(testRecord != null) {
            System.out.println("Create Record Controller successfully created new record");
        }
        
        else {
            System.out.println("Create Record Controller failed to created new record");
        }
        
    }
    
    /**
     * Tests out the CreateAccountController in the alphacare package Outputs if
     * the controller properly created the new account or not
     */
    public static void testCreateAccountController() {
        CreateAccountController cntl = new CreateAccountController();

        //Data for new account
        String testUserName = "Alex5p";
        String testPassWord = "422";

        CreateAccount createAccount = cntl.createAccount(testUserName, testPassWord);

        //check if account was succesfully created
        if (createAccount != null) {
            System.out.println("Create Account Controller successfully created a new account");
        } else {
            System.out.println("Create Account Controller failed to created a new account");
        }
    }

    /**
     * Tests out the updateRecordController in the alphacare package Outputs if
     * the controller properly updated a record or not
     */
    public static void testupdateRecordController() {
        UpdateRecordController cntl = new UpdateRecordController();

        //data for an updated record
        String testSickness = "hot";

        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add("fever");
        testSymptoms.add("congestion");

        String testMiscInfo = "Having trouble sleeping";

        Record testRecord = cntl.updateRecord(testSickness, testSymptoms, testMiscInfo);

        // check if the record was successfully updated
        if (testRecord != null) {
            System.out.println("Update Record Controller successfully updated the record");
        } else {
            System.out.println("Update Record Controller failed to update the record");
        }
    }

    /**
     * Tests out the ViewRecordController in the alphacare package
     * Outputs if the controller properly viewed the record or not
     */
    public static void testViewRecordController() {

        ViewRecordController cntl = new ViewRecordController();

        // data for the new record
        String testSickness = "cold";

        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add("fever");
        testSymptoms.add("congestion");

        String testMiscInfo = "Having trouble sleeping";

        Record testRecord = cntl.getRecord(testSickness, testSymptoms, testMiscInfo);

        // check if the record is viewed successfully
        if (testRecord != null) {
            System.out.println("View Record Controller successfully viewed a record");
        } else {
            System.out.println("View Record Controller failed to view a record");
        }

    }
    
    /**
     * Tests the Login Controller.
     * Outputs appropriate results depending on if it authenticates correctly or not. 
     */
    public static void testLoginController(){
        LoginController testLoginController = new LoginController();
        String goodUserName = "example";
        String goodPassword = "example";
        String badUserName = "";
        String badPassword = "";
        
        if(testLoginController.authenticate(goodUserName, goodPassword) && !testLoginController.authenticate(badUserName, badPassword)){
            System.out.println("LoginController successfully authenticated");
        }
        
        else{
                System.out.println("LoginController failed to authenticate");
            }
        }
        
        
    }



    
