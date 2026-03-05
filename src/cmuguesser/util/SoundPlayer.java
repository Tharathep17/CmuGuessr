package cmuguesser.util;

import javax.sound.sampled.*;
import java.net.URL;

public class SoundPlayer {
    
    private Clip bgmClip;

    public void playBGM(String fileName) {
        if (bgmClip != null) {
            bgmClip.stop();
            bgmClip.close();
        }
        
        URL soundFile = SoundPlayer.class.getResource("/cmuguesser/Sounds/" + fileName);
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile)) {
            bgmClip = AudioSystem.getClip();
            bgmClip.open(audioStream);
            bgmClip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopBGM() {
        if (bgmClip != null) {
            bgmClip.stop();
            bgmClip.close();
        }
    }

    public  void play(String fileName) {

        URL soundFile = SoundPlayer.class.getResource("/cmuguesser/Sounds/" + fileName);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}