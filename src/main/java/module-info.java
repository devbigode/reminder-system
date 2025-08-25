module org.devbigode.remindersystem {
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;
    requires java.desktop;


    opens org.devbigode.remindersystem to javafx.fxml;
    exports org.devbigode.remindersystem;
}