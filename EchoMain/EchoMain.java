package EchoMain;

import javax.swing.SwingUtilities;

/**
 * This class contains our main method for the Echo, and links together our 
 * EchoStates and GUI. It also starts the Controller thread that controls the
 * logic of the Echo.
 * 
 * @author Team P
*/
public class EchoMain {

    static Echo echo = new Echo(); //starts in off
    public static String TOKEN = "";
    static Thread t = new Thread(new Controller());
    
    /**
     * This method renews the access token as they expire after 10 minutes.
     * @param key1 the access key in use
     */
    static String renewAccessToken(String key1) {
        final String method = "POST";
        final String url
                = "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
        final byte[] body = {};
        final String[][] headers
                = {{"Ocp-Apim-Subscription-Key", key1}, {"Content-Length", String.valueOf(body.length)}
                };
        byte[] response = HttpConnect.httpConnect(method, url, headers, body);
        return new String(response);
    }
    /**
     * This method links together our GUI and echo states and defines what happens
     * in our simulation when the power button is pressed, with different operations
     * happing depending on the state of the echo. Also takes care of interrupting
     * and restarting the Controller thread if necessary.
     * @param t
     */
    public static synchronized void pwrBtn(Thread t) {

        if (echo.getEchoState() == echo.off) {
            // Turn on echo
            echo.turnOnOff();
            // Create Thread
            t = new Thread(new Controller());
            // Thread isnt interrupted
            Controller.r.setInter(false);
            t.start();
        } else if (echo.getEchoState() == echo.listening) {
            // Turn off echo
            echo.turnOnOff();
            // Thread is interrupted
            Controller.r.setInter(true);
            System.out.println("Turned off..........");
            t.interrupt();
        } else if (echo.getEchoState() == echo.muted) {
            // Turn off echo
            echo.turnOnOff();
            // Thread is interrupted
            Controller.r.setInter(true);
            System.out.println("Turned off..........");
            t.interrupt();
        }
    }

    /**
     * This method links together our GUI and echo states and defines what happens
     * in our simulation when the mute button is pressed, with different operations
     * happing depending on the state of the echo. Also takes care of interrupting
     * and restarting the Controller thread if necessary.
     * 
     * @param t a Thread for recording from microphone
     */
    public static synchronized void muteBtn(Thread t) {
        // Mute recording thread
        if (echo.getEchoState() == echo.listening) {
            // Interrupt Thread
            Controller.r.setInter(true);
         
            t.interrupt();
            
            echo.mute();
            System.out.println("Muted...............");
        } else {
            // Restart recording
            t = new Thread(new Controller());
            
            Controller.r.setInter(false);
            System.out.println("Unmuted.............");
            t.start();
            echo.mute();
        }

    }

    public static void main(String[] args) {
        // Initialise GUI using swing utilities
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
        });

        // Create thread to renew token every 9 mins
        Thread tokenRefresh = new Thread(() -> {
            while (true) {
                try {
                    final String KEY1 = "6cfd3579bfee48fc97efde7e9e03d742";

                    TOKEN = renewAccessToken(KEY1);
                    Thread.currentThread().sleep(9 * 60 * 1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        });
        tokenRefresh.start();
    }
}
