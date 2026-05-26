/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.App;
import bylizzy.mexicoint.data.api.ClienteApi;
import bylizzy.mexicoint.interfaces.SolicitarProductoListener;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.models.Documento;
import bylizzy.mexicoint.services.SolicitarProductoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class SolicitarProductoController implements Initializable {

    @FXML
    private Button btn_aceptar;

    @FXML
    private Button btn_cerrar;

    @FXML
    private VBox contenedor_documentos;

    @FXML
    private HBox contenedor_botones;

    @FXML
    private VBox contenedor_mensaje_1;

    @FXML
    private VBox contenedor_mensaje_2;

    @FXML
    private ImageView icon_cerrar;

    @FXML
    private Text texto_nombre_producto_1;

    @FXML
    private Text texto_nombre_producto_2;

    @FXML
    private Rectangle overlay;

    //borrar
    
    /*variables de control*/
    SolicitarProductoService control = new SolicitarProductoService();
    ContenidoHijo controlHijo = new ContenidoHijo();
    
    private SolicitarProductoListener solicitud;
    
    public void setSolicitud(SolicitarProductoListener solicitud){
        System.out.println("setSolicitud");
        this.solicitud=solicitud;
    }
    
    private StackPane contenedorPrincipal;
    private String idProducto;

    PauseTransition pausa = new PauseTransition(Duration.seconds(3));

    public SolicitarProductoController() {
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {

        Platform.runLater(() -> {
            controlHijo.overlay(overlay);
        });

        for (Documento doc : control.getDocumentos().getDocumentos()) {
            listarDocumentos(doc);
        }
        
        control.cambiarVisibilidad(contenedor_mensaje_2 ,false);
    }
    
    //BOTONES Y EVENTOS
    @FXML
    void Aceptar(ActionEvent event) {
        control.cambiarVisibilidad(contenedor_mensaje_1 ,false);
        control.cambiarVisibilidad(contenedor_mensaje_2 ,true);
        control.cambiarVisibilidad(contenedor_botones ,false);
        control.cambiarVisibilidad(icon_cerrar ,false);

        pausa.setOnFinished(e -> {
            cerrarSolicitud();
        });

        pausa.play();
    }

    @FXML
    private void cerrarSolicitud1(ActionEvent event) {
        cerrarSolicitud();
    }

    @FXML
    private void cerrarSolicitud2(MouseEvent event) {
        cerrarSolicitud();
    }

    @FXML
    private void cerrarSolicitud(MouseEvent event) {
        cerrarSolicitud();
    }
    
    //FUNCIONES
    private void listarDocumentos(Documento doc) {
        Label lb = new Label();
        lb.setText("• " + doc.getNombre() + ".");
        contenedor_documentos.getChildren().add(lb);
    }
    
    private void cerrarSolicitud() {
        this.solicitud.cancelarSolicitud();
        System.out.println("Solicitud cancelada, vista solicitarProducto.fxml cerrada");

    }
    
    
    
    
    
    
    

    

    

    

    // comunicaciones
//    public StackPane getContenedorPrincipal() {
//        return contenedorPrincipal;
//    }

//    public void setContenedorPrincipal(StackPane contenedorPrincipal) {
//        this.contenedorPrincipal = contenedorPrincipal;
//    }

    public void cofigDatosProducto(String id, String nombre){
        control.setIdProducto(id);
        control.setNombreProducto(nombre);
        
        texto_nombre_producto_1.setText(nombre);
        texto_nombre_producto_2.setText(nombre);
        
    }

}
