package EchoMain;

/**
 * This class defines how our Echo works when it is in it's 'Muted' state 
 * and moves our echo between different states dependent on user interactions.
 */
public class Muted implements EchoState {
    
    Echo echo;
    
    /**
     * Creates Muted echo object
     *
     * @param newEcho Echo object in Muted state 
    */
    public Muted(Echo newEcho){
        echo = newEcho; 
    }
    
    /**
     * @Override method
     * Turns Echo off and changes state to 'Off'
    */
    @Override
    public void turnOnOff() {
        echo.setEchoState(echo.getOffState());
    }
    
    /**
     * @Override  method
     * Un-mutes Echo and changes state to 'Listening'
    */
    @Override
    public void mute() {
        echo.setEchoState(echo.getListeningState());
    }
    
    /**
     * @Override method
     * Doesn't do anything in this state as you cant ask the echo a question
     * whilst its muted
    */
    @Override
    public void askQuestion() {}
}