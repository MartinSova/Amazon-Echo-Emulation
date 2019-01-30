/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EchoMain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jackmarsh
 */
public class Controller implements Runnable {

    static RecordSound r = new RecordSound();
    SpeechToText s = new SpeechToText();
    JSONParser parser = new JSONParser();
    Computational c = new Computational();
    TextToSpeech t = new TextToSpeech();

    @Override
    public synchronized void run() {

        // Record Sound
        System.out.println("Recording speech....");
        r.record();

        if (!r.getInter()) {

            // Speech to text
            System.out.println("Processing speech...");
            String text = s.s2t();

            // parse text
            System.out.println("Parsing text........");
            String toWolfram = parser.parseCognitive(text);
            System.out.println(toWolfram);

            switch (toWolfram) {
                case "Turn off.":
                    System.out.println("Turning off.........");
                    GUI.pwrReleaseClick();
                    EchoMain.pwrBtn(EchoMain.t);
                    r.setInter(false);
                    break;
                case "Mute.":
                    System.out.println("Muting..............");
                    GUI.muteReleaseClick();
                    EchoMain.muteBtn(EchoMain.t);
                    r.setInter(false);
                    break;
                default:
                    // Change to Answering state
                    GUI.answeringNow = true;
                    try {
                        GUI.answeringMode();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    EchoMain.echo.askQuestion();

                    // Wolfram Alpha
                    System.out.println("Finding Answer......");
                    String answer = c.compute(toWolfram);

                    // Parse answer
                    System.out.println("Parsing Answer......");
                    String toSpeak = parser.parseWolfram(answer);
                    System.out.println(toSpeak);

                    if (!"".equals(toSpeak)) {
                        // Text to speech
                        System.out.println("Speaking Answer.....");
                        t.t2s(toSpeak);
                        // Change to listening state
                        GUI.answeringNow = false;
                        Answering.questionAnswered = true;
                    } else {
                        // Text to speech
                        System.out.println("Speaking Answer.....");
                        t.t2s("Sorry, I couldnt find an answer");
                        // Change to listening state
                        GUI.answeringNow = false;
                        Answering.questionAnswered = true;
                    }

                    try {
                        GUI.answeringMode();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    EchoMain.echo.setEchoState(EchoMain.echo.getOffState());
                    EchoMain.pwrBtn(EchoMain.t);
                    break;
            }
        }
    }

}
