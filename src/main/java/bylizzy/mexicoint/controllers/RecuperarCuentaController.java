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
import javafx.scene.Node;
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
        campo_curp.setTextFormatter(
                crearFormato(
                        validar::regexCurp ,
                        true
                )
        );

        campo_codigo.setTextFormatter(
                crearFormato(
                        validar::regexCodigo ,
                        false
                )
        );

        campo_contrasena.setTextFormatter(
                crearFormato(
                        validar::regexContrasena ,
                        false
                )
        );
        campo_confirmar_contrasena.setTextFormatter(
                crearFormato(
                        validar::regexContrasena ,
                        false
                )
        );
    }

    @FXML
    private void paso_1(ActionEvent event) {
        //validamos datos 1
        Validacion curp = validar.curp(campo_curp.getText());
        if (curp.estado()) {
            //si todo va bien
            controlarVisibilidad(control.getPaso());
        } else {
            error_curp.setText(curp.mensaje());
        }
    }

    @FXML
    private void paso_2(ActionEvent event) {
        //validamos datos 1
        Validacion codigo = validar.codigo(campo_codigo.getText());
        if (codigo.estado()) {
            //si todo va bien
            controlarVisibilidad(control.getPaso());
        } else {
            //si sale mal
            error_codigo.setText(codigo.mensaje());
        }
    }

    @FXML
    private void paso_3(ActionEvent event) {
        //validamos datos 1
        Validacion contrasena = validar.contrasena(campo_contrasena.getText());
        Validacion confirmar_contrasena = validar.confirmarContrasena(campo_contrasena.getText() ,campo_confirmar_contrasena.getText());
        if (contrasena.estado() && confirmar_contrasena.estado()) {
            //si todo va bien
            //ir al home
        } else {
            //si sale mal
            error_contrasena.setText(contrasena.mensaje());
            error_confirmar_contrasena.setText(confirmar_contrasena.mensaje());
        }
    }

    public static TextFormatter<String> crearFormato(Predicate<String> validacion ,boolean mayusculas) {
        return new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            if (validacion.test(texto)) {
                if (mayusculas) {
                    change.setText(change.getText().toUpperCase());
                }
                return change;
            }
            return null;

        });
    }

    private void controlarVisibilidad(int paso) {
        cambiarVisibilidad(datos_paso_1 ,false);
        cambiarVisibilidad(datos_paso_2 ,false);
        cambiarVisibilidad(datos_paso_3 ,false);
        cambiarVisibilidad(btn_paso_1 ,false);
        cambiarVisibilidad(btn_paso_2 ,false);
        cambiarVisibilidad(btn_paso_3 ,false);

        control.instrucciones();
        texto_instruccion.setText(control.getInstruccion());

        switch (paso) {
            case 1:
                cambiarVisibilidad(datos_paso_2 ,true);
                cambiarVisibilidad(btn_paso_2 ,true);
                control.siguientePaso();
                break;
            case 2:
                cambiarVisibilidad(datos_paso_3 ,true);
                cambiarVisibilidad(btn_paso_3 ,true);
                control.siguientePaso();
                break;
            default:
                break;
        }
    }

    private void cambiarVisibilidad(Node nodo ,boolean estado) {
        nodo.setVisible(estado);
        nodo.setManaged(estado);
    }

}
