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
        using= JsonDeserializer.None.class
)
public class ProductoDetalladoDebito extends ProductoDetallado {

    private Saldo saldo;

    public ProductoDetalladoDebito() {
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ProductoDetalladoDebito{"+super.toString() + "saldo=" + saldo + '}';
    }

    
    

}
