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
public class Pais {
    private String pais;
    private List<Estado> estados;

    public Pais(String pais ,List<Estado> estados) {
        this.pais = pais;
        this.estados = estados;
    }

    public String getPais() {
        return pais;
    }

    public List<Estado> getEstados() {
        return estados;
    }
    
}
