
package EchoMain;

/**
 * This interface enables us to use the 'State' design pattern, each method 
 * represents how a user will interact with the Echo.
 * NOTE: For later sprints the interface will likely extend eventListeners
 */
public interface EchoState{
    
    //create empty methods that will be overwritten by all state classes that 
    //implement echo state
    void turnOnOff();
    void mute();
    void askQuestion();
    
}
