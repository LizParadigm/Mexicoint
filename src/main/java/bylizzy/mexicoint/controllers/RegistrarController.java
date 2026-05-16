/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.models.Estado;
import bylizzy.mexicoint.services.RegistrarService;
import bylizzy.mexicoint.utils.ValidacionesService;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import bylizzy.mexicoint.utils.CatalogoUbicacionesService;
import bylizzy.mexicoint.utils.RutasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class RegistrarController implements Initializable ,ConfigListenerInterface {

    @FXML
    private Button btn_paso_1;

    @FXML
    private Button btn_paso_2;

    @FXML
    private Button btn_paso_3;

    @FXML
    private TextField campo_apellido_m;

    @FXML
    private TextField campo_apellido_p;

    @FXML
    private TextField campo_calle;

    @FXML
    private TextField campo_ciudad_municipio;

    @FXML
    private TextField campo_codigo_postal;

    @FXML
    private TextField campo_colonia_barrio;

    @FXML
    private PasswordField campo_confirmar_contrasena;

    @FXML
    private PasswordField campo_contrasena;

    @FXML
    private TextField campo_curp;

    @FXML
    private ComboBox<Estado> campo_estado;

    @FXML
    private DatePicker campo_fecha_nacimiento;

    @FXML
    private TextField campo_nombre;

    @FXML
    private TextField campo_num_ext;

    @FXML
    private TextField campo_num_int;

    @FXML
    private ComboBox<String> campo_pais;

    @FXML
    private GridPane datos_paso_1;

    @FXML
    private GridPane datos_paso_2;

    @FXML
    private GridPane datos_paso_3;

    @FXML
    private Label error_apellido_m;

    @FXML
    private Label error_apellido_p;

    @FXML
    private Label error_calle;

    @FXML
    private Label error_ciudad_municipio;

    @FXML
    private Label error_codigo_postal;

    @FXML
    private Label error_colonia_barrio;

    @FXML
    private Label error_curp;

    @FXML
    private Label error_estado;

    @FXML
    private Label error_fecha_nacimiento;

    @FXML
    private Label error_nombre;

    @FXML
    private Label error_num_ext;

    @FXML
    private Label error_num_int;

    @FXML
    private Label error_pais;

    @FXML
    private Label error_contrasena;

    @FXML
    private Label error_confirmar_contrasena;

    @FXML
    private ImageView icon_cerrar;

    /*variables de control*/
    RegistrarService control = new RegistrarService();
    ValidacionesService validar = new ValidacionesService();
    RutasService rut = new RutasService();

    private final StringProperty cambiarControlador = new SimpleStringProperty();

    @Override
    public StringProperty cambiarControlador() {
        return cambiarControlador;
    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        //CONFIGURACION DE FORMATO DE CAMPOS
        //datos de identificacion
        campo_nombre.setTextFormatter(control.crearFormato(validar::regexNombre ,false));
        campo_apellido_p.setTextFormatter(control.crearFormato(validar::regexApellido ,false));
        campo_apellido_m.setTextFormatter(control.crearFormato(validar::regexApellido ,false));
        campo_fecha_nacimiento.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter[] formatos = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("dd/MM/yy") ,
                DateTimeFormatter.ofPattern("dd-MM-yyyy") ,
                DateTimeFormatter.ofPattern("yyyy MM dd") ,
                DateTimeFormatter.ofPattern("dd MM yyyy") ,
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
            };

            @Override
            public String toString(LocalDate fecha) {

                return fecha != null ? DateTimeFormatter.ofPattern("dd/MM/yyyy").format(fecha) : "";
            }

            @Override
            public LocalDate fromString(String texto) {
                for (DateTimeFormatter f : formatos) {
                    try {
                        error_fecha_nacimiento.setText("");
                        return LocalDate.parse(texto.trim() ,f);
                    } catch (Exception e) {
                        error_fecha_nacimiento.setText("Formato no aceptado.");
                    }
                }
                return null;
            }
        });
        campo_curp.setTextFormatter(control.crearFormato(validar::regexCurp ,true));

        //datos de domicilio
        campo_calle.setTextFormatter(control.crearFormato(validar::regexCalle ,false));
        campo_num_ext.setTextFormatter(control.crearFormato(validar::regexNumeroExt ,false));
        campo_num_int.setTextFormatter(control.crearFormato(validar::regexNumeroInt ,false));
        campo_colonia_barrio.setTextFormatter(control.crearFormato(validar::regexColoniaBarrio ,false));
        campo_codigo_postal.setTextFormatter(control.crearFormato(validar::regexCodigoPostal ,false));
        campo_ciudad_municipio.setTextFormatter(control.crearFormato(validar::regexCiudadMunicipio ,false));
        campo_pais.getItems().addAll(CatalogoUbicacionesService.paises());
        campo_pais.setValue("Seleccionar pais");
        control.configurarPais(campo_estado ,campo_pais.getValue());
        //       campo_estado.getItems().addAll(pais.getEstados());

        //datos de seguridad
        //campo_contrasena
        //campo_confirmar_contrasena
        //VISIBILIDAD
        controlarVisibilidad();
    }

    @FXML
    private void cerrar(MouseEvent event) {
        redireccionarHijo(rut.INICIAR_SESION);
    }

    @FXML
    private void paso_1(ActionEvent event) throws InterruptedException {
        //Validar datos 1 solo front
        Validacion nombre = validar.nombre(campo_nombre.getText());
        Validacion apellido_p = validar.apellido(campo_apellido_p.getText());
        Validacion apellido_m = validar.apellido(campo_apellido_m.getText());
        Validacion cumpleanos = validar.fechaNacimiento(campo_fecha_nacimiento.getEditor().getText());
        Validacion curp = validar.curp(campo_curp.getText());

        //if (true) {
        if (nombre.estado() && apellido_p.estado() && apellido_m.estado() && cumpleanos.estado() && curp.estado()) {

            Validacion existe = control.validarCurp(campo_curp.getText());
            if (existe.estado()) {
                controlarVisibilidad();
            } else {
                error_curp.setText(existe.mensaje());
            }
        } else {
            error_nombre.setText(nombre.mensaje());
            error_apellido_p.setText(apellido_p.mensaje());
            error_apellido_m.setText(apellido_m.mensaje());
            error_fecha_nacimiento.setText(cumpleanos.mensaje());
            error_curp.setText(curp.mensaje());
        }
    }

    @FXML
    private void paso_2(ActionEvent event) {
        // validar datos 2 solo front
        Validacion calle = validar.calle(campo_calle.getText());
        Validacion num_ext = validar.numeroExterior(campo_num_ext.getText());
        Validacion num_int = validar.numeroInterior(campo_num_int.getText());
        Validacion colonia_barrio = validar.coloniaBarrio(campo_colonia_barrio.getText());
        Validacion codigo_postal = validar.codigoPostal(campo_codigo_postal.getText());
        Validacion ciudad_municipio = validar.ciudadMunicipio(campo_ciudad_municipio.getText());
        Validacion estado = validar.estado(campo_estado.getValue().toString());
        Validacion pais = validar.pais(campo_pais.getValue().toString());

        //if (true) {
        if (calle.estado() && num_ext.estado() && num_int.estado() && colonia_barrio.estado() && codigo_postal.estado() && ciudad_municipio.estado() && estado.estado() && pais.estado()) {
            controlarVisibilidad();

        } else {
            error_calle.setText(calle.mensaje());
            error_num_ext.setText(num_ext.mensaje());
            error_num_int.setText(num_int.mensaje());
            error_colonia_barrio.setText(colonia_barrio.mensaje());
            error_codigo_postal.setText(codigo_postal.mensaje());
            error_ciudad_municipio.setText(ciudad_municipio.mensaje());
            error_estado.setText(estado.mensaje());
            error_pais.setText(pais.mensaje());
        }
    }

    @FXML
    private void paso_3(ActionEvent event) throws IOException ,JsonProcessingException ,InterruptedException {
        //validar datos 3 solo front
        Validacion contrasena = validar.contrasena(campo_contrasena.getText());
        Validacion confirmar = validar.contrasenaCorrecta(campo_contrasena.getText() ,campo_confirmar_contrasena.getText());

        //if (false) {
        if (contrasena.estado() && confirmar.estado()) {
            //solicitar al servidor crear una cuenta cliente
            Validacion creado = control.crearCliente(campo_nombre.getText() ,campo_apellido_p.getText() ,campo_apellido_m.getText() ,campo_fecha_nacimiento.getEditor().getText() ,campo_curp.getText() ,campo_calle.getText() ,campo_num_ext.getText() ,campo_num_int.getText() ,campo_colonia_barrio.getText() ,campo_codigo_postal.getText() ,campo_ciudad_municipio.getText() ,campo_estado.getValue().toString() ,campo_pais.getValue().toString() ,campo_contrasena.getText());
            if(creado.estado()){
            try {
                //entrar al home cliente
                redireccionarHijo(rut.INICIAR_SESION);
                //App.cambiarVista(ControlVista.INICIAR_SESION);
            } catch (Exception e) {
                //si sale mal mostrar mensaje de que salio mal y explicar por que
            }
            }else{
                error_contrasena.setText(creado.mensaje());
            }
        } else {
            error_contrasena.setText(contrasena.mensaje());
            error_confirmar_contrasena.setText(confirmar.mensaje());
        }
    }

    @FXML
    private void cambiarPais(ActionEvent event) {
        control.configurarPais(campo_estado ,campo_pais.getValue());
    }

    /*funciones de control*/
    private void controlarVisibilidad() {
        int paso = control.getPaso();
        control.cambiarVisibilidad(datos_paso_1 ,false);
        control.cambiarVisibilidad(datos_paso_2 ,false);
        control.cambiarVisibilidad(datos_paso_3 ,false);
        control.cambiarVisibilidad(btn_paso_1 ,false);
        control.cambiarVisibilidad(btn_paso_2 ,false);
        control.cambiarVisibilidad(btn_paso_3 ,false);
        switch (paso) {
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
    void redireccionarHijo(String nuevaRuta) {
        cambiarControlador.set(nuevaRuta);
    }

}
