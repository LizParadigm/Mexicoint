/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.services;

import bylizzy.mexicoint.models.Estado;
import bylizzy.mexicoint.models.Pais;
import bylizzy.mexicoint.utils.CatalogoUbicacionesService;
import bylizzy.mexicoint.utils.ControlComun;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

/**
 *
 * @author La rana
 */
public class RegistrarService extends ControlComun  {

    //datos del paso 1
    private Node nombre;
    private Node apellidoPaterno;
    private Node apellidoMaterno;
    private Node dia;
    private Node mes;
    private Node ano;
    private Node curp;
    //datos del paso 2
    //datos del paso 3

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
