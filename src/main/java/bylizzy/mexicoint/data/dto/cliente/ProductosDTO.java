/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import java.util.List;

/**
 *
 * @author La rana
 */
public class ProductosDTO {

    private List<ProductoDTO> debito;
    private List<ProductoDTO> credito;

    public ProductosDTO() {
    }

    public List<ProductoDTO> getDebito() {
        return debito;
    }

    public List<ProductoDTO> getCredito() {
        return credito;
    }

}
