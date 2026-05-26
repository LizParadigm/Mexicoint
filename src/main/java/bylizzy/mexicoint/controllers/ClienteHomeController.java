/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.ContenidoListener;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.services.ClienteHomeService;
import bylizzy.mexicoint.utils.RutasService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class ClienteHomeController implements Initializable, ContenidoListener {

    @FXML
    private StackPane contenedor_producto_seleccionado;

    //VARIABLES DE CONTROL
    ClienteHomeService control = new ClienteHomeService();
    ContenidoHijo controlHijo=new ContenidoHijo();
    RutasService rut;

    private ContenidoListener contenido;

    public void setProductoId(int id) throws IOException{
        this.cargarProducto(id);
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        try {
            this.cargarProducto(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void cargarProducto(int id) throws IOException{
        FXMLLoader vistaCargada=controlHijo.cargarHijo(this.contenedor_producto_seleccionado,rut.HOME_PRODUCTO);
        ClienteProductoController controlador=vistaCargada.getController();
        controlador.setProductoId(id);
    }

    @Override
    public void pasarInt(int dato) {
        try {
            this.cargarProducto(dato);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarFXML(String fxml) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
