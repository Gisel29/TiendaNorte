package tp_01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Bebidas extends Producto implements Comestibles {
      
	double porcentajeAlcohol;
	boolean esImportado;
	
	LocalDate vencimiento;
	Integer calorias;
	
	public String toString() {
	    return "Id: " + Id
	            + ", Descripcion: " + descripcion
	    		+ ", PorcentajeAlcohol: " + porcentajeAlcohol
	    		+ ", esImportado: " + esImportado
	    		+ ", vencimiento: " + vencimiento
	    		+ ", calorias: " + calorias
	    		+ ", stock: " + stockDisponible
	            + ", Precio De Venta: " + precioVenta
	            + ", Precio De Compra: "+ precioCompra
	            + ", Descuento:"+ descuento
	            + ", Porcentaje ganancia: " + porcentajeDeGanancia
                + ", Disponible Para Venta: " + disponibleParaVenta;
	            
	}	
	
	public Bebidas(String Id, String descripcion, double porcentajeAlcohol , boolean esImportado, String vencimiento, int calorias, int stockDisponible, double precioVenta, double precioCompra, double descuento, double porcentajeDeGanancia, boolean disponibleParaVenta) {
        super(Id, descripcion, stockDisponible, precioVenta, precioCompra, descuento, porcentajeDeGanancia, disponibleParaVenta);
        
        this.porcentajeAlcohol = porcentajeAlcohol;
        this.esImportado = esImportado;
        this.vencimiento = LocalDate.parse(vencimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.calorias = calorias;
    }
	
	public String getId() { return Id; }
	
	public void setId(String Id) {
		 if (Id.matches("AC\\d{3}")) {
	            this.Id = Id;
	        } else {
	            throw new IllegalArgumentException("El id tiene que tener un formato ACXXX, donde XXX son dígitos numéricos.");
	        }
		}

	public double getPorcentajeAlcohol() {
		return porcentajeAlcohol;
	}

	public void setPorcentajeAlcohol(double porcentajeAlcohol) {
		this.porcentajeAlcohol = porcentajeAlcohol;
	}
	
	public void setEsImportado(boolean esImportado) {
		this.esImportado = esImportado;
	}

	public boolean isEsImportado() {
		return esImportado;
	}
	
	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}


	public void setPorcentajeDeGanancia(double porcentajeDeGanancia) {
	    if(porcentajeDeGanancia <= 20) {
	    	this.porcentajeDeGanancia = porcentajeDeGanancia;
	    }else {
	    	 System.out.println("No puede superar el 20%");
	    }
	}
	
   public double getPrecioVenta() { 
	   return precioVenta; 
   }
   
   
	@Override
	public void setPrecioVenta(double precioVenta) {
	    
		if(esImportado == true){
			this.precioVenta = precioVenta + (precioVenta + 0.10);
		}else {
			this.precioVenta = precioVenta;
		}
	}	
	
	public void setDescuento(double descuento) {
		if(descuento <= 15 ) {
		   this.descuento = descuento;
	 }else {
		 System.out.println("El descuento de bebidas no puede superar el 15%"); 
	 }
	}				

	public double getDescuento() {
		return descuento;
	}

	
}
