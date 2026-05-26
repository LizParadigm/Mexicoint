/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author La rana
 */
@JsonDeserialize(
        using = JsonDeserializer.None.class
)
public class ProductoDetalladoCredito extends ProductoDetallado {

    private Credito credito;

    public ProductoDetalladoCredito() {
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "ProductoDetalladoCredito{" + super.toString() + "credito=" + credito + '}';
    }

}
