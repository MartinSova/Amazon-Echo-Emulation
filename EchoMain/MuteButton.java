package EchoMain;

import static EchoMain.EchoMain.echo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This Class defines the mute button behavior for our GUI what happens when it is
 * pressed and extends the JButton interface
 */
public class MuteButton extends JButton {

    MuteButton(ImageIcon img) {
        setIcon(img); // setting the icon to the ImageIcon in the parameter (img)
        setBorder(null); // setting border to null
        addMouseListener(new MouseAdapter() {
            @Override
            /*
             This overrided method defines what happens when the mute button is 
             clicked upon
             */
            public void mousePressed(MouseEvent e) {
                //calls 
                GUI.muteDownClick();

            }

            @Override
            /*
             This overrided method defines what happens when the mute button has 
             a mouse click released on it
             */
            public void mouseReleased(MouseEvent e) {
                //if echo is in answering mode
                if (echo.getEchoState() == echo.answering) {
                    GUI.muteBtnReleaseClickAnsMode();
                } else {
                    GUI.muteReleaseClick();
                    if (echo.getEchoState() != echo.off) {
                        EchoMain.muteBtn(EchoMain.t);
                    }
                }

            }
        });
    }
}
