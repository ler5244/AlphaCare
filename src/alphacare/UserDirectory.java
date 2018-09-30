package alphacare;
import java.util.ArrayList;

/**
 *
 * @author jdq5016
 */
public class UserDirectory {
    

    private static ArrayList<User> userDirectory;
    User exampleUser = new User("example","example");
    
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
    public static boolean contains(String username, String password){
        boolean exists = false;
        for(User theUser : userDirectory){
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
    public static void addUser(User newUser){
        userDirectory.add(newUser);
    }
    
    /**
     * Removes the User newUser from the userDirectory 
     * @param targetUser Is the new User object being removed from the
     * userDirectory 
     */
    public static void removeUser(User targetUser){
        userDirectory.remove(userDirectory.indexOf(targetUser));
    }
    
    
}
