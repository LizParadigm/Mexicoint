/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

/**
 *
 * @author La rana
 */
public class RecuperarCuentaService {

    private int paso;
    private String instruccion;

    public RecuperarCuentaService() {
        this.paso = 1;
        this.instruccion = "";
    }

    public void siguientePaso() {
        paso = paso + 1;
    }

    public String instrucciones() {
        switch (paso) {
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

    public int getPaso() {
        return paso;
    }

    public String getInstruccion() {
        return instruccion;
    }
    
    


}
