/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.api.AutentificacionApi;
import bylizzy.mexicoint.data.dto.IniciarSesionDTO;
import bylizzy.mexicoint.models.Sesion;
import bylizzy.mexicoint.models.Usuario;

/**
 *
 * @author La rana
 */
public class IniciarSesionService {

    public Usuario entrar(String curp ,String contrasena) {
        //llama el api
        IniciarSesionDTO dto = AutentificacionApi.validarCredenciales(curp ,contrasena);
        //transforma dto en modelo
        Usuario usuario = convertirDTO(dto);
        //guarda sesion
        Sesion sesion = new Sesion(usuario ,dto.token);
        return usuario;
    }

    private Usuario convertirDTO(IniciarSesionDTO dto) {
        Usuario u = new Usuario();
        u.setCurp(dto.curp);
        u.setRool(dto.rol);
        return u;
    }
}
