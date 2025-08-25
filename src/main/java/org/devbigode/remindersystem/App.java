package org.devbigode.remindersystem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.devbigode.remindersystem.model.DefaultValue;
import org.devbigode.remindersystem.service.AudioManager;
import org.devbigode.remindersystem.service.ConfigValidator;
import org.devbigode.remindersystem.view.NotificationView;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class App extends Application {
    private void setupStage(Stage stage){
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setOpacity(0);
        stage.show();
    }

    @Override
    public void start(Stage stage) {
        setupStage(stage);

        ConfigValidator configValidator = ConfigValidator.getConfigValidator();

        AudioManager audioManager = new AudioManager(new File(DefaultValue.AUDIO.getValue()));

        NotificationView notificationView = new NotificationView(configValidator);

        Runnable showNotificationTask = () -> {
            Platform.runLater(notificationView::showNotification);
            audioManager.startSound(audioManager.validateAudio());
        };

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(showNotificationTask, 0, configValidator.getInterval(), TimeUnit.MINUTES);

        Runnable stopNotifications = () -> {
            scheduledFuture.cancel(false);
            executorService.shutdown();
            Platform.exit();
            System.exit(0);
        };

        executorService.schedule(stopNotifications, 24, TimeUnit.HOURS);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
