/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import java.util.List;

/**
 *
 * @author La rana
 */
public class MovimientosProductos {

    private List<MovimientosProducto> productos;

    public MovimientosProductos() {
    }

    public List<MovimientosProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<MovimientosProducto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "MovimientosProductos{" + "productos=" + productos + '}';
    }

}
