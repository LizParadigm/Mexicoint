/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.models.MovimientosProductos;
import java.util.List;

/**
 *
 * @author La rana
 */
public class MovimientosProductosResponseDTO {

    private List<MovimientosProductoResponseDTO> productos;

    public MovimientosProductosResponseDTO() {
    }

    public List<MovimientosProductoResponseDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<MovimientosProductoResponseDTO> productos) {
        this.productos = productos;
    }

}
