package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.models.ProductoDetallado;
import bylizzy.mexicoint.models.ProductoDetalladoDebito;
import bylizzy.mexicoint.models.ProductoDetalladoInfo;
import bylizzy.mexicoint.models.Saldo;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(
        using = JsonDeserializer.None.class
)
public class ProductoDetalladoDebitoResponseDTO extends ProductoDetalladoResponseDTO {

    private SaldoResponseDTO saldo;

    public ProductoDetalladoDebitoResponseDTO() {
    }

    public SaldoResponseDTO getSaldo() {
        return saldo;
    }

    public void setSaldo(SaldoResponseDTO saldo) {
        this.saldo = saldo;
    }

    @Override
    public ProductoDetallado toModel() {
        ProductoDetalladoDebito modelo = new ProductoDetalladoDebito();

        modelo.setId(this.getId());
        
        ProductoDetalladoInfo producto = new ProductoDetalladoInfo();
        producto.setTipo(this.getProducto().getTipo());
        producto.setColorPrincipal(this.getProducto().getColorPrincipal());
        producto.setColorSecundario(this.getProducto().getColorSecundario());

        modelo.setProducto(producto);
        modelo.setNombre(this.getNombre());
        modelo.setTitular(this.getTitular());
        modelo.setClave(this.getClave());
        /*
             NOTA PARA DESPUES
         si se pasan los datos saldo uno por uno directamente 
         al modelo no funciona por que el saldo dentro del modelo
         no se a inicializado, tocara crear un object Saldo y
         pasarlo con un getSaldo al modelo, es un paso extra pero
         es lo que toca hacer de momento hasta que tenga tiempo
         de mejorarlo a algo mas fluido pero sirve. esto en debito.
         */
        Saldo saldo = new Saldo();
        saldo.setActual(this.saldo.getActual());
        saldo.setLimite(this.saldo.getLimite());

        modelo.setSaldo(saldo);

        modelo.setExpira(this.getExpira());

        return modelo;
    }

}
