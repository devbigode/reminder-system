package org.devbigode.remindersystem.service;

import org.devbigode.remindersystem.model.DefaultValue;

import java.io.File;

public class ConfigValidator {
    private String title;
    private String message;
    private String position;
    private int duration;
    private int interval;
    private String image;

    public ConfigValidator(String title, String message, String position, int duration, int interval, String image) {
        this.title = title;
        this.message = message;
        this.position = position;
        this.duration = duration;
        this.interval = interval;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getPosition() {
        return position;
    }

    public int getDuration() {
        return duration;
    }

    public int getInterval(){
        return interval;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setInterval(int interval){
        this.interval = interval;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void validateAllValues(){
        if (getTitle().isBlank()){
            setTitle(DefaultValue.TITLE.getValue());
        }

        if (getMessage().isBlank()){
            setMessage(DefaultValue.MESSAGE.getValue());
        }

        if (getDuration() < 0){
            setDuration(Integer.parseInt(DefaultValue.DURATION.getValue()));
        }

        if (getInterval() < 0){
            setInterval(Integer.parseInt(DefaultValue.INTERVAL.getValue()));
        }

        if (getInterval() < (getDuration() / 60)){
            throw new RuntimeException("Aviso: duração maior que o intervalo.");
        }

        if (getImage().isBlank() || !new File(getImage()).exists()){
            setImage(DefaultValue.IMAGE.getValue());
        }
    }
}
