module bylizzy.mexicoint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens bylizzy.mexicoint to javafx.fxml;
    opens bylizzy.mexicoint.controllers to javafx.fxml;
    exports bylizzy.mexicoint;
}
