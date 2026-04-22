/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.services.IniciarSesionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

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

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        campo_curp.setTextFormatter(new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            //solo alfanumericos
            //sin espacio
            //longitud maxima de 18
            if (texto.matches("[a-zA-Z0-9]*") && texto.length() <= 18) {
                //convertimos a mayusculas de una vez
                change.setText(change.getText().toUpperCase());
                return change;
            }
            return null;
        }));

        campo_contrasena.setTextFormatter(new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            //longitud maxima de 50
            if (texto.length() <= 50) {
                return change;
            }
            return null;
        }));
    }

    @FXML
    private void iniciarSesion() {
        try {
            //si sale bien
//            IniciarSesionService.
            //redireccionamos al home

        } catch (Exception e) {
            //si sale mal
            //manejamos error error.exception;
            //error_curp.setText(error.curp);
            //error_contrasena.setText(error.contrasena);

        }
    }

}
