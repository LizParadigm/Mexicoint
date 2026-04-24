package bylizzy.mexicoint;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.Modality;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage; //referencia a la ventana principal
    private static Stage modalStage; //referencia al modal

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        scene = new Scene(cambiarFXML("iniciarSesion") ,1212 ,700);
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws IOException {
        scene.setRoot(cambiarFXML(fxml));
    }

    private static Parent cambiarFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/bylizzy/mexicoint/views/" + fxml + ".fxml"));

        return fxmlLoader.load();
    }

    public static void abrirModal(String fxml) throws IOException {
        Parent root = cambiarFXML(fxml);

        modalStage = new Stage();
        modalStage.setScene(new Scene(root));

        modalStage.initOwner(primaryStage);
        modalStage.initModality(Modality.APPLICATION_MODAL);

        modalStage.showAndWait();
    }

    public static void cerrarModal() {
        if (modalStage != null) {
            modalStage.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
