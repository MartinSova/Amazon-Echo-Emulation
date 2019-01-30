package EchoMain;

/**
 * This class defines how our Echo works when it is in it's 'Answering' state 
 * and moves our echo between different states dependent on user interactions.
 */
public class Answering implements EchoState {
    
    static boolean questionAnswered = false; 
    Echo echo;
    
    /**
     * Creates Answering object
     *
     * @param newEcho Echo object in Answering state 
    */
    public Answering(Echo newEcho){
        echo = newEcho; 
    }
    
    /**
     * @Override method
     * Doesn't do anything in Answering state as you can't turn the Echo off
     * whilst it's answering a question
    */
    @Override
    public void turnOnOff() {}
    
    /**
    * @Override method
    * Doesn't do anything in Answering state as you can't mute the Echo whilst
    * it's answering a question
    */
    @Override
    public void mute() {}
    
    /**
     * @Override method
     * Changes the state once a question has been answered
    */
    @Override
    public void askQuestion() {
        // Once question has been answered change to listening state
        if(questionAnswered = true){
            echo.setEchoState(echo.getListeningState());
            questionAnswered = false;
        } else {
            throw new RuntimeException("Trying to set back to listening before Echo"
                    + "has finished answering question");
        }
    }
   
}