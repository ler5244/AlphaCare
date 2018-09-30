/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.util.ArrayList;

public class CreateRecordController {
    
    /**
    * Default constructor for the CreateRecordController class
    */
    public CreateRecordController() {

    }

    /**
    * Create a new record for the user
    * @param sickness sets the sickness for the user
    * @param symptoms sets the symptoms for the user
    * @param miscInfo sets the miscellaneous information for the user
    */
    public void createRecord(String sickness, ArrayList<String> symptoms, String miscInfo){
        Record record = new Record(sickness, symptoms, miscInfo);
    }
    
}

