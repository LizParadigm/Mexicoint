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

    private int id;
    private String tipo;
    private String nombre;

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
