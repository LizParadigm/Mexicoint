/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.ClienteApi;
import bylizzy.mexicoint.data.dto.cliente.SolicitarProductosPoseidosResponseDTO;
import bylizzy.mexicoint.models.Controlador;
import bylizzy.mexicoint.models.Producto;
import bylizzy.mexicoint.models.Productos;
import bylizzy.mexicoint.models.ProductosSolicitables;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author La rana
 */
public class MenuClienteService extends Controlador {

    private Productos productosPoseidos;
    private ProductosSolicitables productosSolicitables;

    private ClienteApi servidor = new ClienteApi();

    public MenuClienteService() throws InterruptedException {
        this.productosPoseidos = 
                servidor.solicitarProductoscrud();
                //obtenerProductos();
        this.productosSolicitables = ClienteApi.solicitarProductosSolicitablescrud();
    }

    private List<Producto> obtenerProductos() throws InterruptedException {
        return servidor.solicitarProducto().getLista().stream().map(dto -> {
            Producto producto = new Producto();

            producto.setId(dto.getId());
            producto.setTipo(dto.getTipo());
            producto.setNombre(dto.getNombre());

            return producto;
        }).toList();
    }

    private ProductosSolicitables obtenerProductosSolicitables() throws InterruptedException, IOException {
//        
//        List<Producto> productosDebito =
//        debito.stream()
//                .map(dto -> {
//
//                    Producto p = new Producto();
//
//                    p.setId(dto.getId());
//                    p.setTipo(dto.getTipo());
//                    p.setNombre(dto.getNombre());
//
//                    return p;
//                })
//                .toList();
//                servidor.solicitarObtenerProducto();
return null;
    }

    public Productos getProductosPoseidos() {
        return productosPoseidos;
    }

    public ProductosSolicitables getProductosSolicitables() {
        return productosSolicitables;
    }

}
