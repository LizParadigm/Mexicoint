/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.AutentificacionApi;
import bylizzy.mexicoint.data.dto.autentificacion.SolicitarAccesoResponseDTO;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion2;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 *
 * @author La rana
 */
public class IniciarSesionService {

    public AutentificacionApi servidor = new AutentificacionApi();

    public Validacion2 entrar(String curp ,String contrasena) throws InterruptedException ,JsonProcessingException {
        //llama el api
        SolicitarAccesoResponseDTO dto = servidor.solicitarAcceso(curp ,contrasena);

        //dependiendo del mensaje del api, se asignaran los caracteres
        //si sale bien
        if (dto != null && dto.getToken() != null) {
            return new Validacion2(new Validacion(true ,"") ,new Validacion(true ,""));
        }
        //si la curp no se encontro en la base de datos
        
        //si la contrasena es incorrecta
        
        //otros errores: se muestra el mensaje del backend directamente en el campo curp
        else {
            return new Validacion2(new Validacion(false ,"Error desconocido.") ,new Validacion(false ,"Error desconocido."));
        }

    }

}
