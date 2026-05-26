/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.models.Movimientos;
import bylizzy.mexicoint.models.MovimientosProducto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author La rana
 */
public class MovimientosProductoResponseDTO {

    private int id;
    private List<MovimientosResponseDTO> movimientos;

    public MovimientosProductoResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovimientosResponseDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<MovimientosResponseDTO> movimientos) {
        this.movimientos = movimientos;
    }

    public MovimientosProducto toModel() throws JsonProcessingException {
        MovimientosProducto model = new MovimientosProducto();

        model.setId(this.id);

        List<Movimientos> movimientos = new ArrayList<>();
        for (MovimientosResponseDTO m : this.getMovimientos()) {
            Movimientos movimiento = m.toModel();
            movimientos.add(movimiento);
        }

        model.setMovimientos(movimientos);

        return model;
    }
}
