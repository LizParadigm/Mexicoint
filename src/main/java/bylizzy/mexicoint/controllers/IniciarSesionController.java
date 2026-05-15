/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import static bylizzy.mexicoint.App.cambiarVista;
import bylizzy.mexicoint.data.dto.autentificacion.AutentificacionApi;
import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.models.ContenidoHijo;
import static bylizzy.mexicoint.models.Controlador.darFormato;
import bylizzy.mexicoint.services.IniciarSesionService;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class IniciarSesionController implements Initializable ,ConfigListenerInterface {

    @FXML
    private TextField campo_curp;

    @FXML
    private PasswordField campo_contrasena;

    @FXML
    private Label error_curp;

    @FXML
    private Label error_contrasena;

    // VARIABLES DE CONTROL
    IniciarSesionService control = new IniciarSesionService();
    ValidacionesService validar = new ValidacionesService();
    RutasService rut = new RutasService();
    AutentificacionApi api = new AutentificacionApi();

    private final StringProperty cambiarControlador = new SimpleStringProperty();

    @Override
    public StringProperty cambiarControlador() {
        return cambiarControlador;
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {

        campo_curp.setTextFormatter(darFormato(validar::regexCurp ,true));
        campo_contrasena.setTextFormatter(darFormato(validar::regexContrasena ,false));
    }

    @FXML
    private void iniciarSesion(ActionEvent event) {
        Validacion curp = validar.curp(campo_curp.getText());
        Validacion contra = validar.contrasena(campo_contrasena.getText());

        //validaciones front
        if (curp.estado() && contra.estado()) { //si sale bien
            //consumos de api / validaciones desde el backend
            Validacion acceso = control.entrar(campo_curp.getText() ,campo_contrasena.getText());

            if (acceso.estado()) {
                //if (correcto.estado()) {
                redireccionarHijo(rut.MODULO_CLIENTE);
//                } else {
//                    error_contrasena.setText(correcto.mensaje());
//                }
            } else {
                error_curp.setText(acceso.mensaje());
            }
        } else {
            //si sale mal
            error_curp.setText(curp.mensaje());
            error_contrasena.setText(contra.mensaje());
        }
    }

    @FXML
    void recuperarCuenta(MouseEvent event) {
        try {
            redireccionarHijo(rut.RECUPERAR_CUENTA);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void registrar(ActionEvent event) {
        try {
            redireccionarHijo(rut.REGISTRAR_CLIENTE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void redireccionarHijo(String nuevaRuta) {
        cambiarControlador.set(nuevaRuta);
    }
}
