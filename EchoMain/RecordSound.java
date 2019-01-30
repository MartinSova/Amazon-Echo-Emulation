package EchoMain;

import java.io.File;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

class RecordSound {

    private static final String FILENAME = "input.wav";
    private static final int TIMER = 60; /* secs */

    private static final int SAMPLE_RATE = 32000; /* MHz  */

    private static final int SAMPLE_SIZE = 16; /* bits */

    private static final int SAMPLE_CHANNELS = 1; /* mono */

    public boolean inter = false;

    static TargetDataLine line;

    public boolean getInter(){
        return inter;
    }
    public void setInter(boolean inter){
        this.inter = inter;
    }

    /*
     * Set up stream.
     */
    static AudioInputStream setupStream() {
        try {
            AudioFormat af
                    = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, SAMPLE_CHANNELS, true /* signed */, true /* little-endian */
                    );
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, af);
            line = (TargetDataLine) AudioSystem.getLine(info);
            AudioInputStream stm = new AudioInputStream(line);
            line.open(af);
            line.start();
            return stm;
        } catch (LineUnavailableException ex) {
            System.out.println(ex);
            System.exit(1);
            return null;
        }
    }

    /**
     * Read stream.
     */
    public ByteArrayOutputStream readStream(AudioInputStream stm) {
        try {
            int stopper = 0;
            int stopper2 = 0;
            boolean flag = false;

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            int bufferSize = SAMPLE_RATE * stm.getFormat().getFrameSize();
            byte buffer[] = new byte[bufferSize];

            for (int counter = TIMER; counter > 0; counter--) {
                //System.out.println("F: FIRST1");
                int n = stm.read(buffer, 0, buffer.length);
                //System.out.println("F: FIRST2");
                // calculate the Root Mean Squared value of buffer
                int rms = calculateRMSLevel(buffer);
                System.out.println("RMS: " + Integer.toString(rms));

                // set flag true once noise is detected from rms
                if (rms > 35) {
                    flag = true;
                }

                if (flag){
                    stopper2 += 1;
                    if (rms <= 35){
                        stopper += 1;
                    } else {
                        stopper = 0;
                    }
                }

                if (n > 0) {
                    bos.write(buffer, 0, n);
                } else {
                    break;
                }

                // break the loop after two seconds of silence,
                // an interruption or 5 seconds passed
                if (stopper > 1 || getInter() || stopper2 > 7) {
                    line.drain();
                    line.close();
                    return bos;
                }
                //System.out.println("F: SECOND");
            }
            line.drain();
            line.close();
            return bos;
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
            return null;
        }
    }

    /**
     * Record sound.
     */
    static void recordSound(String name, ByteArrayOutputStream bos) {
        try {
            //System.out.println("S: FIRST");
            AudioFormat af
                    = new AudioFormat(SAMPLE_RATE, SAMPLE_SIZE, SAMPLE_CHANNELS, true /* signed */, true /* little-endian */
                    );
            byte[] ba = bos.toByteArray();
            InputStream is = new ByteArrayInputStream(ba);
            AudioInputStream ais = new AudioInputStream(is, af, ba.length);
            File dir = new File("EchoMain/wavs");

            if (!dir.exists()) {
                dir.mkdir();
            }
            File file = new File(dir, name);
            AudioSystem.write(ais, AudioFileFormat.Type.WAVE, file);
            //System.out.println("S: SECOND");
        } catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }
    }

    /*
     * Calulates the root mean squared value from buffer
     *
     * @params buffer The stream thats read into the buffer
     */
    static public int calculateRMSLevel(byte[] buffer) {
        // calculate root mean squared value of audio data
        long lSum = 0;
        for (int i = 0; i < buffer.length; i++) {
            lSum = lSum + buffer[i];
        }

        double dAvg = lSum / buffer.length;

        double sumMeanSquare = 0d;
        for (int j = 0; j < buffer.length; j++) {
            sumMeanSquare = sumMeanSquare + Math.pow(buffer[j] - dAvg, 2d);
        }

        double averageMeanSquare = sumMeanSquare / buffer.length;
        return (int) (Math.pow(averageMeanSquare, 0.5d) + 0.5);
    }

    /*
     public static void record(){
     // set up stream
     AudioInputStream stm = setupStream();
     // record sound
     recordSound( FILENAME, readStream( stm ) );
     }
     /*
     * Record sound.
     */
    public void record() {
        AudioInputStream stm = setupStream();
        // record sound
        recordSound(FILENAME, readStream(stm));


    }

}
