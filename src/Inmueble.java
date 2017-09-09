
import java.math.BigDecimal;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public abstract class Inmueble {
    
    private String codigoNacional;
    private String direccion;
    private double area;
    private BigDecimal valorComercial;
    private int estrato;
    private TipoInmuebleEnum tipo;

    
   
    //metodo abstracto
    public abstract BigDecimal calcularImpuesto();
    
    
    @Override
    public String toString() {
        return "Inmueble{" + "codigoNacional=" + codigoNacional + ", direccion=" + direccion + ", area=" + area + ", valorComercial=" + valorComercial + ", estrato=" + estrato + ", tipo=" + tipo + '}';
    }

    
    public Inmueble(String codigoNacional, String direccion, double area, BigDecimal valorComercial, int estrato, TipoInmuebleEnum tipo) {
        this.codigoNacional = codigoNacional;
        this.direccion = direccion;
        this.area = area;
        this.valorComercial = valorComercial;
        this.estrato = estrato;
        this.tipo = tipo;
    }

  
    
    
    public TipoInmuebleEnum getTipo() {
        return tipo;
    }
    
  
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.codigoNacional);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inmueble other = (Inmueble) obj;
        if (!Objects.equals(this.codigoNacional, other.codigoNacional)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
    
    
    public String getCodigoNacional() {
        return codigoNacional;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getArea() {
        return area;
    }

    public BigDecimal getValorComercial() {
        return valorComercial;
    }

    public int getEstrato() {
        return estrato;
    }
    
    
    
    
    
    
}
