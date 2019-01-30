package EchoMain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * Text to speech conversion using Microsoft Cognitive Services.
 *
 * See http://www.microsoft.com/cognitive-services/en-us/speech-api
 *
 * David Wakeling, 2017.
 */
public class TextToSpeech {

    final static String LANG = "en-US";
    final static String GENDER = "Female";
    final static String OUTPUT = "output.wav";
    final static String FORMAT = "riff-16khz-16bit-mono-pcm";

    final static String KEY1 = "6cfd3579bfee48fc97efde7e9e03d742";

    /* final static String KEY2   = "ea072146f15446ed89d1c9f2498c0d87"; */


    /*
     * Synthesize speech.
     */
    static byte[] synthesizeSpeech(String token, String text,
            String lang, String gender,
            String format) {
        final String method = "POST";
        final String url = "https://speech.platform.bing.com/synthesize";
        final byte[] body
                = ("<speak version='1.0' xml:lang='en-us'>"
                + "<voice xml:lang='" + lang + "' "
                + "xml:gender='" + gender + "' "
                + "name='Microsoft Server Speech Text to Speech Voice"
                + " (en-US, ZiraRUS)'>"
                + text
                + "</voice></speak>").getBytes();
        final String[][] headers
                = {{"Content-Type", "application/ssml+xml"},
                {"Content-Length", String.valueOf(body.length)},
                {"Authorization", "Bearer " + token},
                {"X-Microsoft-OutputFormat", format}
                };
        byte[] response = HttpConnect.httpConnect(method, url, headers, body);
        return response;
    }

    /*
     * Write data to file.
     */
    static void writeData(byte[] buffer, String name) {
        try {
            File file = new File(name);
            FileOutputStream fos = new FileOutputStream(file);
            try (DataOutputStream dos = new DataOutputStream(fos)) {
                dos.write(buffer);
                dos.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }
    }

    /*
     * Convert text to speech.
     */
    public void t2s(String text) {
        final byte[] speech = synthesizeSpeech(EchoMain.TOKEN, text, LANG, GENDER, FORMAT);
        writeData(speech, OUTPUT);
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(OUTPUT));
            try (Clip test = AudioSystem.getClip()) {
                test.open(ais);
                test.start();

                while (!test.isRunning()) {
                    Thread.sleep(10);
                }
                while (test.isRunning()) {
                    Thread.sleep(10);
                }
            }
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException ex) {
            System.out.println("exception");
        }
    }
}
