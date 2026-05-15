/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.autentificacion;

/**
 *
 * @author La rana
 */
public class SolicitarAccesoRequestDTO {
    private String curp;
    private String contrasena;

    public SolicitarAccesoRequestDTO(String curp ,String contrasena) {
        this.curp = curp;
        this.contrasena = contrasena;
    }

    public String getCurp() {
        return curp;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    }
