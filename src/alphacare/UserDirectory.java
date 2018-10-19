package alphacare;
import java.util.ArrayList;

/**
 *
 * @author jdq5016
 */
public class UserDirectory {
    
    private ArrayList<User> directory = new ArrayList();
    
    public UserDirectory(){
        directory = new ArrayList();
        ArrayList<User> newDirectory = new ArrayList<User>();
        User exampleUser = new User("example","example", "example", "example");
        newDirectory.add(exampleUser);
        directory = newDirectory;
    }
    
    /**
     * Checks to see if the provided String username and String password match
     * the username and password of any user in the userDirectory.
     * @param username Is the username String value the usernames in the 
     * directory are checked against.
     * @param password Is the password String value the passwords in the 
     * directory are checked against.
     * @return Returns boolean exist which represents if the user authentication
     * was a success.
     */
    public boolean contains(String username, String password){
        boolean exists = false;
        for(User theUser : directory){
            if(theUser.getUsername().equals(username) &&
                    theUser.getPassword().equals(password)){
                exists = true;
            }
            
        }
        return exists;
    }
    
    /**
     * Adds the User newUser to the userDirectory 
     * @param newUser Is the new User object being added to the userDirectory
     */
    public void addUser(User newUser){
        directory.add(newUser);
    }
    
    /**
     * Removes the User newUser from the userDirectory 
     * @param targetUser Is the new User object being removed from the
     * userDirectory 
     */
    public void removeUser(User targetUser){
        directory.remove(directory.indexOf(targetUser));
    }
    public ArrayList<User> getDirectory() {
        return directory;
    }

    public void setDirectory(ArrayList<User> directory) {
        this.directory = directory;
    }
    
}
