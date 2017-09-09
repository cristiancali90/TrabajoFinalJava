
import java.math.BigDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Lote extends Inmueble{

    public Lote(String codigoNacional, String direccion, double area, BigDecimal valorComercial, int estrato, TipoInmuebleEnum tipo) {
        super(codigoNacional, direccion, area, valorComercial, estrato, tipo);
    }

    @Override
    public BigDecimal calcularImpuesto() {
        
        BigDecimal area= new BigDecimal(super.getArea());
        BigDecimal valorComercial= this.getValorComercial();  
        BigDecimal resultado;
        resultado = area.multiply(valorComercial);
        
        return resultado;
    }
    
}
