package Gui;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusicManager {
    private static BackgroundMusicManager instance;
    private Clip clip;

    private BackgroundMusicManager() {}

    public static BackgroundMusicManager getInstance() {
        if (instance == null) {
            instance = new BackgroundMusicManager();
        }
        return instance;
    }

    public void playBackgroundMusic(String musicPath) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            File musicFile = new File(musicPath);
            if (musicFile.exists()) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found: " + musicFile.getAbsolutePath());
            }
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void stopBackgroundMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
