package EchoMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.util.UUID;
/**
 * Speech to text conversion using Microsoft Cognitive Services.
 *
 * See http://www.microsoft.com/cognitive-services/en-us/speech-api
 *
 * David Wakeling, 2017.
 */

public class SpeechToText {

    final static String LANG = "en-US";
    final static String INPUT = "EchoMain/wavs/input.wav";

    final static String KEY1 = "6cfd3579bfee48fc97efde7e9e03d742";
    final static String KEY2 = "97d63d8902d94928bec23608c3a4f1c2";

    /**
     * Recognize speech.
     */
    static String recognizeSpeech(String token, byte[] body) {
        final String method = "POST";
        final String url
                = ("https://speech.platform.bing.com/recognize"
                + "?" + "version" + "=" + "3.0"
                + "&" + "format" + "=" + "json"
                + "&" + "device.os" + "=" + "wp7"
                + "&" + "scenarios" + "=" + "smd"
                + "&" + "locale" + "=" + LANG
                + "&" + "appid" + "=" + "D4D52672-91D7-4C74-8AD8-42B1D98141A5"
                + "&" + "instanceid" + "=" + UUID.randomUUID().toString()
                + "&" + "requestid" + "=" + UUID.randomUUID().toString());
        final String[][] headers
                = {{"Content-Type", "audio/wav; samplerate=16000"}, {"Content-Length", String.valueOf(body.length)}, {"Authorization", "Bearer " + token}
                };
        byte[] response = HttpConnect.httpConnect(method, url, headers, body);
        return new String(response);
    }

    /**
     * Read data from file.
     */
    static byte[] readData(String name) {
        try {
            File file = new File(name);
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            byte[] buffer = new byte[(int) file.length()];
            dis.readFully(buffer);
            dis.close();
            return buffer;
        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(1);
            return null;
        }
    }

    /**
     * Convert speech to text.
     *
     * @return text returned from speech to text
     */
    public String s2t() {
        final byte[] speech = readData(INPUT);
        final String text = recognizeSpeech(EchoMain.TOKEN, speech);
        return text;
    }
}
