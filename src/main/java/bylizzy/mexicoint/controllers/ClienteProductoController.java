/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package bylizzy.mexicoint.controllers;

import bylizzy.mexicoint.models.Movimientos;
import bylizzy.mexicoint.models.ProductoDetallado;
import bylizzy.mexicoint.models.ProductoDetalladoDebito;
import bylizzy.mexicoint.services.ClienteProductoService;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author La rana
 */
public class ClienteProductoController implements Initializable {

    @FXML
    private Button btn_copiar_clave;

    @FXML
    private Button btn_detalles;

    @FXML
    private Button btn_gastos;

    @FXML
    private Button btn_ingresos;

    @FXML
    private Button btn_salud_financiera;

    @FXML
    private Button btn_transferir;

    @FXML
    private Button btn_ver_cv;

    @FXML
    private VBox contenedor_gastos;

    @FXML
    private VBox contenedor_ingresos;

    @FXML
    private VBox contenedor_producto_datos1;

    @FXML
    private VBox contenedor_producto_datos2;

    @FXML
    private ImageView img_btn_cv_visibilidad;

    @FXML
    private Label lbl_producto_nombre;

    @FXML
    private Label lbl_producto_num_cuenta;

    @FXML
    private Label lbl_producto_propietario;

    @FXML
    private Label lbl_producto_saldo;

    @FXML
    private Label lbl_producto_tipo;

    @FXML
    private StackPane sp_tarjeta_1;

    @FXML
    private StackPane sp_tarjeta_2;

    @FXML
    private TableView<Movimientos> tabla_gastos;

    @FXML
    private TableColumn<Movimientos ,String> tabla_gastos_fecha;

    @FXML
    private TableColumn<Movimientos ,BigDecimal> tabla_gastos_monto;

    @FXML
    private TableColumn<Movimientos ,String> tabla_gastos_movimiento;

    @FXML
    private TableView<Movimientos> tabla_ingresos;

    @FXML
    private TableColumn<Movimientos ,String> tabla_ingresos_fecha;

    @FXML
    private TableColumn<Movimientos ,BigDecimal> tabla_ingresos_monto;

    @FXML
    private TableColumn<Movimientos ,String> tabla_ingresos_movimiento;

    @FXML
    private Text txt_cv_temporizador;

    @FXML
    private Text txt_producto_cv;

    @FXML
    private Text txt_producto_fecha_vencimiento;

    // VARIABLES DE CONTROL
    ClienteProductoService control = new ClienteProductoService();

    public void setProductoId(int id) {
        control.cargarProducto(id);
        this.actualizarDetalles();
        this.actualizarTablas();
    }

    @FXML
    void copiarClave(ActionEvent event) {
        control.portapapelesCopiar(this.lbl_producto_num_cuenta.getText());
    }

    @FXML
    void mostrarDetalles(ActionEvent event) {
        this.verDatosTarjeta();

    }

    @FXML
    void saludFinanciera(ActionEvent event) {

    }

    @FXML
    void transferir(ActionEvent event) {

    }

    @FXML
    void verCv(ActionEvent event) {
        this.verCV();
    }

    @FXML
    void verGastos(ActionEvent event) {

    }

    @FXML
    void verIngresos(ActionEvent event) {

    }

    @Override
    public void initialize(URL url ,ResourceBundle rb) {
        //producto
        control.cambiarVisibilidad(this.sp_tarjeta_2 ,false);
        control.cambiarVisibilidad(this.txt_producto_cv ,false);
        control.cambiarVisibilidad(this.txt_cv_temporizador ,false);

        //las tablas deben ajustarce al tamaño maximo permitido de momento: this.tabla_ingresos y this.tabla_gastos
        tabla_ingresos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla_gastos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    //vista producto
    //debe falta hacer otra variante de la caratula de this.sp_tarjeta_1 y this.sp_tarjeta_2 ya que la que hay es compatible solo con debito, faltaria credito.
    private void actualizarDetalles() {
        this.actualizarproducto();
        //this.actualizarTablas();

    }

    private void actualizarproducto() {
        ProductoDetalladoDebito producto = (ProductoDetalladoDebito)control.getProducto();
        //sp_tarjeta_1
        this.lbl_producto_nombre.setText(producto.getNombre());
        this.lbl_producto_saldo.setText(producto.getSaldo().getActual().toString());
        this.lbl_producto_propietario.setText(producto.getTitular());
        this.lbl_producto_num_cuenta.setText(producto.getClave());
        //sp_tarjeta_2
        this.lbl_producto_tipo.setText(producto.getProducto().getTipo());
        this.txt_producto_fecha_vencimiento.setText(producto.getExpira());
    }

    private void verDatosTarjeta() {
        System.out.println();
        control.cambiarVisibilidad(this.sp_tarjeta_2 ,!this.sp_tarjeta_2.isVisible());
    }

    private void verCV() {
        if (this.txt_producto_cv.isVisible()) {
            this.control.cambiarVisibilidad(this.txt_producto_cv ,false);
            this.control.cambiarVisibilidad(this.txt_cv_temporizador ,false);

            this.control.eliminarCV();
        } else {
            this.control.cambiarVisibilidad(this.txt_producto_cv ,true);
            this.control.cambiarVisibilidad(this.txt_cv_temporizador ,true);

            this.control.cargarCV();
            this.control.iniciarTemporizador(this.txt_cv_temporizador ,5 ,() -> {
                this.control.cambiarVisibilidad(this.txt_producto_cv ,false);
                this.control.cambiarVisibilidad(this.txt_cv_temporizador ,false);
                this.control.eliminarCV();
            });
        }

        this.txt_producto_cv.setText(this.control.getCV());
    }

    //tablas
    private void actualizarTablas() {
        this.actualizarIngresos();
        this.actualizarGastos();

    }

    private void actualizarIngresos() {
        this.tabla_ingresos_movimiento.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.tabla_ingresos_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.tabla_ingresos_monto.setCellValueFactory(new PropertyValueFactory<>("monto"));

        ObservableList<Movimientos> ingresos = FXCollections.observableArrayList(
                control.getMovimientosIngresos()
        );

        this.tabla_ingresos.setItems(ingresos);

        control.ajustarAlturaTabla(this.tabla_ingresos ,control.getMovimientosIngresos().size());
    }

    private void actualizarGastos() {
        this.tabla_gastos_movimiento.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.tabla_gastos_fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        this.tabla_gastos_monto.setCellValueFactory(new PropertyValueFactory<>("monto"));

        ObservableList<Movimientos> gastos = FXCollections.observableArrayList(
                control.getMovimientosGastos()
        );

        this.tabla_gastos.setItems(gastos);

        control.ajustarAlturaTabla(this.tabla_gastos ,control.getMovimientosGastos().size());
    }

}
