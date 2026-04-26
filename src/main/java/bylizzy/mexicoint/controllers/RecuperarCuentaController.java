/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.services.RecuperarCuentaService;
import bylizzy.mexicoint.utils.ValidacionesService;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class RecuperarCuentaController implements Initializable {

    @FXML
    private Button btn_paso_1;

    @FXML
    private Button btn_paso_2;

    @FXML
    private Button btn_paso_3;

    @FXML
    private TextField campo_codigo;

    @FXML
    private PasswordField campo_confirmar_contrasena;

    @FXML
    private PasswordField campo_contrasena;

    @FXML
    private TextField campo_curp;

    @FXML
    private GridPane datos_paso_1;

    @FXML
    private GridPane datos_paso_2;

    @FXML
    private GridPane datos_paso_3;

    @FXML
    private Label error_codigo;

    @FXML
    private Label error_confirmar_contrasena;

    @FXML
    private Label error_contrasena;

    @FXML
    private Label error_curp;

    @FXML
    private Text texto_instruccion;

    /* VARIABLESD DE CONTROL */
    RecuperarCuentaService control = new RecuperarCuentaService();
    ValidacionesService validar = new ValidacionesService();

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        // TODO
    }

    @FXML
    void paso_1(ActionEvent event) {
        //validamos datos 1
        //si todo va bien
        control.siguientePaso();
        //si sale mal
        //actualizamos mensajes de error
    }

    @FXML
    void paso_2(ActionEvent event) {
        //validamos datos 1
        //si todo va bien
        control.siguientePaso();
        //si sale mal
        //actualizamos mensajes de error
    }

    @FXML
    void paso_3(ActionEvent event) {
        //validamos datos 1
        //si todo va bien
        control.siguientePaso();
        //si sale mal
        //actualizamos mensajes de error
    }

    public static TextFormatter<String> crearFormato(Predicate<String> funcion ,boolean mayusculas) {
        return new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            if (Validacion.test(texto)) {
                if (mayusculas) {
                    change.setText(change.getText().toUpperCase());
                }
                return change;
            }
            return null;

        });
    }
}
