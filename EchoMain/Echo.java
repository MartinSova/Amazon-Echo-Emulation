package EchoMain;

/**
 * "Echo" is the main class, that provides "context" for the "EchoStates" as defined in 
 * the state design pattern.  
 */
public class Echo {
    
    //Defines EchoState variables for each of the states our Echo can be in
    EchoState off;
    EchoState listening;
    EchoState answering;
    EchoState muted; 
    
    //Create a placeholder state that will change between states
    EchoState echoState; 

    /**
    This no argument constructor for an Echo object, defines each of its possible
    states and then sets it's starting state to 'off'
    */
    public Echo(){
        
        off = new Off(this);
        listening = new Listening(this);
        answering = new Answering(this);
        muted = new Muted(this);
        
        echoState = off; 
        
    }
    
    /**
    This method allows us to change EchoStates
    
    @param newEchoState - The state we will be changing to
    */
    void setEchoState(EchoState newEchoState){
        
        echoState = newEchoState; 
    }
    
    /**
     * This method returns the current state the echo is in 
     * @return echoState
     */
    EchoState getEchoState(){
     
        return echoState;
    }
    
    /**
    This method defines the 'turnOnOff' user interaction
    */
    public void turnOnOff(){
        echoState.turnOnOff();
    }
    
    /**
    This method defines the 'mute' user interaction
    */
    public void mute(){
        echoState.mute();
    }
    
    /**
    This method defines the 'askQuestion' user interaction
    */
    public void askQuestion(){
        echoState.askQuestion(); 
    }
    
    /**
    This method will return the 'Off' state of the echo
     * @return the 'off' state of the echo
    */
    public EchoState getOffState(){
        return off;
    }
    
    /**
    This method will return the 'Listening' state of the echo
     * @return the 'listeneing' state of the echo
    */
    public EchoState getListeningState(){
        return listening;
    }
    
    /**
    This method will return the 'Answering' state of the echo
     * @return the 'answering' state of the echo
    */
    public EchoState getAnsweringState(){
        return answering;
    }
    
    /**
    This method will return the 'Muted' state of the echo
     * @return the 'muted' state of the echo
    */
    public EchoState getMutedState(){
        return muted;
    }
    
}
