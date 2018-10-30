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
public class PatientUser extends User{
    private ArrayList<MedicalUser> myDoctorList;
    
    /**
     * constructor, extends User and adds a myDoctorList attribute to it.
     * @param newUsername
     * @param newPassword
     * @param fName
     * @param lName 
     */
    public PatientUser(String newUsername, String newPassword, String fName, String lName) {
        super(newUsername, newPassword, fName, lName);
        myDoctorList = new ArrayList<MedicalUser>();
    }
   
    /**
     * Returns the private doctor list
     * @return myDoctorList
     */
    public ArrayList<MedicalUser> getMyDoctorList(){
        return myDoctorList;
    }
    /**
     * Sets the private doctor list, myDoctorList
     * @param newList 
     */
    public void setMyDoctorList(ArrayList<MedicalUser> newList){
        myDoctorList = newList;
    }
    
    /**
     * Returns a doctor from private myDoctorList
     * @param lastName queries by last name
     * @param firstName queries by first name
     * @return matching doctor
     */
    public MedicalUser getDoctor(String lastName, String firstName){
        for(MedicalUser doctor: myDoctorList){
            if( doctor.getLastName().equals(lastName) && doctor.getLastName().equals(firstName)){
                return doctor;
            }
        }
        return new MedicalUser("error","error","error","error");
    }
    
    /**
     * adds a doctor to the myDoctorList.
     * @param doctor added
     */
    public void addDoctor(MedicalUser doctor){
        myDoctorList.add(doctor);
    }
    
    /**
     * removes a doctor from target DoctorList
     * @param targetUser is removed from myDoctorList 
     */
    public void removedoctor(MedicalUser targetUser){
        myDoctorList.remove(myDoctorList.indexOf(targetUser));
    }
    
}
