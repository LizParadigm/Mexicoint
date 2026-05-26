/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.data.dto.cliente;

import bylizzy.mexicoint.models.Movimientos;
import java.math.BigDecimal;

/**
 *
 * @author La rana
 */
public class MovimientosResponseDTO {
    private int id;
    private String nombre;
    private String fecha;
    private BigDecimal monto;

    public MovimientosResponseDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    public Movimientos toModel(){
        Movimientos model=new Movimientos();

        model.setId(this.getId());
        model.setNombre(this.getNombre());
        model.setFecha(this.getFecha());
        model.setMonto(this.getMonto());
        
        return model;
    }
    
}
