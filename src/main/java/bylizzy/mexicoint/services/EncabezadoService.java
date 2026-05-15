/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.ClienteApi;
import bylizzy.mexicoint.models.Producto;
import bylizzy.mexicoint.models.Productos;
import bylizzy.mexicoint.models.ProductosSolicitables;

/**
 *
 * @author La rana
 */
public class EncabezadoService {
    //inicializamos variables de pagina

    private Productos productosPoseidos;
    private ProductosSolicitables productosSolicitables;

    public EncabezadoService() {
        this.productosPoseidos = ClienteApi.solicitarProducto();
     //   this.productosSolicitables= ClienteApi.solicitarProductosSolicitables();
    }

    public Productos getProductosPoseidos() {
        return productosPoseidos;
    }

    public ProductosSolicitables getProductosSolicitables() {
        return productosSolicitables;
    }

}
