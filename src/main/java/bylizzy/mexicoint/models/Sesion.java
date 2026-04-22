/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

/**
 *
 * @author La rana
 */
public class Sesion {

    private static Usuario usuarioActual;
    private static String token;

    public static void Sesion(Usuario usuario ,String jwt) {
        usuarioActual = usuario;
        token = jwt;
    }

    public Usuario getUsuario() {
        return usuarioActual;
    }

    public String getToken() {
        return token;
    }

    public static void limpiar() {
        usuarioActual = null;
        token = null;
    }

}
