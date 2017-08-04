package co.ryred.hermescards;

import co.ryred.hermescards.audio.PitchDetector;
import co.ryred.hermescards.frames.ConfigurationFrame;
import co.ryred.hermescards.frames.ImageDisplayFrame;
import co.ryred.hermescards.util.Callback;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by rissa on 19/12/2016.
 */
public class Main {

    public static ConfigurationFrame configurationFrame = null;

    public static ImageDisplayFrame imageDisplay = null;

    public static void main(String... args) throws LineUnavailableException, UnsupportedAudioFileException {

        new PitchDetector();
        configurationFrame = new ConfigurationFrame(null);
        imageDisplay = new ImageDisplayFrame(counter -> {

            if (configurationFrame != null) {
                configurationFrame.setVisible(true);
            }

        });

        Callback<CardCounter> cb = counter -> {
            imageDisplay.setCounter(counter);
            imageDisplay.pack();
            imageDisplay.setVisible(true);
        };

        configurationFrame.setCounterCallback(cb);
        configurationFrame.pack();
        configurationFrame.setVisible(true);

    }

}
