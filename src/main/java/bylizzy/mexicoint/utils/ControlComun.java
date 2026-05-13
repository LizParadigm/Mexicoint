/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import java.util.function.Predicate;
import javafx.scene.Node;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author La rana
 */
public class ControlComun {

    private int paso;

    public ControlComun() {
        this.paso = 1;
    }

    public void siguientePaso() {
        paso += 1;
    }

    public void cambiarVisibilidad(Node elemento ,boolean estado) {
        //visibilidad
        elemento.setVisible(estado);
        //prenencia en fxml
        elemento.setManaged(estado);
    }

    public static TextFormatter<String> crearFormato(Predicate<String> validacion ,boolean mayusculas) {
        return new TextFormatter<>(change -> {
            String texto = change.getControlNewText();

            if (validacion.test(texto)) {

                if (mayusculas) {
                    change.setText(change.getText().toUpperCase());
                }

                return change;
            }
            return null;
        });
    }

    public int getPaso() {
        return paso;
    }

}
