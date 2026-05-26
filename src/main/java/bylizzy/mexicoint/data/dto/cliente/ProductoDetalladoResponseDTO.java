package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.data.dto.cliente.deserializers.ProductoDetalladoDTODeserializer;
import bylizzy.mexicoint.models.ProductoDetallado;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(
        using = ProductoDetalladoDTODeserializer.class
)

public abstract class ProductoDetalladoResponseDTO {

    private int id;
    private ProductoDetalladoInfoResponseDTO producto;
    private String nombre;
    private String titular;
    private String clave;
    //modelo de hijos
    private String expira;

    public ProductoDetalladoResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductoDetalladoInfoResponseDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDetalladoInfoResponseDTO producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getExpira() {
        return expira;
    }

    public void setExpira(String expira) {
        this.expira = expira;
    }

    public abstract ProductoDetallado toModel();

}
