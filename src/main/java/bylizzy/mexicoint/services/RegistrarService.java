/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.data.dto.autentificacion.AutentificacionApi;
import bylizzy.mexicoint.data.dto.autentificacion.ComprobarCurpResponseDTO;
import bylizzy.mexicoint.data.dto.autentificacion.CrearClienteResponseDTO;
import bylizzy.mexicoint.models.Estado;
import bylizzy.mexicoint.models.Pais;
import bylizzy.mexicoint.utils.CatalogoUbicacionesService;
import bylizzy.mexicoint.utils.ControlComun;
import bylizzy.mexicoint.utils.ValidacionesService.Validacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

/**
 *
 * @author La rana
 */
public class RegistrarService extends ControlComun {

    public AutentificacionApi servidor = new AutentificacionApi();

    public Validacion validarCurp(String curp) throws InterruptedException {
        ComprobarCurpResponseDTO dto = servidor.comprobarCurp(curp);

        //dependiendo del mensaje del api se asignan los valores
        //si sale bien
        if (dto != null) {
            return new Validacion(true ,"");
        } //si la curp existe se muestra el mensaje de respuesta
        else {
            return new Validacion(false ,dto.getMensaje());
        }
    }

    public Validacion crearCliente(String nombre ,String apellido_p ,String apellido_m ,String fecha_nacimiento ,String curp ,String calle ,String num_ext ,String num_int ,String colonia_barrio ,String codigo_postal ,String ciudad_municipio ,String estado ,String pais ,String contrasena) throws IOException ,JsonProcessingException ,InterruptedException {
        CrearClienteResponseDTO dto = servidor.crearCliente(nombre ,apellido_p ,apellido_m ,fecha_nacimiento ,curp ,calle ,num_ext ,num_int ,colonia_barrio ,codigo_postal ,ciudad_municipio ,estado ,pais ,contrasena);

        //dependiendo del mensaje del api se asignan los valores
        //si sale bien
        if (dto != null) {
            return new Validacion(true ,"");
        } //si la curp existe se muestra el mensaje de respuesta
        else {
            return new Validacion(dto.isEstado() ,dto.getMensaje());
        }
    }

    public void configurarPais(ComboBox<Estado> campo_estado ,String pais) {
        configurarPaisDefault(campo_estado);

        Pais configuracion = CatalogoUbicacionesService.estados(pais);

        if (configuracion != null) {
            campo_estado.getItems().addAll(configuracion.getEstados());
        }

    }

    private void configurarPaisDefault(ComboBox<Estado> campo_estado) {
        campo_estado.getItems().clear();
        campo_estado.getItems().add(new Estado("Seleccionar estado"));
        campo_estado.getSelectionModel().selectFirst();

    }

}
