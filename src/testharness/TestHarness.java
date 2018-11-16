
package testharness;

import alphacare.CreateAccountUIController;
import alphacare.CreateRecordController;
import alphacare.PersistentDataController;
import alphacare.Record;
import alphacare.UpdateRecordController;
import alphacare.ViewRecordController;
import alphacare.User;
import java.util.ArrayList;
import javafx.stage.Stage;

/**
 *
 * @author ags12
 */
public class TestHarness {
    
    public static void main(String[] args) {
        testCreateAccountController();
        testViewRecordController();
        testCreateRecordController();
        testupdateRecordController();
        
    }
    
    
    
    public static void testDoctorPatientRemoveUser(){
        ArrayList<PatientUser> patients = new ArrayList<PatientUser>();
        ArrayList<MedicalUser> doctors = new ArrayList<MedicalUser>();
        String[] checkDoctors = new String[3];
        
        //develop the patients and doctors
        PatientUser p1 = new PatientUser("p1","p1","p1","p1");
        PatientUser p2 = new PatientUser("p2","p2","p2","p2");
        PatientUser p3 = new PatientUser("p3","p3","p3","p3");
        MedicalUser m1 = new MedicalUser("m1","m1","m1","m1");
        MedicalUser m2 = new MedicalUser("m2","m2","m2","m2");
        MedicalUser m3 = new MedicalUser("m3","m3","m3","m3");
        
        //add doctors to paitent's list, add paitent to the doctors's lists
        p1.addDoctor(m1); m1.addPatient(p1);
        p1.addDoctor(m2); m2.addPatient(p1);
        p1.addDoctor(m3); m3.addPatient(p1);
        
        //add paitents to doctor's list, add doctor to patients lists
        m1.addPatient(p2); p2.addDoctor(m1);
        m1.addPatient(p3); p3.addDoctor(m1);
        
        //add new users to their respective arraylists
        patients.add(p1); patients.add(p2); patients.add(p3);
        doctors.add(m1); doctors.add(m2); doctors.add(m3);
        
        //checker function for result comparison
        int i = 0;
        for(MedicalUser doctor : p1.getMyDoctorList()){
            checkDoctors[i] = doctor.getFirstName();
            i++;
        }
        
        DoctorPatient mediator = new DoctorPatient(patients, doctors);
        
        mediator.removeUser(p1);
        doctors = mediator.getDoctors();
        patients = mediator.getPatients();
        
        /**
         * Checks removeUser(PatientUser targetPatient)
         */
        boolean firstCheck = checkP(patients,doctors, p1);
        
        /**
         * Checks public void removeUser(MedicalUser targetDoctor)
         */
        mediator.removeUser(m1);
        doctors = mediator.getDoctors();
        patients = mediator.getPatients();
        boolean secondCheck = checkM(patients,doctors,m1);
        
        /**
         * Checks public void addPatientDoctors(PatientUser targetPatient, ArrayList<MedicalUser> assignedDoctors)
         */
        PatientUser p4 = new PatientUser("p4","p4","p4","p4");
        patients.add(p4);
        doctors.add(m1);
        
        ArrayList<MedicalUser> assignedDoctors = new ArrayList<>();        
        assignedDoctors.add(m1); assignedDoctors.add(m2); assignedDoctors.add(m3);
        
        
        mediator = new DoctorPatient(patients, doctors);
        mediator.addPatientDoctors(p4, assignedDoctors);
        doctors = mediator.getDoctors();
        patients = mediator.getPatients();
        
        boolean thirdCheck = checkAddPatientDoctors(patients, doctors, assignedDoctors.size(), p4);
        if(firstCheck && secondCheck && thirdCheck){
            System.out.println("DoctorPatient Mediator Successfully executed all functions");
        }else{
            System.out.println("DoctorPatient Mediator was unsucessfully executed");
        }
        
    }
    
    /**
     * Checks to see if the mediator successfully deleted the user. Returns true if it does.
     * @param patients 
     * @param doctors
     * @param p1
     * @return 
     */
    public static boolean checkP(ArrayList<PatientUser> patients, ArrayList<MedicalUser> doctors, PatientUser p1){
        if(patients.contains(p1))System.out.println("error, patient not deleted");
        int count = 0;
        for(MedicalUser doctor : doctors){
            if(doctor.getMyPatientList().contains(p1))
            {System.out.println("Error, patient exists in a record");
            return false;}
            else{count++;}
        }
        if(count < 3){
            System.out.println("Error, not all patient records were deleted");
            return false;
        }
        if(count == 3) {
            System.out.println("DoctorPatient Mediator Successfully removed a medical user");
            return true;
        }
        return false;
    }
    
    /**
     * Checks to see if the mediator successfully deleted the user. Returns true if it does.
     * @param patients 
     * @param doctors
     * @param m1
     * @return 
     */
    public static boolean checkM(ArrayList<PatientUser> patients, ArrayList<MedicalUser> doctors, MedicalUser m1){
        if(doctors.contains(m1))System.out.println("error, doctor not deleted");
        int count = 0;
        for(PatientUser patient : patients){
            if(patient.getMyDoctorList().contains(m1))
            {System.out.println("Error, doctor exists in a record");
            return false;}
            else{count++;}
        }
        if(count < 2){
            System.out.println("Error, not all Doctor records were deleted");
            return false;
        }
        if(count == 2) {
            System.out.println("DoctorPatient Mediator Successfully executed addPatientDoctors");
            return true;
        }
        return false;
    }
    
    /**
     * Checks to see if the DoctorPatient mediator successfully add a list of doctors to a user
     * and has assigned the user to the doctors in question. 
     * @param patients
     * @param doctors
     * @param size
     * @param p4
     * @return 
     */
    public static boolean checkAddPatientDoctors(ArrayList<PatientUser> patients, ArrayList<MedicalUser> doctors, int size , PatientUser p4){
        if(!patients.contains(p4)){
            System.out.println("Error, patient does not exist.");
            return false;
        }else{
            int i = 0;
            for(MedicalUser doctor : doctors){
              if(doctor.getMyPatientList().contains(p4)){
                  i++;
              }  
            }
            if(i == size){
                System.out.println("DoctorPatient Mediator Successfully removed a medical user");
                return true;
            }
        }
        
        return false;
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
     * Tests out the CreateAccountController in the alphacare package Outputs if
     * the controller properly created the new account or not
     */
    /*
    public static void testCreateAccountController() {
        Stage stage = new Stage();
        CreateAccountUIController cntl = new CreateAccountUIController();

        //Data for new account
        String testUserName = "Alex5p";
        String testPassWord = "422";
        User user = new User(testUserName,testPassWord,"","");

        PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory().add(user);
        PersistentDataController.getPersistentDataCntl().writeJSONDataModel();
        
        ArrayList accountList = PersistentDataController.getPersistentDataCntl().getPersistentDataCollection().getUserDirectory().getDirectory();
        
        /*
        CreateAccount createAccount = cntl.createNewAccount(testUserName, testPassWord, "", "");

        //check if account was succesfully created
        if (createAccount != null) {
            System.out.println("Create Account Controller successfully created a new account");
        } else {
            System.out.println("Create Account Controller failed to created a new account");
        }
        */
    }
    */

    /**
     * Tests out the updateRecordController in the alphacare package Outputs if
     * the controller properly updated a record or not
     */
    public static void testupdateRecordController() {
        UpdateRecordController cntl = new UpdateRecordController();

        //data for an updated record
        String testSickness = "hot";

        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add("fever");
        testSymptoms.add("congestion");

        String testMiscInfo = "Having trouble sleeping";

        Record testRecord = cntl.updateRecord(testSickness, testSymptoms, testMiscInfo);

        // check if the record was successfully updated
        if (testRecord != null) {
            System.out.println("Update Record Controller successfully updated the record");
        } else {
            System.out.println("Update Record Controller failed to update the record");
        }
    }

    /**
     * Tests out the ViewRecordController in the alphacare package
     * Outputs if the controller properly viewed the record or not
     */
    public static void testViewRecordController() {

        ViewRecordController cntl = new ViewRecordController();

        // data for the new record
        String testSickness = "cold";

        ArrayList<String> testSymptoms = new ArrayList();
        testSymptoms.add("fever");
        testSymptoms.add("congestion");

        String testMiscInfo = "Having trouble sleeping";

        Record testRecord = cntl.getRecord(testSickness, testSymptoms, testMiscInfo);

        // check if the record is viewed successfully
        if (testRecord != null) {
            System.out.println("View Record Controller successfully viewed a record");
        } else {
            System.out.println("View Record Controller failed to view a record");
        }

    }
    
        
        
    }



    
