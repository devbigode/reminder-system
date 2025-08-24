package org.devbigode.remindersystem;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.devbigode.remindersystem.model.DefaultValue;
import org.devbigode.remindersystem.service.ConfigManager;
import org.devbigode.remindersystem.service.ConfigValidator;
import org.devbigode.remindersystem.view.NotificationView;

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

        ConfigManager configManager = new ConfigManager("config.properties");
        configManager.loadConfig();

        String title = configManager.getProperty("title", DefaultValue.TITLE.getValue());
        String message = configManager.getProperty("message", DefaultValue.MESSAGE.getValue());
        String position = configManager.getPosition("position", DefaultValue.POSITION.getValue());
        int duration = configManager.getInt("duration", DefaultValue.DURATION.getValue());
        String image = configManager.getProperty("image", DefaultValue.IMAGE.getValue());
        int interval = configManager.getInt("interval", DefaultValue.INTERVAL.getValue());

        ConfigValidator configValidator = new ConfigValidator(title, message, position, duration, interval, image);
        configValidator.validateAllValues();

        NotificationView notificationView = new NotificationView(configValidator);
        Runnable showNotificationTask = () -> {
            Platform.runLater(notificationView::showNotification);
        };

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduledFuture = executorService.scheduleAtFixedRate(showNotificationTask, 1, configValidator.getInterval(), TimeUnit.MINUTES);

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
