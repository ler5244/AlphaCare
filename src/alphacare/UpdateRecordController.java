package alphacare;

import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class UpdateRecordController {

    /**
     * Default constructor for the CreateRecordController class
     */
    public UpdateRecordController() {

    }

    /**
     * Update a record for the user
     *
     * @param sickness sets the sickness for the user
     * @param symptoms sets the symptoms for the user
     * @param miscInfo sets the miscellaneous information for the user
     * @return 
     */
    public Record updateRecord(String sickness, String symptoms, String miscInfo, String username) {
        return new Record(sickness, symptoms, miscInfo, username);
    }

}

