package alphacare;

import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class ViewRecordController {

    /**
     * Default constructor for the viewRecordsController class
     */
    public ViewRecordController() {
    }

    /**
     *
     * @param sickness
     * @param symptoms
     * @param miscInfo
     * @param username
     * @return
     */
    public Record getRecord(String sickness, String symptoms, String miscInfo, String username) {

        return new Record(sickness, symptoms, miscInfo, username);
        //To be used when record is being is included.
        /*
        String sickness = Record.getSickness();
        String symptoms = Record.getSymptoms();
        String miscInfo = Record.getMiscInfo();
         */

    }

}
