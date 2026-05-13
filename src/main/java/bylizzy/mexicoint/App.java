package bylizzy.mexicoint;

import bylizzy.mexicoint.utils.ManejarEscenario;
import bylizzy.mexicoint.utils.RutasService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.layout.StackPane;

/**
 * JavaFX App
 */
public class App extends Application {

    public App app;

    private static Scene escena;
    private static ManejarEscenario escenario;

    @Override
    public void start(Stage stage) throws IOException {
        this.escenario= new ManejarEscenario(stage);
        

        System.out.println(RutasService.MODULO_AUTENTIFICACION);
        this.escena = new Scene(
                escenario.cargarFXML(RutasService.MODULO_AUTENTIFICACION),
                escenario.getWidth(),
                escenario.getHeight()
        );
        
        this.escenario.setEscena(escena);
        
        stage.setScene(escena);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws IOException {
    }



    public static ManejarEscenario getEscenario(){
        return App.escenario;
    }

    public static void FXMLIniciarSolicitud(StackPane nodo ,String id ,String nombre) {
    //        nodo_hijo.setContenedorPrincipal(nodo);
  //          nodo_hijo.setProductoId(id);
//            nodo_hijo.setProductoNombre(nombre);
    }

    public static void borrarFXML(StackPane nodo) {
        nodo.getChildren().clear();

//        nodo.getChildren().add(solicitud);
    }

    public static void main(String[] args) {
        launch();
    }

}
