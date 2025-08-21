package org.devbigode.remindersystem.service;

import org.devbigode.remindersystem.model.Position;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;
    private String filePath;

    public ConfigManager(String filePath){
        this.properties = new Properties();
        this.filePath = filePath;
    }

    public void loadConfig(){
        try (FileInputStream fileInputStream = new FileInputStream(filePath)){
            properties.load(fileInputStream);
        } catch (IOException e){
            throw new RuntimeException("Erro ao ler ou abrir o arquivo: " + filePath, e);
        }
    }

    public String getProperty(String key, String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public int getInt(String key, String defaultValue){
        try {
            return Integer.parseInt(properties.getProperty(key, defaultValue));
        } catch (NumberFormatException e){
            return Integer.parseInt(defaultValue);
        }
    }

    public String getPosition(String key, String defaultValue){
        String value = properties.getProperty(key, defaultValue);

        try {
            return Position.valueOf(value).name();
        } catch (IllegalArgumentException e){
            return Position.valueOf(defaultValue).name();
        }
    }
}
