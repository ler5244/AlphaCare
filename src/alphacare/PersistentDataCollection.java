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
    
    public PersistentDataCollection(){
        if(theUserDirectory == null){
            theUserDirectory = new UserDirectory();
        }
        
    }
    
    public UserDirectory getUserDirectory(){
        return theUserDirectory;
    }
}
