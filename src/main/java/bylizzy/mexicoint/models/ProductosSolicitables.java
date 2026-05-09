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
public class ProductosSolicitables {

    private List<Producto> debito;
    private List<Producto> credito;

    public ProductosSolicitables() {
    }

    public List<Producto> getDebito() {
        return debito;
    }

    public List<Producto> getCredito() {
        return credito;
    }

    @Override
    public String toString() {
        return "ProductosSolicitables{"
                + "debito=" + debito
                + ", credito=" + credito
                + '}';
    }

}
