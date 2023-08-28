package tp_01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Envasados extends Producto {
	
	 String tipoDeEnvase;
	 boolean esImportado;
	 
	 LocalDate vencimiento;
	 int calorias;
	    
	protected enum TipoDeEnvase{
		Plastico,
		Vidrio,
		Lata
		
	}
	
	public String toString() {
			return "Id: " + Id
		        + ",Tipo de envase: " + getTipoDeEnvase() + "\n"
	            + ", Descripcion: " + descripcion
	    		+ ", esImportado: " + esImportado
                + ", vencimiento: " + vencimiento
	    		+ ", calorias: " + calorias
	    		+ ", stock: " + stockDisponible
	            + ", Precio De Venta: " + precioVenta
	            + ", Precio De Compra:" + precioCompra
	            + ", Descuento:"+ descuento
	            + ", Porcentaje ganancia: " + porcentajeDeGanancia
                + ", Disponible Para Venta: " + disponibleParaVenta;
	            
	}
    
	public Envasados(String Id, String tipoDeEnvase, String descripcion, boolean esImportado, String vencimiento, int calorias, int stockDisponible, double precioVenta, double precioCompra, double descuento, double porcentajeDeGanancia, boolean disponibleParaVenta) {
        super(Id, descripcion, stockDisponible, precioVenta, precioCompra, descuento, porcentajeDeGanancia, disponibleParaVenta);
        
        this.tipoDeEnvase = tipoDeEnvase;
        this.esImportado = esImportado;
        this.vencimiento = LocalDate.parse(vencimiento, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.calorias = calorias;
    }
	
	public TipoDeEnvase TipoDeEnvase;
	
	public TipoDeEnvase getTipoDeEnvase() {
		return TipoDeEnvase;
	}	
	
    public String getId() { return Id; }
	
	public void setId(String Id) {
		 if (Id.matches("AB\\d{3}")) {
	            this.Id = Id;
	        } else {
	            throw new IllegalArgumentException("El id tiene que tener un formato ABXXX, donde XXX son dígitos numéricos.");
	        }
	   }
	
	
	public boolean isEsImportado() {
	   return esImportado;
     }

    public void setEsImportado(boolean esImportado) {
	   this.esImportado = esImportado;
    }
    
    public LocalDate getVencimiento() {
		return vencimiento;
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
    
    public void setDescuento(double descuento) {
		if(descuento <= 20 ) {
		   this.descuento = descuento;
	 }else {
		 System.out.println("El descuento de los envasados no puede superar el 20%"); 
	   }
	}
    
    public double getDescuento() {
		return descuento;
	}
    
	
}
