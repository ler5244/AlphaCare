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
public class DoctorPatient {
    /**
     * place holder until we can implement this into the database
     */
   //private PatientUser examplePatient = new PatientUser("1","1","1","1");
   //private MedicalUser exampleMedical = new MedicalUser("2","2","2","2");
   private ArrayList<PatientUser> patients;
   private ArrayList<MedicalUser> doctors;
    
   
   public DoctorPatient(ArrayList<PatientUser> newPatients, ArrayList<MedicalUser> newDoctors){
      this.patients = newPatients;
      this.doctors = newDoctors;
   } 
   
   /**
    * Removes the User from the database, and any connections they may be a part of.
    * Used to remove user's trail from the database.
    * @param targetUser is the one being removed 
    */
   public void removeUser(PatientUser targetPatient){
       if(patients.contains(targetPatient)){
           //get the target's doctor list
           ArrayList<MedicalUser> targetDoctorList = targetPatient.getMyDoctorList();
           //remove the target from all the doctor's patients lists
            for (MedicalUser doctor : doctors){
                //for every doctor on the list, remove the paitent from their lists
                if(targetDoctorList.contains(doctor)){
                    doctor.removePatient(targetPatient);
                }else{
                    System.out.println("Error,Patient is not assigned to any doctors");
                }
            }
           patients.remove(patients.indexOf(targetPatient));
           
       }else {
           System.out.println("Error, Patient does not exist");
       }
   }
   
   /**
    * Removes the User from the database, and any connections they may be a part of.
    * Used to remove user's trail from the database.
    * @param targetDoctor is the one being removed 
    */
   public void removeUser(MedicalUser targetDoctor){
       if(doctors.contains(targetDoctor)){
           //get the target's paitent list
           ArrayList<PatientUser> targetPaitentList = targetDoctor.getMyPatientList();
           //remove the target from all the paitents's doctor lists
            for (PatientUser patient : patients){
                //for every doctor on the list, remove the paitent from their lists
                if(targetPaitentList.contains(patient)){
                    patient.removedoctor(targetDoctor);
                }else{
                    System.out.println("Error,Doctor is not assigned to any paitents");
                }
            }
           doctors.remove(doctors.indexOf(targetDoctor));
           
       }else {
           System.out.println("Error, Doctor does not exist");
       }
   }
   
   /**
    * This method adds a patient to the patient lists of 0 to many doctors
    * It also adds the patient to the input ArrayList of MedicalUsers.
    * @param targetPatient is the patient added.
    * @param assignedDoctors  is the doctors who the patient is assigned to. 
    */
   public void addPatientDoctors(PatientUser targetPatient, ArrayList<MedicalUser> assignedDoctors){
       ArrayList<MedicalUser> doctorsToAdd = new ArrayList<>();
       
       //get patient user's doctors list
        ArrayList<MedicalUser> patientsDoctors = targetPatient.getMyDoctorList();
       
       //add supplied doctors to the patient's list
       for(MedicalUser doctor : assignedDoctors){
           if(!patientsDoctors.contains(doctor)){
               targetPatient.addDoctor(doctor);
               doctorsToAdd.add(doctor);
           }
       }
       //add patient to the doctors' lists
       for(MedicalUser doctor : doctorsToAdd){
           if(!doctor.getMyPatientList().contains(targetPatient)){
               doctor.addPatient(targetPatient);
           }
       }
   }
   
  
   /**
    * Returns the private patients list, for testing class
    * @return 
    */
   public ArrayList<PatientUser> getPatients(){
       return patients;
   }
   
   /**
    * Returns the private doctor list, for testing class
    * @return 
    */
   public ArrayList<MedicalUser> getDoctors(){
       return doctors;
   }
}
