/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.App;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.models.Producto;
import bylizzy.mexicoint.services.EncabezadoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class EncabezadoController implements Initializable {

    @FXML
    private Button btn_cerrar_sesion;

    @FXML
    private Button btn_menu_lateral;

    @FXML
    private VBox contenedor_productos_credito;

    @FXML
    private VBox contenedor_productos_debito;

    @FXML
    private VBox contenedor_productos_obtenidos;

    @FXML
    private VBox contenedor_productos_solicitables;

    @FXML
    private VBox menu_lateral;

    @FXML
    private Rectangle overlay;

    @FXML
    private StackPane contenedor_solicitud;

    /* VARIABLES DE CONTROL */
    EncabezadoService control = new EncabezadoService();
    ContenidoHijo escenario;

    /* BOTONES Y ACCIONES */
    @FXML
    private void abrirMenu(ActionEvent event) {
        cambiarExistencia(menu_lateral ,true);
        cambiarExistencia(overlay ,true);
    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        //limpiamos credenciales de log y tokens
    }

    @FXML
    private void cerrarMenuLateral(MouseEvent event) {
        cambiarExistencia(menu_lateral ,false);
        cambiarExistencia(overlay ,false);

    }

    @FXML
    private void solicitarProducto(String id ,String nombre) {
        cambiarExistencia(contenedor_solicitud ,true);
        App.FXMLIniciarSolicitud(contenedor_solicitud ,id ,nombre);
    }

    /* INICIALIZACION */
    @Override
    public void initialize(URL url ,ResourceBundle rb) {

        //tamaño del overlay
        Platform.runLater(() -> {
            escenario.overlay(overlay);
        });

        //cargar productos del cliente
        for (Producto p : control.getProductosPoseidos().getLista()) {
            definirBoton(p ,contenedor_productos_obtenidos);
        }

        //cargar productos que puede solicitar el cliente
        //productos debito
        //falta controlar que se pueda ocultar si no hay productos solicitables
        if (!control.getProductosSolicitables().getCredito().isEmpty()) {
            for (Producto p : control.getProductosSolicitables().getCredito()) {
                definirBoton(p ,contenedor_productos_credito);
            }
        } else {
            contenedor_productos_credito.setManaged(false);
        }
        //productos creditos
        //falta controlar que se pueda ocultar si no hay productos solicitables
        if (!control.getProductosSolicitables().getDebito().isEmpty()) {
            for (Producto p : control.getProductosSolicitables().getDebito()) {
                definirBoton(p ,contenedor_productos_debito);
            }
        } else {
            contenedor_productos_debito.setManaged(false);
        }
        //control de visibilidad
        cambiarExistencia(menu_lateral ,false);
        cambiarExistencia(overlay ,false);
        cambiarExistencia(contenedor_solicitud ,false);
        cambiarExistencia(menu_lateral ,false);
    }

    //funcion que crea un boton
    private void definirBoton(Producto p ,VBox contenedor) {
        Button btn = new Button();
        btn.setUserData(p.getId());
        btn.setText(p.getNombre());
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.getStyleClass().add("menu-producto");
        btn.setOnAction(event -> {
            String id = (String)btn.getUserData();
            solicitarProducto(id ,btn.getText());
            System.out.println("Producto: " + id);
        });
        contenedor.getChildren().add(btn);
    }

    private void cambiarExistencia(Node nodo ,boolean estado) {
        nodo.setVisible(estado);
        nodo.setManaged(estado);
    }

}
