/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.autentificacion;

/**
 *
 * @author La rana
 */
public class CambiarContrasenaRequestDTO {
    private String curp;
    private String codigo;
    private String contrasena;

    public CambiarContrasenaRequestDTO(String curp ,String codigo ,String contrasena) {
        this.curp = curp;
        this.codigo = codigo;
        this.contrasena = contrasena;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
