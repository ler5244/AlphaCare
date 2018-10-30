/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

import java.util.ArrayList;
/**
 *
 * @author JoeQ7
 */
public class MedicalUser extends User{
    private ArrayList<PatientUser> myPatientList = new ArrayList<PatientUser>();
    
    /**
     * constructor, introduces a new private ArrayList of patient users
     * @param newUsername super
     * @param newPassword super
     * @param fName super 
     * @param lName super
     */
    public MedicalUser(String newUsername, String newPassword, String fName, String lName) {
        super(newUsername, newPassword, fName, lName);
         myPatientList = new ArrayList<PatientUser>();
    }
    
    /**
     * Returns the private Patient list
     * @return myPatientList
     */
    public ArrayList<PatientUser> getMyPatientList(){
        return myPatientList;
    }
    /**
     * Sets the private Patient list, myPatientList
     * @param newList 
     */
    public void setMyPatientList(ArrayList<PatientUser> newList){
        myPatientList = newList;
    }
    
    /**
     * Returns a Patient from private myPatientList
     * @param lastName queries by last name
     * @param firstName queries by first name
     * @return matching Patient
     */
    public PatientUser getPatient(String lastName, String firstName){
        for(PatientUser patient: myPatientList){
            if( patient.getLastName().equals(lastName) && patient.getLastName().equals(firstName)){
                return patient;
            }
        }
        return new PatientUser("error","error","error","error");
    }
    
    /**
     * adds a Patient to the myPatientList.
     * @param Patient added
     */
    public void addPatient(PatientUser patient){
        myPatientList.add(patient);
    }
    
    /**
     * removes a patient from target PatientList
     * @param targetUser is removed from myPatientList 
     */
    public void removePatient(PatientUser targetUser){
        myPatientList.remove(myPatientList.indexOf(targetUser));
    }
}
