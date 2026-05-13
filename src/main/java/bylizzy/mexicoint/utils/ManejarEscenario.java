/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author La rana
 */
public class ManejarEscenario {

    private final Stage escenario;
    private Scene escena;
    private int width = 1212;
    private int height = 700;

    public ManejarEscenario() {
        this.escenario = null;
    }

    public ManejarEscenario(Stage escenario) {
        this.escenario = escenario;
    }

    public Parent cargarFXML(String fxml) throws IOException {
        FXMLLoader cargador = new FXMLLoader(getClass().getResource(fxml));
        return cargador.load();
    }

    public void cambiarVista(String fxml) throws IOException {
        escena.setRoot(cargarFXML(fxml));
    }
    
    public void setEscena(Scene escena){
        this.escena=escena;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
