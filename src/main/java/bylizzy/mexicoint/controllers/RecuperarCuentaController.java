/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.services.RecuperarCuentaService;
import bylizzy.mexicoint.utils.RutasService;
import bylizzy.mexicoint.utils.ValidacionesService;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class RecuperarCuentaController implements Initializable ,ConfigListenerInterface {

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
    
    @FXML
            private ImageView icon_cerrar;

    /* VARIABLESD DE CONTROL */
    RecuperarCuentaService control = new RecuperarCuentaService();
    ValidacionesService validar = new ValidacionesService();
    RutasService rut=new RutasService();

    private final StringProperty cambiarControlador = new SimpleStringProperty();

    @Override
    public StringProperty cambiarControlador() {
        return cambiarControlador;
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        controlarVisibilidad();

        campo_curp.setTextFormatter(control.crearFormato(validar::regexCurp ,true));
        campo_codigo.setTextFormatter(control.crearFormato(validar::regexCodigo ,false));
        campo_contrasena.setTextFormatter(control.crearFormato(validar::regexContrasena ,false));
    }
    
    @FXML
    public void cerrar(MouseEvent event){
        redireccionarHijo(rut.INICIAR_SESION);
    }

    @FXML
    private void paso_1(ActionEvent event) {
        //validamos datos 1
        Validacion curp = validar.curp(campo_curp.getText());
        if (curp.estado()) {
            //si todo va bien
            controlarVisibilidad();
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
            controlarVisibilidad();
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

    private void controlarVisibilidad() {
        control.cambiarVisibilidad(datos_paso_1 ,false);
        control.cambiarVisibilidad(btn_paso_1 ,false);
        control.cambiarVisibilidad(datos_paso_2 ,false);
        control.cambiarVisibilidad(btn_paso_2 ,false);
        control.cambiarVisibilidad(datos_paso_3 ,false);
        control.cambiarVisibilidad(btn_paso_3 ,false);

        control.instrucciones();
        texto_instruccion.setText(control.getInstruccion());

        switch (control.getPaso()) {
            case 1:
                control.cambiarVisibilidad(datos_paso_1 ,true);
                control.cambiarVisibilidad(btn_paso_1 ,true);
                control.siguientePaso();
                break;
            case 2:
                control.cambiarVisibilidad(datos_paso_2 ,true);
                control.cambiarVisibilidad(btn_paso_2 ,true);
                control.siguientePaso();
                break;
            case 3:
                control.cambiarVisibilidad(datos_paso_3 ,true);
                control.cambiarVisibilidad(btn_paso_3 ,true);
            default:
                break;
        }
    }

    @FXML
    private void redireccionarHijo(String nuevaRuta) {
        cambiarControlador.set(nuevaRuta);
    }

}
