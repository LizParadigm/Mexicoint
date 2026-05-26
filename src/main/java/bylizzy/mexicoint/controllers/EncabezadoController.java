/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.MenuLateralListener;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.services.EncabezadoService;
import bylizzy.mexicoint.utils.ControlSesion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

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

    /* VARIABLES DE CONTROL */
    EncabezadoService control = new EncabezadoService();
    ContenidoHijo controlHijo = new ContenidoHijo();
    private MenuLateralListener menuLateral;

    public void setMenuLateral(MenuLateralListener menuLateral) {
        this.menuLateral = menuLateral;
    }

    /* INICIALIZACION */
    @Override
    public void initialize(URL url ,ResourceBundle rb) {
    }

    /* BOTONES Y ACCIONES */
    @FXML
    private void abrirMenu(ActionEvent event) {
        abrirMenuLateral();
        System.out.println("click desde encabezado");
    }

    private void abrirMenuLateral() {
        this.menuLateral.abrirMenu();

    }

    @FXML
    private void cerrarSesion(ActionEvent event) {
        System.out.println("SESION CERRADA");
        ControlSesion.cerrarSesion();
    }

}
