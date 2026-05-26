/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.models.Credito;
import bylizzy.mexicoint.models.ProductoDetallado;
import bylizzy.mexicoint.models.ProductoDetalladoCredito;
import bylizzy.mexicoint.models.ProductoDetalladoInfo;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author La rana
 */
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
public class ProductoDetalladoCreditoResponseDTO extends ProductoDetalladoResponseDTO {

    private CreditoResponseDTO credito;

    public ProductoDetalladoCreditoResponseDTO() {
    }

    public CreditoResponseDTO getCredito() {
        return credito;
    }

    public void setCredito(CreditoResponseDTO credito) {
        this.credito = credito;
    }

    @Override
    public ProductoDetallado toModel() {
        ProductoDetalladoCredito modelo = new ProductoDetalladoCredito();

        modelo.setId(this.getId());
        
        ProductoDetalladoInfo producto=new ProductoDetalladoInfo();
        producto.setTipo(this.getProducto().getTipo());
        producto.setColorPrincipal(this.getProducto().getColorPrincipal());
        producto.setColorSecundario(this.getProducto().getColorSecundario());
        
        modelo.setProducto(producto);
        modelo.setNombre(this.getNombre());
        modelo.setTitular(this.getTitular());
        modelo.setClave(this.getClave());
        
        Credito credito= new Credito();
        credito.setLimite(this.credito.getLimite());
        credito.setDisponible(this.credito.getDisponible());
        credito.setDeuda(this.credito.getDeuda());
        credito.setFechaPago(this.credito.getFechaPago());
        credito.setFechaCorte(this.credito.getFechaCorte());
        
        modelo.setCredito(credito);
        
        modelo.setExpira(this.getExpira());

        return modelo;
    }

}
