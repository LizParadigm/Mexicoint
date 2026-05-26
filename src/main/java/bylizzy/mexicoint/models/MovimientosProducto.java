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
public class MovimientosProducto {

    private int id;
    private List<Movimientos> movimientos;

    public MovimientosProducto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Movimientos> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimientos> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return "MovimientosProducto{" + "id=" + id + ", movimientos=" + movimientos + '}';
    }

}
