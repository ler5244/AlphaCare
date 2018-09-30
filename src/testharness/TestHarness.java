
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
    
}
