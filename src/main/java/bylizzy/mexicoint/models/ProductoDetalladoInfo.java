/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import bylizzy.mexicoint.models.deserializers.productoDetalladoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 *
 * @author La rana
 */

@JsonDeserialize(
        using= productoDetalladoDeserializer.class
)

public class ProductoDetalladoInfo {

    private String tipo;
    private String colorPrincipal;
    private String colorSecundario;

    public ProductoDetalladoInfo() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    @Override
    public String toString() {
        return "ProductoDetalladoInfo{" + "tipo=" + tipo + ", colorPrincipal=" + colorPrincipal + ", colorSecundario=" + colorSecundario + '}';
    }

    
}
