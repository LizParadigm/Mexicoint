package bylizzy.mexicoint.data.dto.cliente;

import java.math.BigDecimal;

public class SaldoResponseDTO {
    private BigDecimal actual;
    private BigDecimal limite;

    public SaldoResponseDTO() {
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
    
    
}
