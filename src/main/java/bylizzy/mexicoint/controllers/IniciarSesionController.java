/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.App;
import bylizzy.mexicoint.services.IniciarSesionService;
import bylizzy.mexicoint.utils.ControlVista;
import bylizzy.mexicoint.utils.ValidacionesService;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class IniciarSesionController implements Initializable {

    @FXML
    private TextField campo_curp;

    @FXML
    private PasswordField campo_contrasena;

    @FXML
    private Label error_curp;

    @FXML
    private Label error_contrasena;

    @FXML
    private Button btn_iniciarSesion;

    @FXML
    private Button btn_registrarme;

    @FXML
    private Text text_aqui;

    /* variables de control */
    ValidacionesService validar = new ValidacionesService();

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        campo_curp.setTextFormatter(new TextFormatter<>(change -> {
            String texto = change.getControlNewText();
            if (validar.alfanumerico(texto) && texto.length() <= 18) {
                //convertIR a mayusculas de una vez
                change.setText(change.getText().toUpperCase());
                return change;
            }
            return null;
        }));

        campo_contrasena.setTextFormatter(new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            if (texto.length() <= 50) {
                return change;
            }
            return null;
        }));
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        Validacion curp = validar.curp(campo_curp.getText());
        Validacion contra = validar.contrasena(campo_contrasena.getText());
        //validaciones front
        if (curp.estado() && contra.estado()) { //si sale bien
            error_curp.setText(curp.mensaje());
            error_contrasena.setText(contra.mensaje());
            //IniciarSesionService.
            //redireccionamos al home

        } else {
            //si sale mal
            error_curp.setText(curp.mensaje());
            error_contrasena.setText(contra.mensaje());
        }
    }

    @FXML
    void recuperarCuenta(MouseEvent event) {
        try {
            //App.abrirModal(ControlVista.RECUPERAR_CUENTA);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void registrar(ActionEvent event) {
        try {
            App.cambiarVista(ControlVista.REGISTRAR_CLIENTE);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
