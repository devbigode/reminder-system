package org.devbigode.remindersystem.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioManager {
    private File audioPath;

    public AudioManager(File audioPath) {
        this.audioPath = audioPath;
    }

    public File getAudioPath() {
        return audioPath;
    }

    public void setAudioPath(File audioPath) {
        this.audioPath = audioPath;
    }

    public AudioInputStream validateAudio(){
        try {
            return AudioSystem.getAudioInputStream(audioPath);
        } catch (UnsupportedAudioFileException | IOException e){
            throw new RuntimeException("Erro ao localizar arquivo de áudio.", e);
        }
    }

    public void startSound(AudioInputStream audio){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (LineUnavailableException | IOException e){
            throw new RuntimeException("Erro ao reproduzir som da notificação.", e);
        }
    }
}
