module bylizzy.mexicoint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    exports bylizzy.mexicoint;

    opens bylizzy.mexicoint to javafx.fxml;
    opens bylizzy.mexicoint.controllers to javafx.fxml;
    opens bylizzy.mexicoint.models to com.fasterxml.jackson.databind;
}
