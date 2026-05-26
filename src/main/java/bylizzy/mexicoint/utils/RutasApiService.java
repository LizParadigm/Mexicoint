/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import java.net.URI;
import java.net.http.HttpRequest;

/**
 *
 * @author La rana
 */
public class RutasApiService {

    private final String base = "http://localhost:8080/";

    private final String autentificacion = this.base + "autentificacion/";

    private final String solicitarAcceso = this.autentificacion + "solicitaracceso";
    private final String comprobarCurp = this.autentificacion + "comprobarcurp";
    private final String crearCliente = this.autentificacion + "crearcliente";
    private final String comprobarCodigo = this.autentificacion + "comprobarcodigo";
    private final String cambiarContrasena = this.autentificacion + "cambiarcontrasena";

    private final String cliente = this.base + "cliente/";

    private final String solicitarProductosObtenidos = this.cliente+"solicitarproductosobtenidos";
    private final String solicitarProductosObtenibles = this.cliente+"solicitarproductosobtenibles";

    public String getSolicitarAcceso() {
        return this.solicitarAcceso;
    }

    public String getComprobarCurp() {
        return this.comprobarCurp;
    }

    public String getCrearCliente() {
        return this.crearCliente;
    }

    public String getComprobarCodigo() {
        return this.comprobarCodigo;
    }

    public String getCambiarContrasena() {
        return this.cambiarContrasena;
    }
    
    public String getSolicitarProductosObtenidos(){
        return this.solicitarProductosObtenidos;
    }
    
    public String getSolicitarProductosObtenibles(){
        return this.solicitarProductosObtenibles;
    }

}
