/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import bylizzy.mexicoint.models.Sesion;

/**
 *
 * @author La rana
 */
public class ControlSesion {

    private static Sesion usuario;

    public static void IniciarSesion(Sesion datos) {
        usuario = datos;
    }

    public static Sesion getUsuario() {
        return usuario;
    }

    public static void cerrarSesion() {
        usuario = null;
    }

}
