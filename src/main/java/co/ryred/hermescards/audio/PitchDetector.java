package co.ryred.hermescards.audio;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.jvm.JVMAudioInputStream;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import co.ryred.hermescards.Main;

import javax.sound.sampled.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by rissa on 01/08/2017.
 */
public class PitchDetector implements PitchDetectionHandler {

    private final PitchProcessor.PitchEstimationAlgorithm algo = PitchProcessor.PitchEstimationAlgorithm.YIN;
    private AudioDispatcher dispatcher;
    private Mixer currentMixer;
    private long sleep = 0;

    public PitchDetector() throws LineUnavailableException, UnsupportedAudioFileException {
        setNewMixer(AudioSystem.getMixer(Shared.getMixerInfo(false, true).firstElement()));
    }

    public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException {
        new PitchDetector();
    }

    @Override
    public void handlePitch(PitchDetectionResult pitchDetectionResult, AudioEvent audioEvent) {

        if (sleep > 1 && sleep >= System.nanoTime()) return;

        if (pitchDetectionResult.getPitch() != -1 && pitchDetectionResult.getProbability() > 0.97 && isPitch(pitchDetectionResult.getPitch())) {
            double timeStamp = audioEvent.getTimeStamp();
            float pitch = pitchDetectionResult.getPitch();
            float probability = pitchDetectionResult.getProbability();
            double rms = audioEvent.getRMS() * 100;
            String message = String.format("Pitch detected at %.2fs: %.2fHz ( %.2f probability, RMS: %.5f )", timeStamp, pitch, probability, rms);
            if (Main.imageDisplay != null && Main.imageDisplay.getNextButton() != null)
                Main.imageDisplay.getNextButton().doClick();
            System.out.println(message);
            sleep = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(200);
        }

    }

    private boolean isPitch(float pitch) {
        return pitch > 2580.0 && pitch < 2625.0;
    }

    private void setNewMixer(Mixer mixer) throws LineUnavailableException, UnsupportedAudioFileException {

        if (dispatcher != null) {
            dispatcher.stop();
        }

        currentMixer = mixer;

        float sampleRate = 44100;
        int bufferSize = 1536;
        int overlap = 0;

        final AudioFormat format = new AudioFormat(sampleRate, 16, 1, true, true);
        final DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, format);
        TargetDataLine line = (TargetDataLine) mixer.getLine(dataLineInfo);
        final int numberOfSamples = bufferSize;
        line.open(format, numberOfSamples);
        line.start();
        final AudioInputStream stream = new AudioInputStream(line);

        JVMAudioInputStream audioStream = new JVMAudioInputStream(stream);
        // create a new dispatcher
        dispatcher = new AudioDispatcher(audioStream, bufferSize, overlap);

        // add a processor
        dispatcher.addAudioProcessor(new PitchProcessor(algo, sampleRate, bufferSize, this));

        new Thread(dispatcher, "Audio dispatching").start();
    }

}
