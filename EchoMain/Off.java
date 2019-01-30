package EchoMain;

/**
 * This class defines how our Echo works when it is in it's 'Off' state 
 * and moves our echo between different states dependent on user interactions.
 */
public class Off implements EchoState {

    Echo echo;

    /**
     * Creates Off echo object
     *
     * @param newEcho Echo object in Off state 
     */
    public Off(Echo newEcho) {
        echo = newEcho;
    }

    /**
     * @Override method
     * Turns Echo on and changes state to 'Listening'
     */
    @Override
    public void turnOnOff() {
        echo.setEchoState(echo.getListeningState());

    }

    /**
     * @Override method
     * Doesn't do anything in Off state as you can't mute the Echo when it's 
     * turned off
     */
    @Override
    public void mute() {
    }

    /**
     * @Override method
     * Doesn't do anything in Off state as you can't ask the Echo a question 
     * when it's off
     */
    @Override
    public void askQuestion() {}

}
