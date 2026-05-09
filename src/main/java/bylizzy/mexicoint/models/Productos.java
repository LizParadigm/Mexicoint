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
public class Productos {

    private List<Producto> lista;

    public Productos() {
    }

    public List<Producto> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        return "Productos{"
                + "lista=" + lista
                + '}';
    }
}
