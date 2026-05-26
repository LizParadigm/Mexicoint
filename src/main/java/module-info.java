module bylizzy.mexicoint {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;
    

    exports bylizzy.mexicoint;

    opens bylizzy.mexicoint to javafx.fxml;
    opens bylizzy.mexicoint.controllers to javafx.fxml;
    opens bylizzy.mexicoint.data.dto.cliente to com.fasterxml.jackson.databind;
    opens bylizzy.mexicoint.models to com.fasterxml.jackson.databind, javafx.base;
    opens bylizzy.mexicoint.data.dto.cliente.deserializers to com.fasterxml.jackson.databind;
}
