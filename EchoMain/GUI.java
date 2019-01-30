/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoMain;

/**
 *
 * @author Team P
 */
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.sound.sampled.*;
import java.io.IOException;
import static java.lang.Thread.MAX_PRIORITY;
import java.util.concurrent.TimeUnit;

public final class GUI extends JFrame {

    /**
     A method developed to generate all ImageIcons for images and buttons used for the
     user interface.
     * @param url is the location of the image that is used
     * @param val1 is the integer value to which the width of the image is scaled
     * @param val2 is the integer value to which the height of the image is scaled
     * @return the ImageIcon used for implementation in the user interface, may that be
     used for a button or an image that completes the Echo design
     */
    public static ImageIcon scaleImage(String url, int val1, int val2) {
        ImageIcon icon = new ImageIcon(url); // assign an image icon to a variable
        Image img = icon.getImage(); // create an image from the scaling
        Image scaledbtn = img.getScaledInstance(val1, val2, Image.SCALE_SMOOTH); // scale image to desired a height and width
        ImageIcon icon2 = new ImageIcon(scaledbtn); // assign a variable to the new, scaled image
        return icon2; // return final, scaled image icon for further use
    }

    public static JLabel[] answeringAnimation = new JLabel[25];

    public void makeAnimation() {
        for (int i = 0; i < 25; i++) {
            final ImageIcon temporary = scaleImage("EchoMain/imageAssets/Animations/" + (i+1) + ".png", 621, 621);
            answeringAnimation[i] = new JLabel(temporary);
        }

    }

    final static ImageIcon mutebtn = scaleImage("EchoMain/imageAssets/mutebtn.png", 70, 70);
    static JLabel mutebtnlabel = new JLabel(mutebtn); // assign an ImageIcon to a Jlabel for manipulation within the frame
    final MuteButton muteFbtn = new MuteButton(mutebtn);
    // create a mute button using the private class MuteButton; an image icon is passed as an argument

    final static ImageIcon powerbtn = scaleImage("EchoMain/imageAssets/powerbtn.png", 70, 70);
    static JLabel powerbtnlabel = new JLabel(powerbtn);
    final PowerButton powerFbtn = new PowerButton(powerbtn);
    // create a power button using the private class PowerButton; an image icon is passed as an argument

    final static ImageIcon oncircle = scaleImage("EchoMain/imageAssets/lmCircle.png", 621, 621);
    static JLabel oncirclelabel = new JLabel(oncircle);

    final static ImageIcon mutecircle = scaleImage("EchoMain/imageAssets/mute.png", 621, 621);
    static JLabel mutecirclelabel = new JLabel(mutecircle);

    final static ImageIcon answeringcircle = scaleImage("EchoMain/imageAssets/amCircle.png", 621, 621);
    static JLabel answeringcirclelabel = new JLabel(answeringcircle);

    final static ImageIcon powerbtnDWNLIGHT = scaleImage("EchoMain/imageAssets/powerbtnDWNLIGHT.png", 70, 70);
    static JLabel powerbtnDWNLIGHTlabel = new JLabel(powerbtnDWNLIGHT);

    final static ImageIcon powerbtnLIGHT = scaleImage("EchoMain/imageAssets/powerbtnLIGHT.png", 70, 70);
    static JLabel powerbtnLIGHTlabel = new JLabel(powerbtnLIGHT);

    final static ImageIcon powerbtnDWN = scaleImage("EchoMain/imageAssets/powerbtnDWN.png", 70, 70);
    static JLabel powerbtnDWNlabel = new JLabel(powerbtnDWN);

    final static ImageIcon mutebtnDWN = scaleImage("EchoMain/imageAssets/mutebtnDWN.png", 70, 70);
    static JLabel mutebtnDWNlabel = new JLabel(mutebtnDWN);

    final static ImageIcon mutebtnDWNON = scaleImage("EchoMain/imageAssets/mutebtnDWNON.png", 70, 70);
    static JLabel mutebtnDWNONlabel = new JLabel(mutebtnDWNON);

    final static ImageIcon mutebtnOn = scaleImage("EchoMain/imageAssets/mutebtnOn.png", 70, 70);
    static JLabel mutebtnOnlabel = new JLabel(mutebtnOn);

    final static ImageIcon off = scaleImage("EchoMain/imageAssets/off.png", 621, 621);
    static JLabel offlabel = new JLabel(off);

    static Boolean muteOn = false; // muteOn boolean is used to determine whether the product is in a muted state
    static Boolean powerOn = false; // powerOn boolean is used to determine where the product is in a muted state

    /**
     *A method developed to create and play a clip.
     * @param clipName is the name of the .wav clip that is used
     */
    public static void playClip(String clipName) {
        try {
            Clip clip = AudioSystem.getClip(); // create a Clip variable
            // create and audio input stream using the url of the clip
            AudioInputStream inputStream1 = AudioSystem.getAudioInputStream(GUI.class.getResourceAsStream(clipName));
            clip.open(inputStream1); // open clip
            clip.start(); // play clip
        } // the following are the appropriate excpetions that we want to handle when playing a clip
        catch (LineUnavailableException e) {
            System.out.println("Line is unavailable.");
        } catch (IOException e) {
            System.out.println("There has been a failed I/O when playing a clip..");

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file isunsupported.");
        }
    }

    /**
     *A method developed to modify the UI when the power button is pressed down.
     */
    public static void pwrDownClick() {
        if (powerOn) { // if device is already on
            powerbtnDWNLIGHTlabel.setVisible(true); // down press is lit
        } else { // device is in the "off" state
            powerbtnDWNlabel.setVisible(true); // down press is not lit up
        }
    }
    /**
     *A method developed to modify the UI when the power button is pressed (released).
     */
    public static void pwrReleaseClick() {
        if (powerOn) {
            powerbtnDWNLIGHTlabel.setVisible(false);
        } else {
            powerbtnDWNlabel.setVisible(false);
        }

        if (!powerOn) { // if device was in the off state before the user clicked the power button
            playClip("soundAssets/On.wav");
            oncirclelabel.setVisible(true); // set "on" circular cyan light design around the Echo to visible
            powerbtnLIGHTlabel.setVisible(true); // set the image representing that the power button is on (with cyan light) to visible
            powerOn = true;

        } else if (powerOn) { // if device was already on (hence, it is being turned off by the user)
            powerbtnLIGHTlabel.setVisible(false); // turn off power button that signifies that device is turned on
            playClip("soundAssets/Off.wav");
            if (!muteOn) {
                oncirclelabel.setVisible(false); // only set the color signifying the "on" state to invisible

            } else { // if device was on mute when being turned off, set all mute lights to invisible
                mutebtnOnlabel.setVisible(false);
                mutecirclelabel.setVisible(false);
                mutebtnDWNlabel.setVisible(false);
                muteOn = false; // mute is turned off when device as a whole is turned off

            }
            powerOn = false; // device is powered off
        }

    }

    /**
     *A method developed to modify the UI when the power button is pressed,
     *but the device is in listening mode - hence, echo does not respond to power button click.
     */
    public static void pwrBtnReleaseClickAnsMode() {
        powerbtnDWNLIGHTlabel.setVisible(false);
        // if in answering code, state does not change (when power button pressed) - so neither does UI
    }

    static boolean answeringNow = false;
    // a boolean for when in answering mode for appropriate UI actions

    /**
     *A method developed to modify the UI when the mute button is pressed down.
     */
    public static void muteDownClick() {
        if (muteOn) { // if device is already muted
            mutebtnDWNONlabel.setVisible(true); // down press is lit
        } else { // device is in the "off" state or is not muted
            mutebtnDWNlabel.setVisible(true); // down press is not lit up
        }
    }

    /**
     *A method developed to modify the UI when the mute button is pressed (released).
     */
    public static void muteReleaseClick() {
        if (muteOn) {
            mutebtnDWNONlabel.setVisible(false);
        } else {
            mutebtnDWNlabel.setVisible(false);
        }

        if (!powerOn) { // is device is powered off, do not execute code (but button clicked is still animated to facilitate a realistic experience)
              /*
             We do not disable the button before the device is turned because we still
             animate a button click for a realistic experience. However, not code is
             actually executed.
             */

        } else if (!muteOn) { // device is powered on and not muted
            // play mute sound and set appropriate mute lights (for buttong and Echo circle light)
            playClip("soundAssets/Mute.wav");
            mutebtnOnlabel.setVisible(true);
            mutecirclelabel.setVisible(true);
            oncirclelabel.setVisible(false); // turn power Echo light off to facilitate a better look (preventing overlapping light glow)
            muteOn = true;

        } else if (muteOn) { // device is powered on and muted
            // play unmute sound and set approparite lighting for returning back to listening mode
            playClip("soundAssets/Unmute.wav");
            oncirclelabel.setVisible(true);
            mutecirclelabel.setVisible(false);
            mutebtnOnlabel.setVisible(false);
            muteOn = false;
        }
    }

    /**
     *A method developed to modify the UI when the mute button is pressed,
     *but the device is in listening mode - hence, echo does not respond to mute button click.
     */
    public static void muteBtnReleaseClickAnsMode() {
        mutebtnDWNlabel.setVisible(false);
    }


    /**
     * A method developed to modify the UI when the device
     * is in answering mode.
     */
    public static void answeringMode() throws InterruptedException {

        if (answeringNow) {
            oncirclelabel.setVisible(false);
            answeringcirclelabel.setVisible(true);

        } else {
            oncirclelabel.setVisible(false);
            answeringAnimationBackward();

            answeringcirclelabel.setVisible(false);
            oncirclelabel.setVisible(true);
        }

    }

    public static void answeringAnimationBackward() {
        Runnable r = () -> {
            try {
                for (int i = 24; i > 0; i--) {

                    answeringAnimation[i].setVisible(true);
                    if (i != 24) {
                        answeringAnimation[i + 1].setVisible(false);
                    }
                    TimeUnit.MILLISECONDS.sleep(15);
                }
                answeringAnimation[1].setVisible(false);
                TimeUnit.MILLISECONDS.sleep(15);
                answeringAnimation[0].setVisible(false);

            } catch (InterruptedException e) {

            }

        };
        Thread gif = new Thread(r);
        gif.setPriority(MAX_PRIORITY);
        gif.start();
    }

    /**
     * A GUI constructor used to set the content pane,
     * and positions of labels in the UI.
     */
    public GUI() {
        setTitle("Echo");
        setLayout(null);
        // the background color matches the color of our Echo device to create a professional look
        Color bgColor = Color.decode("#2d2d2d");
        getContentPane().setBackground(bgColor);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        makeAnimation();

        for (int i = 0; i < 25; i++) {
            answeringAnimation[i].setBounds(-100, -95, 791, 784);
            add(answeringAnimation[i]);
            answeringAnimation[i].setVisible(false);
        }

        // images and buttong layered and bounded in an appropriate manner to create a realistic and professional look
        mutebtnDWNlabel.setBounds(155, 260, 70, 70);
        add(mutebtnDWNlabel);
        mutebtnDWNlabel.setVisible(false);
        mutebtnDWNONlabel.setBounds(155, 260, 70, 70);
        add(mutebtnDWNONlabel);
        mutebtnDWNONlabel.setVisible(false);
        mutebtnOnlabel.setBounds(155, 260, 70, 70);
        add(mutebtnOnlabel);
        mutebtnOnlabel.setVisible(false);
        mutebtnlabel.setBounds(155, 260, 70, 70);
        add(mutebtnlabel);
        muteFbtn.setBounds(155, 260, 70, 70);
        add(muteFbtn);
        oncirclelabel.setBounds(-100, -95, 791, 784);
        add(oncirclelabel);
        oncirclelabel.setVisible(false);

        powerbtnDWNLIGHTlabel.setBounds(367, 260, 70, 70);
        add(powerbtnDWNLIGHTlabel);
        powerbtnDWNLIGHTlabel.setVisible(false);
        powerbtnLIGHTlabel.setBounds(367, 260, 70, 70);
        add(powerbtnLIGHTlabel);
        powerbtnLIGHTlabel.setVisible(false);
        powerbtnDWNlabel.setBounds(367, 260, 70, 70);
        add(powerbtnDWNlabel);
        powerbtnDWNlabel.setVisible(false);
        powerbtnlabel.setBounds(367, 260, 70, 70);
        add(powerbtnlabel);
        powerFbtn.setBounds(367, 260, 70, 70);
        add(powerFbtn);
        mutecirclelabel.setBounds(-100, -95, 791, 784);
        add(mutecirclelabel);
        mutecirclelabel.setVisible(false);
        answeringcirclelabel.setBounds(-100, -95, 791, 784);
        add(answeringcirclelabel);
        answeringcirclelabel.setVisible(false);
        // the initial "off" state design of the Echo is added to the frame
        offlabel.setBounds(-100, -95, 791, 784);
        add(offlabel);
        setLocationRelativeTo(null);
        setSize(595, 600);
        setResizable(false);
    }
}
