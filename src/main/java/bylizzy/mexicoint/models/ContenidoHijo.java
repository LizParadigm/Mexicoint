package bylizzy.mexicoint.models;

import bylizzy.mexicoint.utils.ManejarEscenario;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class ContenidoHijo extends ManejarEscenario {

    public FXMLLoader cargarFXMLHijo(String fxml) throws IOException {
        FXMLLoader cargador = new FXMLLoader(getClass().getResource(fxml));
        cargador.load();
        return cargador;
    }

    public FXMLLoader cargarHijo(StackPane nodoPadre ,String fxml) throws IOException {
        FXMLLoader nodoHijoCargado = cargarFXMLHijo(fxml);

        Parent nodoHijo = nodoHijoCargado.getRoot();

        nodoPadre.getChildren().add(nodoHijo);
        return nodoHijoCargado;
    }

    public void borrarHijo(StackPane nodoPadre) {
        nodoPadre.getChildren().clear();
    }

    public void overlay(Rectangle overlay) {
        Platform.runLater(() -> {
            Scene scene = overlay.getScene();

            overlay.widthProperty().bind(scene.widthProperty());
            overlay.heightProperty().bind(scene.heightProperty());
        });
    }

}
