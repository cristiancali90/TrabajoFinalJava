
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
public class Apartamento extends Inmueble{

    
    
    
    
    public Apartamento(String codigoNacional, String direccion, double area, BigDecimal valorComercial, int estrato, TipoInmuebleEnum tipo) {
        super(codigoNacional, direccion, area, valorComercial, estrato, tipo);
    }

  
    
    @Override
    public BigDecimal calcularImpuesto() {
         BigDecimal area= new BigDecimal(super.getArea());
        BigDecimal valorComercial= this.getValorComercial();
        BigDecimal constante= new BigDecimal(0.8);
        
        BigDecimal resultado;
        resultado = area.multiply(valorComercial).multiply(constante);
        
        return resultado;
    }
    
    
    
}
