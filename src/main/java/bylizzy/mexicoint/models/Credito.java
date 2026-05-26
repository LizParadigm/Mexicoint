/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bylizzy.mexicoint.models;

import java.math.BigDecimal;

/**
 *
 * @author La rana
 */
public class Credito {

    private BigDecimal limite;
    private BigDecimal disponible;
    private BigDecimal deuda;
    private String fechaPago;
    private String fechaCorte;

    public Credito() {
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    public BigDecimal getDisponible() {
        return disponible;
    }

    public void setDisponible(BigDecimal disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getDeuda() {
        return deuda;
    }

    public void setDeuda(BigDecimal deuda) {
        this.deuda = deuda;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public String toString() {
        return "Credito{" + "limite=" + limite + ", disponible=" + disponible + ", deuda=" + deuda + ", fechaPago=" + fechaPago + ", fechaCorte=" + fechaCorte + '}';
    }

    

}
