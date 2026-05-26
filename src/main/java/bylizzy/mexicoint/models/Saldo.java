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
public class Saldo {

    private BigDecimal actual;
    private BigDecimal limite;

    public Saldo() {
    }

    public BigDecimal getActual() {
        return actual;
    }

    public void setActual(BigDecimal actual) {
        this.actual = actual;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "Saldo{" + "actual=" + actual + ", limite=" + limite + '}';
    }
    

}
