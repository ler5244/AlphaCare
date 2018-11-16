/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.util.ArrayList;

public class Record {
    
    private String sickness;
    private String symptoms;
    private String miscInfo;

    /**
    * Default constructor for the Record model class
    */
    public Record() {

    }

    /**
    * Constructor for the Record model class
    * Takes in all class attributes as parameters
    * @param sickness sets the user's sickness
    * @param symptoms sets the user's symptoms
    * @param miscInfo sets the user's miscellaneous information
    */
    public Record(String sickness, String symptoms, String miscInfo) {
        this.sickness = sickness;
        this.symptoms = symptoms;
        this.miscInfo = miscInfo;
    }

    /**
    * Returns the sickness for the given user
    * @return A String representation of the user's sickness
    */
    public String getSickness() {
        return this.sickness;
    }

    /**
    * Sets the sickness for the given user
    * @param newSickness sets the new sickness for the user
    */
    public void setSickness(String newSickness) {
        this.sickness = newSickness;
    }

    /**
    * Returns the symptoms for a given user
    * @return An ArrayList of symptoms of the user
    */
    public String getSymptoms() {
        return this.symptoms;
    }

    /**
    * Sets the symptoms for a given user
    * @param newSymptoms sets the symptoms for the user
    */
    public void setSymptoms(String newSymptoms) {
        this.symptoms = newSymptoms;
    }

    /**
    * Returns the miscellaneous information for a given user
    * @return A String representation of the user's miscellaneous information
    */
    public String getMiscInfo() {
        return this.miscInfo;
    }

    /**
    * Sets the miscellaneous information for a given user
    * @param newMiscInfo sets the miscellaneous information for the user
    */
    public void setMiscInfo(String newMiscInfo) {
        this.miscInfo = newMiscInfo;
    }
    
}

