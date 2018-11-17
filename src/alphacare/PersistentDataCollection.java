/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphacare;

/**
 *
 * @author Laura
 */
public class PersistentDataCollection {
    private UserDirectory theUserDirectory;
    private RecordList theRecordList; 
    
    public PersistentDataCollection(){
        if(theUserDirectory == null){
            theUserDirectory = new UserDirectory();
        }
        if(theRecordList == null){
            theRecordList = new RecordList(); 
        }
    }
    
    /**
     * Returns the current user directory object
     * @return theUserDirectory
     */
    public UserDirectory getUserDirectory(){
        return theUserDirectory;
    }
    public RecordList getRecordList(){
        return theRecordList; 
    }
    
}
