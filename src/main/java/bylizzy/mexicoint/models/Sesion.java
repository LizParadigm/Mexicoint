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

    private String token;
    private String id;
    private String rol;

    public Sesion(String token ,String id ,String rol) {
        this.token = token;
        this.id = id;
        this.rol = rol;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }

    public String getRol() {
        return rol;
    }

}
