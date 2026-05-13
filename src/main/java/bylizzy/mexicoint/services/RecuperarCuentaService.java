/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.utils.ControlComun;

/**
 *
 * @author La rana
 */
public class RecuperarCuentaService extends ControlComun{

    private String instruccion;

    public RecuperarCuentaService() {
        this.instruccion = "";
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
