/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.dto.autentificacion.AutentificacionApi;
import bylizzy.mexicoint.data.dto.autentificacion.CambiarContrasenaResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCodigoResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCurpResponseDTO;
import bylizzy.mexicoint.utils.ControlComun;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;

/**
 *
 * @author La rana
 */
public class RecuperarCuentaService extends ControlComun {

    private String instruccion;

    public AutentificacionApi servidor = new AutentificacionApi();

    public RecuperarCuentaService() {
        this.instruccion = "";
    }

    public Validacion validarCurp(String curp) throws InterruptedException {
        ComprobarCurpResponseDTO dto = servidor.comprobarCurp(curp);
        if (dto != null) {
            return new Validacion(true ,"");
        } else {
            return new Validacion(dto.isEstado() ,dto.getMensaje());
        }
    }

    public Validacion validarCodigo(String codigo) throws InterruptedException {
        ComprobarCodigoResponseDTO dto = servidor.comprobarCodigo(codigo);

        if (dto != null) {
            return new Validacion(true ,"");
        } else {
            return new Validacion(dto.isEstado() ,dto.getMensaje());
        }

    }

    public Validacion cambiarContrasena(String curp ,String codigo ,String contrasenaNueva) throws InterruptedException {
        CambiarContrasenaResponseDTO dto = servidor.cambiarContrasena(curp ,codigo ,contrasenaNueva);
        if (dto != null) {
            return new Validacion(true ,"");
        } else {
            return new Validacion(dto.isEstado() ,dto.getMensaje());
        }
    }

    public String instrucciones() {
        switch (getPaso()) {
            case 1:
                instruccion = "Escriba el correo asociado a su cuenta y de click en Continuar, recibirá un correo electrónico.";
                break;
            case 2:
                instruccion = "Escriba el código que le hemos enviado a su correo electrónico.";
                break;
            case 3:
                instruccion = "Escriba su nueva contraseña y vuelva a hacerlo para confirmarla, luego dele en “Ingresar” para terminar el proceso de recuperación.";
                break;
        }
        return null;
    }

    public String getInstruccion() {
        return instruccion;
    }

}
