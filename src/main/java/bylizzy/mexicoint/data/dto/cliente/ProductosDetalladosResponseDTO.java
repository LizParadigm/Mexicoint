package bylizzy.mexicoint.data.dto.cliente;

import java.util.List;

public class ProductosDetalladosResponseDTO {

    private List<ProductoDetalladoResponseDTO> productos;

    public ProductosDetalladosResponseDTO() {
    }

    public List<ProductoDetalladoResponseDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDetalladoResponseDTO> productos) {
        this.productos = productos;
    }


}
