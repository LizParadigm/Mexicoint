/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.ClienteApi;
import bylizzy.mexicoint.models.Controlador;
import bylizzy.mexicoint.models.Movimientos;
import bylizzy.mexicoint.models.MovimientosProducto;
import bylizzy.mexicoint.models.ProductoDetallado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author La rana
 */
public class ClienteProductoService extends Controlador {

    private ProductoDetallado producto;
    private String cv;
    private List<Movimientos> movimientosIngresos;
    private List<Movimientos> movimientosGastos;

    private ClienteApi servidor = new ClienteApi();

    //solicita los datos del producto al que pertenece el id  y debe ser un producto del cliente.
    public void cargarProducto(int id) {
        this.producto = servidor.solicitarInfoProductocrud(id).toModel();
        System.out.println("cargarProducto. producto: ");
        System.out.println(this.producto.toString());
        this.cargarMovimientos(1);
        this.cargarMovimientos(2);
    }

    public void cargarCV() {
        this.cv = servidor.solicitarNuevoCV(this.producto.getId());
    }

    public void eliminarCV() {
        servidor.solicitarEliminarCV(this.producto.getId());
        this.cv="";
    }

    //solicitar los ultimos 7 movimientos del producto basado en el id del producto.
    public void cargarMovimientos(int filtro) {
        List<Movimientos> movimientos = servidor.solicitarMovimientosProducto(this.producto.getId() ,filtro);
        switch (filtro) {
            case 1:
                this.movimientosIngresos = movimientos;
                break;
            case 2:
                this.movimientosGastos = movimientos;
                break;
            default:
                break;

        }
        System.out.println("cargarMovimientos. producto y movimientos con filtro: " + filtro);
        System.out.println(movimientos.toString());

    }

    public ProductoDetallado getProducto() {
        return producto;
    }

    public List<Movimientos> getMovimientosIngresos() {
        return movimientosIngresos;
    }

    public List<Movimientos> getMovimientosGastos() {
        return movimientosGastos;
    }

    public String getCV() {
        return this.cv;
    }

}
