/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import java.util.List;

/**
 *
 * @author La rana
 */
public class SolicitarProductosPoseidosResponseDTO {

    private boolean estado;
    private String mensaje;
    private List<ProductoDTO> lista;

    public SolicitarProductosPoseidosResponseDTO() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<ProductoDTO> getLista() {
        return lista;
    }

    public void setLista(List<ProductoDTO> lista) {
        this.lista = lista;
    }

    
}
