package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.App;
import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.services.ModuloAutentificacionService;
import bylizzy.mexicoint.utils.RutasService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class ModuloAutentificacionController implements Initializable {

    @FXML
    private HBox fondo;

    @FXML
    private Pane fondo_1;

    @FXML
    private Pane fondo_2;

    @FXML
    private StackPane contenedor_controladores;

    @FXML
    private StackPane contenedor_logo;

    // VARIABLES DE CONTROL
    ModuloAutentificacionService control = new ModuloAutentificacionService();
    ContenidoHijo controlHijo = new ContenidoHijo();
    RutasService rut = new RutasService();

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        control.cambiarVisibilidad(contenedor_controladores ,true);

        try {

            contenedorHijo(contenedor_controladores ,"");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void contenedorHijo(StackPane contenedorPadre ,String fxml) throws IOException {
        try {
            //contendio default
            if (fxml == null || fxml.isEmpty()) {
                fxml = rut.INICIAR_SESION;
            }

            //contenido
            FXMLLoader vistaCargada = controlHijo.cargarHijo(contenedorPadre ,fxml);

            //se añade la interfaz del listener
            ConfigListenerInterface controlador = vistaCargada.getController();

            if (fxml.equals(rut.RECUPERAR_CUENTA)) {
                control.cambiarClaseCSS(fondo_2);
                control.cambiarVisibilidad(contenedor_logo ,false);
            } else if (fxml.equals(rut.MODULO_USUARIO)) {
                controlHijo.cambiarVista(fxml);
            } else {
                control.cambiarClaseCSS(fondo_1);
                control.cambiarVisibilidad(contenedor_logo ,true);
            }

            //listener:
            configurarListener(controlador);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void actualizarContenedorHijo(String fxmlNuevo) throws IOException {
        controlHijo.borrarHijo(contenedor_controladores);

        contenedorHijo(contenedor_controladores ,fxmlNuevo);
    }

    private void configurarListener(ConfigListenerInterface ref) {
        ref.cambiarControlador().addListener((observable ,viejo ,fxmlNuevo) -> {
            try {
                //se intenta actualizar 
                actualizarContenedorHijo(fxmlNuevo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
