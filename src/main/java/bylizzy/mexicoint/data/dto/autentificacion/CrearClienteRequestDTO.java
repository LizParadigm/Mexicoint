/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.autentificacion;

/**
 *
 * @author La rana
 */
public class CrearClienteRequestDTO {

    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private String fecha_nacimiento;
    private String curp;
    //datos direccion
    private String calle;
    private String num_ext;
    private String num_int;
    private String colonia_barrio;
    private String codigo_postal;
    private String ciudad_municipio;
    private String estado;
    private String pais;
    //datos privados
    private String contrasena;

    public CrearClienteRequestDTO(String nombre ,String apellido_p ,String apellido_m ,String fecha_nacimiento ,String curp ,String calle ,String num_ext ,String num_int ,String colonia_barrio ,String codigo_postal ,String ciudad_municipio ,String estado ,String pais ,String contrasena) {
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.fecha_nacimiento = fecha_nacimiento;
        this.curp = curp;
        this.calle = calle;
        this.num_ext = num_ext;
        this.num_int = num_int;
        this.colonia_barrio = colonia_barrio;
        this.codigo_postal = codigo_postal;
        this.ciudad_municipio = ciudad_municipio;
        this.estado = estado;
        this.pais = pais;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNum_ext() {
        return num_ext;
    }

    public void setNum_ext(String num_ext) {
        this.num_ext = num_ext;
    }

    public String getNum_int() {
        return num_int;
    }

    public void setNum_int(String num_int) {
        this.num_int = num_int;
    }

    public String getColonia_barrio() {
        return colonia_barrio;
    }

    public void setColonia_barrio(String colonia_barrio) {
        this.colonia_barrio = colonia_barrio;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getCiudad_municipio() {
        return ciudad_municipio;
    }

    public void setCiudad_municipio(String ciudad_municipio) {
        this.ciudad_municipio = ciudad_municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    

}
