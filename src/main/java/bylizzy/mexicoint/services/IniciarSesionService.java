/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.dto.autentificacion.AutentificacionApi;
import bylizzy.mexicoint.data.dto.autentificacion.SolicitarAccesoResponseDTO;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 *
 * @author La rana
 */
public class IniciarSesionService {

    public AutentificacionApi servidor = new AutentificacionApi();

    public Validacion entrar(String curp ,String contrasena) throws InterruptedException, JsonProcessingException {
        //llama el api
        SolicitarAccesoResponseDTO dto = servidor.solicitarAcceso(curp ,contrasena);

        if (dto != null && dto.token != null) {
            return new Validacion(true ,"");
        } else {
            return new Validacion(false ,"CURP o contraseña incorrectos");
        }

    }

}
