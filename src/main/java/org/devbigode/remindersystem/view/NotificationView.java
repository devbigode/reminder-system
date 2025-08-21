package org.devbigode.remindersystem.view;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.devbigode.remindersystem.service.ConfigValidator;

public class NotificationView {
    private final ConfigValidator configValidator;

    public NotificationView(ConfigValidator configValidator) {
        this.configValidator = configValidator;
    }

    public void showNotification(){
        ImageView imagePath = new ImageView(new Image("file:" + configValidator.getImage()));

        Notifications.create()
                .title(configValidator.getTitle())
                .text(configValidator.getMessage())
                .position(Pos.valueOf(configValidator.getPosition()))
                .hideAfter(Duration.seconds(configValidator.getDuration()))
                .graphic(imagePath)
                .show();
    }

}
