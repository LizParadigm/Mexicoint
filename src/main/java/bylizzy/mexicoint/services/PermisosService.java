/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.utils.ControlSesion;
import bylizzy.mexicoint.utils.RutasService;

/**
 *
 * @author La rana
 */
public class PermisosService {

    static RutasService rut;
    
    public String getMenuLateral() {
        String rol = ControlSesion.getUsuario().getRol();
        switch (rol) {
            case "cliente":
                return rut.MENU_LATERAL_CLIENTE;
            case "ejecutivo":
                return rut.MENU_LATERAL_EJECUTIVO;
            case "administrador":
                return rut.MENU_LATERAL_ADMINISTRADOR;
            default:
                System.out.println("error getMEnuLateral, rol no encontrado");
                return null;
        }
    }
    
    public String getHome(){
        String rol = ControlSesion.getUsuario().getRol();
        switch (rol) {
            case "cliente":
                return rut.HOME_CLIENTE;
            case "ejecutivo":
                return rut.HOME_EJECUTIVO;
            case "administrador":
                return rut.HOME_ADMINISTRADOR;
            default:
                System.out.println("error getMEnuLateral, rol no encontrado");
                return null;
        }
    }
    
    
}
