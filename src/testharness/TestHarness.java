
package testharness;

import alphacare.CreateRecordController;
import alphacare.Record;
import java.util.ArrayList;

/**
 *
 * @author ags12
 */
public class TestHarness {
    
    public static void main(String[] args) {
        testCreateRecordController();
        testupdateRecordController();
        testCreateAccountController();
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
     * Tests out the CreateAccountController in the alphacare package
     * Outputs if the controller properly created the new account or not
     */
    Public static void testCreateAccountController(){
        CreateAccountController cntl = new CreateAccountController();

        //Data for new account
        String testUserName = “Alex5p”;
        String testPassWord =”422”;
        
        CreateAccount createAccount = acctCntl.createAccount(testUserName,testPassWord);
        
        //check if account was succesfully created
        if(createAccount != null){
            System.out.println(“Create Account Controller successfully created a new account”);
        }
        else {
            System.out.println(“Create Account Controller failed to created a new account”);
        }
    }
    
     /**
     * Tests out the updateRecordController in the alphacare package
     * Outputs if the controller properly updated a record or not
     */
    Public static void testupdateRecordController(){
        updateRecordController cntl= new updateRecordController();

        //data for an updated record
        String testSickness = “hot”;

        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add(“fever”);
        testSymptoms.add(“congestion”);

        String testMiscInfo = “Having trouble sleeping”;

        Record testRecord = cntl.updateRecord(testSickness,testSymptoms,testMiscInfo);

        //Check if the record was updated successfully
        if(testRecord != null)
	        System.out.println(“Update Record Controller successfully updated the record.”);
        }
        else{
        System.out.println(“Create Update Record Controller failed to update the record.”);
        }
}


    
}
