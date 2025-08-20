package org.devbigode.remindersystem;

import org.devbigode.remindersystem.model.DefaultValue;
import org.devbigode.remindersystem.service.ConfigManager;

public class App {
    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager("config.properties");

        configManager.loadConfig();

        String title = configManager.getProperty("title", DefaultValue.TITLE.getValue());
        String message = configManager.getProperty("message", DefaultValue.MESSAGE.getValue());
        String position = configManager.getPosition("position", DefaultValue.POSITION.getValue());
        int duration = configManager.getInt("duration", DefaultValue.DURATION.getValue());
        int interval = configManager.getInt("interval", DefaultValue.INTERVAL.getValue());
        String image = configManager.getIcon("image", DefaultValue.IMAGE.getValue());
        String type = configManager.getType("type", DefaultValue.TYPE.getValue());

        System.out.println("Título: " + title);
        System.out.println("Corpo da mensagem: " + message);
        System.out.println("Posição da notificação: " + position);
        System.out.println("Duração em segundos: " + duration);
        System.out.println("Intervalo em minutos: " + interval);
        System.out.println("Caminho da imagem: " + image);
        System.out.println("Tipo da notificação: " + type);
    }
}
