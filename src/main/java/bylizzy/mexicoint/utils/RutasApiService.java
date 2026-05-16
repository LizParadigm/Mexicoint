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

    private final String base="http://localhost:8080/";
    
    private final String autentificacion= this.base+"autentificacion/";
    
    private final String solicitarAcceso= this.autentificacion+"solicitaracceso";
    private final String comprobarCurp=this.autentificacion+"comprobarcurp";
    private final String crearCliente=this.autentificacion+"crearcliente";
    private final String comprobarCodigo=this.autentificacion+"comprobarcodigo";
    private final String cambiarContrasena=this.autentificacion+"cambiarcontrasena";


    public String getSolicitarAcceso() {
        return solicitarAcceso;
    }

    public String getComprobarCurp() {
        return comprobarCurp;
    }

    public String getCrearCliente() {
        return crearCliente;
    }
    
    public String getComprobarCodigo(){
        return comprobarCodigo;
    }
    
    
    public String getCambiarContrasena(){
        return cambiarContrasena;
    }
    
    
    
}
