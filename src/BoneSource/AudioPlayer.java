package BoneSource;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class AudioPlayer {

    Clip clip;

    AudioInputStream audio;


    public boolean loop;
    boolean playing;

    public boolean isPlaying() {
        return clip.isRunning();
    }

    public AudioPlayer(Asset asset) {
        try {
            audio = AudioSystem.getAudioInputStream(new File(asset.assetPath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            if(clip == null) {
                Debug.print("clip is null");
            }

            clip.open(audio);

            FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume  = -80f;
            gain.setValue(volume);

            if(loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }

    public AudioPlayer(Asset asset, float volume) {
        try {
            audio = AudioSystem.getAudioInputStream(new File(asset.assetPath).getAbsoluteFile());

            clip = AudioSystem.getClip();



            clip.open(audio);

            FloatControl gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            gain.setValue(volume);

            if(loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }

    public void play() {
        Debug.print("playing");
        clip.start();
        playing = true;
    }

    public void stop() {
        playing = false;
        clip.stop();
        clip.close();
    }

    public void updateAudio(Asset asset) {
        try {
            audio = AudioSystem.getAudioInputStream(new File(asset.assetPath).getAbsoluteFile());

            clip = AudioSystem.getClip();

            clip.open(audio);

            if(loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }


        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            Debug.log(LogType.ERROR, e.getMessage() + " : " + e.getCause());
        }
    }

}
