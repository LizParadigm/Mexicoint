/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

/**
 *
 * @author La rana
 */
public class Producto {

    private String id;
    private String tipo;
    private String nombre;

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "id='" + id + '\''
                + ", tipo='" + tipo + '\''
                + ", nombre='" + nombre + '\''
                + '}';
    }

}
