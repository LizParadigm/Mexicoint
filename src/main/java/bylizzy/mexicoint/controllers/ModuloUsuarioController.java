/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.interfaces.ConfigListenerInterface;
import bylizzy.mexicoint.interfaces.ContenidoListener;
import bylizzy.mexicoint.interfaces.MenuLateralListener;
import bylizzy.mexicoint.interfaces.ProductoListener;
import bylizzy.mexicoint.interfaces.SolicitarProductoListener;
import bylizzy.mexicoint.models.ContenidoHijo;
import bylizzy.mexicoint.models.Sesion;
import bylizzy.mexicoint.services.EncabezadoService;
import bylizzy.mexicoint.services.ModuloUsuarioService;
import bylizzy.mexicoint.services.PermisosService;
import bylizzy.mexicoint.utils.ControlSesion;
import bylizzy.mexicoint.utils.RutasService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class ModuloUsuarioController implements Initializable ,MenuLateralListener ,ProductoListener ,SolicitarProductoListener ,ContenidoListener {

    @FXML
    private StackPane contenedor_contenido;

    @FXML
    private StackPane contenedor_encabezado;

    @FXML
    private StackPane contenedor_encabezado_menu;

    @FXML
    private StackPane contenedor_popup;

    // VARIABLES DE CONTROL
    ModuloUsuarioService control = new ModuloUsuarioService();
    ContenidoHijo controlHijo = new ContenidoHijo();
    RutasService rut = new RutasService();
    PermisosService permisos = new PermisosService();

    private ContenidoListener contenido;

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        //borrar esto
        ControlSesion.IniciarSesion(new Sesion("token" ,"2" ,"cliente"));
        //CARGAR HIJOS
        try {
            cargarEncabezado();
            cargarContenido(permisos.getHome());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // VISIBILIDAD INICIAL
        control.cambiarVisibilidad(this.contenedor_encabezado_menu ,false);
        control.cambiarVisibilidad(this.contenedor_popup ,false);

    }

    //FUNCIONES, BOTONES Y EVENTOS
    //FUNCIONES
    private void cargarEncabezado() throws IOException {
        FXMLLoader vistaCargada = controlHijo.cargarHijo(this.contenedor_encabezado ,rut.ENCABEZADO);
        EncabezadoController controlador = vistaCargada.getController();
        controlador.setMenuLateral(this);
    }

    @Override
    public void abrirMenu() {
        System.out.println("abrrir menu lateral ahora");
        try {
            control.cambiarVisibilidad(this.contenedor_encabezado_menu ,true);
            cargarMenuLateral();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMenuLateral() throws IOException {
        FXMLLoader vistaCargada = controlHijo.cargarHijo(this.contenedor_encabezado_menu ,permisos.getMenuLateral());
        MenuClienteController controlador = vistaCargada.getController();
        controlador.setProducto(this);
    }

    @Override
    public void seleccionarProducto(String id ,String nombre) {
        System.out.println("producto seleccionado " + id + " " + nombre);
        try {
            control.cambiarVisibilidad(this.contenedor_popup ,true);
            this.cargarSolicitud(id ,nombre);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nuevoProductoPrincipal(int id) {
        System.out.println("cambiar producto principal por: " + id);
        this.contenido.pasarInt(id);
    }

    @Override
    public void cerrarMenuLateral() {
        System.out.println("cerrando menu lateral 2");
        this.cerrar(this.contenedor_encabezado_menu);
    }

    @FXML
    private void cerrarMenuLateral(MouseEvent event) {
        System.out.println("menu cerrado");
        this.cerrar(this.contenedor_encabezado_menu);
    }

    private void cargarSolicitud(String id ,String nombre) throws IOException {
        FXMLLoader vistaCargada = controlHijo.cargarHijo(this.contenedor_popup ,rut.SOLICITAR_PRODUCTO);
        SolicitarProductoController controlador = vistaCargada.getController();
        controlador.cofigDatosProducto(id ,nombre);
        controlador.setSolicitud(this);
    }

    @Override
    public void cancelarSolicitud() {
        System.out.println("solicitud cancelada");
        this.cerrar(this.contenedor_popup);
    }

    private void cargarContenido(String fxml) throws IOException {
        System.out.println("cargando contenido -------------");
        FXMLLoader vistaCargada = controlHijo.cargarHijo(this.contenedor_contenido ,fxml);
        this.contenido = vistaCargada.getController();
    }

    @Override
    public void pasarInt(int dato) {

    }

    @Override
    public void cambiarFXML(String fxml) {
        System.out.println("cambiando FXML");
        try {
            this.cargarContenido(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //por refactorizar
    private void contenedorHijo(StackPane padre ,String fxml) throws IOException {
        try {
            FXMLLoader vistaCargada = controlHijo.cargarHijo(padre ,fxml);

            ConfigListenerInterface controlador = vistaCargada.getController();
            System.out.println(controlador);
            configurarListener(controlador ,padre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configurarListener(ConfigListenerInterface ref ,StackPane padre) {
        ref.cambiarControlador().addListener((observable ,viejo ,fxmlNuevo) -> {
            try {
                actualizarContenedorHijo(padre ,fxmlNuevo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void actualizarContenedorHijo(StackPane padre ,String fxmlNuevo) throws IOException {
        controlHijo.borrarHijo(padre);
        contenedorHijo(padre ,fxmlNuevo);
    }

    private void cerrar(StackPane padre) {
        controlHijo.borrarHijo(padre);
        control.cambiarVisibilidad(padre ,false);
    }

}
