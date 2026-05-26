/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.interfaces.ProductoListener;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.models.Producto;
import bylizzy.mexicoint.services.MenuClienteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class MenuClienteController implements Initializable {

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

    //VARIABLES DE CONTROL
    MenuClienteService control;
    ContenidoHijo controlHijo = new ContenidoHijo();

    private ProductoListener producto;

    public MenuClienteController() throws InterruptedException {
        this.control = new MenuClienteService();
    }

    public void setProducto(ProductoListener producto) {
        this.producto = producto;
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        Platform.runLater(() -> {
            controlHijo.overlay(overlay);
        });

        //cargar productos del cliente
        cargarProductos(contenedor_productos_obtenidos);

        //cargar productos que puede solicitar el cliente
        cargarProductosSolicitables(this.contenedor_productos_credito ,this.contenedor_productos_debito);
    }

    @FXML
    private void cerrarMenuLateral(MouseEvent event) {
        cerrarMenuLateral();
    }

    //cargar productos del cliente
    public void cargarProductos(VBox contenedor) {
        for (Producto p : control.getProductosPoseidos().getLista()) {
            definirBotonObtenidos(p ,contenedor);
        }
    }

    //cargar productos que puede solicitar el cliente
    public void cargarProductosSolicitables(VBox contenedor_credito ,VBox contenedor_debito) {
        //productos debito
        //falta controlar que se pueda ocultar si no hay productos solicitables
        if (!control.getProductosSolicitables().getCredito().isEmpty()) {
            for (Producto p : control.getProductosSolicitables().getCredito()) {
                definirBotonObtenibles(p ,contenedor_credito);
            }
        } else {
            contenedor_credito.setManaged(false);
        }

        //productos creditos
        //falta controlar que se pueda ocultar si no hay productos solicitables
        if (!control.getProductosSolicitables().getDebito().isEmpty()) {
            for (Producto p : control.getProductosSolicitables().getDebito()) {
                definirBotonObtenibles(p ,contenedor_debito);
            }
        } else {
            contenedor_debito.setManaged(false);
        }
    }

    private void definirBotonObtenidos(Producto p ,VBox contenedor) {
        Button btn = new Button();
        btn.setUserData(p.getId());
        btn.setText(p.getNombre());
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.getStyleClass().add("menu-producto");
        btn.setOnAction(event -> {
            int id = (int)btn.getUserData();
            cambiarProductoPrincipal(id);
            System.out.println("Producto: " + id);
        });
        contenedor.getChildren().add(btn);
    }

    private void definirBotonObtenibles(Producto p ,VBox contenedor) {
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

    @FXML
    private void solicitarProducto(String id ,String nombre) {
        producto.seleccionarProducto(id ,nombre);
    }

    @FXML
    private void cambiarProductoPrincipal(int id) {
        producto.nuevoProductoPrincipal(id);
    }

    private void cerrarMenuLateral() {
        this.producto.cerrarMenuLateral();
        System.out.println("cerrando menu lateral");
    }

}
