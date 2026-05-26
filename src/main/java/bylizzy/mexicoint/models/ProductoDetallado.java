/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;


/**
 *
 * @author La rana
 */

public abstract class ProductoDetallado {

    private int id;
    private ProductoDetalladoInfo producto;
    private String nombre;
    private String titular;
    private String clave;
    //modelo de hijos
    private String expira;

    public ProductoDetallado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductoDetalladoInfo getProducto() {
        return producto;
    }

    public void setProducto(ProductoDetalladoInfo producto) {
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

    @Override
    public String toString() {
        return "ProductoDetallado{" + "id=" + id + ", producto=" + producto + ", nombre=" + nombre + ", titular=" + titular + ", clave=" + clave + ", expira=" + expira + '}';
    }
    

}
