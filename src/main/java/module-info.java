module org.devbigode.remindersystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.devbigode.remindersystem to javafx.fxml;
    exports org.devbigode.remindersystem;
}