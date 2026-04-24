/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import javafx.scene.Node;

/**
 *
 * @author La rana
 */
public class RegistrarService {

    //control de paso
    private int paso;
    //datos del paso 1
    private Node nombre;
    private Node apellidoPaterno;
    private Node apellidoMaterno;
    private Node dia;
    private Node mes;
    private Node ano;
    private Node curp;
    //datos del paso 2
    //datos del paso 3

    public RegistrarService() {
        this.paso = 1;
    }

    //funciones
    public void siguientePaso() {
        paso = paso + 1;
    }
    
    
    
    

    //getters y setters
    public int getPaso() {
        return paso;
    }
    

}
