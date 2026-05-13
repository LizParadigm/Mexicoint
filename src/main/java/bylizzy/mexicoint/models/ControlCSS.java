/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import javafx.scene.Node;

/**
 *
 * @author La rana
 */
public class ControlCSS {

    public void cambiarClase(Node nodo ,String quitar ,String agregar) {
        nodo.getStyleClass().remove(quitar);
        nodo.getStyleClass().add(agregar);
    }
}
