package bylizzy.mexicoint;

import bylizzy.mexicoint.controllers.SolicitarProductoController;
import bylizzy.mexicoint.utils.ControlVista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {

    public App app;

    private static Scene scene;
    private static Stage primaryStage; //referencia a la ventana principal
    private static int pSDimensionX = 1212;
    private static int pSDimensionY = 700;
    private static Stage modalStage; //referencia al modal

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        scene = new Scene(cambiarFXML(ControlVista.ENCABEZADO) ,pSDimensionX ,pSDimensionY);
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws IOException {
        scene.setRoot(cambiarFXML(fxml));
    }

    private static Parent cambiarFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/bylizzy/mexicoint/views/" + fxml));

        return fxmlLoader.load();
    }

    public static void abrirModal(String fxml) throws IOException {
        Parent root = cambiarFXML(fxml);

        modalStage = new Stage();
        modalStage.setScene(new Scene(root ,pSDimensionX ,pSDimensionY));

        modalStage.initOwner(primaryStage);
        modalStage.initModality(Modality.APPLICATION_MODAL);

        modalStage.showAndWait();
    }

    public static void cerrarModal() {
        if (modalStage != null) {
            modalStage.close();
        }
    }

    public static void FXMLIniciarSolicitud(StackPane nodo ,String id ,String nombre) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/bylizzy/mexicoint/views/" + ControlVista.SOLICITAR_PRODUCTO));
            Parent solicitud = loader.load();

            solicitud.toFront();
            nodo.getChildren().add(solicitud);

            SolicitarProductoController nodo_hijo = loader.getController();

            nodo_hijo.setContenedorPrincipal(nodo);
            nodo_hijo.setProductoId(id);
            nodo_hijo.setProductoNombre(nombre);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void borrarFXML(StackPane nodo) {
        nodo.getChildren().clear();

//        nodo.getChildren().add(solicitud);
    }

    public static void main(String[] args) {
        launch();
    }

}
