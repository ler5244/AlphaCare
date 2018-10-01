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
     * @return
     */
    public Record getRecord(String sickness, ArrayList<String> symptoms, String miscInfo) {

        return new Record(sickness, symptoms, miscInfo);
        //To be used when record is being is included.
        /*
        String sickness = Record.getSickness();
        String symptoms = Record.getSymptoms();
        String miscInfo = Record.getMiscInfo();
         */

    }

}
