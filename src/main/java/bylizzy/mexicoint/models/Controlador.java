/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import java.util.function.Predicate;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.control.TableView;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.util.Duration;

/**
 *
 * @author La rana
 */
public class Controlador {

    public void cambiarVisibilidad(Node nodo ,boolean estado) {
        nodo.setVisible(estado);
        nodo.setManaged(estado);
    }

    public static TextFormatter<String> darFormato(Predicate<String> validacion ,boolean mayusculas) {
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

    public void cambiarClaseCSS(Node nodo) {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(200) ,nodo);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e -> {

            nodo.setOpacity(0);
            FadeTransition fadeIn = new FadeTransition(Duration.millis(200) ,nodo);
            fadeIn.setFromValue(0);

            fadeIn.setToValue(1);

            fadeIn.play();
        });

        fadeOut.play();

    }

    public void ajustarAlturaTabla(TableView tabla ,int numFilas) {
        double altoCabecera = 27;
        double altoFila = 24;
        double altura = altoCabecera + (altoFila * numFilas);
        tabla.setFixedCellSize(altoFila);
        tabla.setPrefHeight(altura);
        tabla.setMinHeight(altura);
        tabla.setMaxHeight(altura);

    }

    public void portapapelesCopiar(String texto) {
        Clipboard clipboard = Clipboard.getSystemClipboard();

        ClipboardContent content = new ClipboardContent();
        content.putString(texto);

        clipboard.setContent(content);
    }

}
