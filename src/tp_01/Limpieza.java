package tp_01;

public abstract class Limpieza extends Producto {
	
	protected enum TipoDeAplicacion{
		Cocina,
		Pisos,
		Ropa,
		Multiuso
		
	}
	
	String tipoDeAplicacion;
	
	public String toString() {
		return "Id: " + Id
	        + ",Tipo de envase: " + getTipoDeAplicacion() + "\n"
            + ", Descripcion: " + descripcion
    		+ ", stock: " + stockDisponible
            + ", Precio De Venta: " + precioVenta
            + ", Precio De Compra:" + precioCompra
            + ", Descuento:"+ descuento
            + ", Porcentaje ganancia: " + porcentajeDeGanancia
            + ", Disponible Para Venta: " + disponibleParaVenta;
            
    }
	
	public Limpieza(String Id, String tipoDeAplicacion, String descripcion, int stockDisponible, double precioVenta, double precioCompra, double descuento, double porcentajeDeGanancia, boolean disponibleParaVenta) {
        super(Id, descripcion, stockDisponible, precioVenta, precioCompra, descuento, porcentajeDeGanancia, disponibleParaVenta);
        
        this.tipoDeAplicacion = tipoDeAplicacion;
     
    }
	
	public TipoDeAplicacion TipoDeAplicacion;
	
	public TipoDeAplicacion getTipoDeAplicacion(){
		return TipoDeAplicacion;
	}
    
    public String getId() { return Id; }
	
	public void setId(String Id) {
		 if (Id.matches("AZ\\d{3}")) {
	            this.Id = Id;
	        } else {
	            throw new IllegalArgumentException("El id tiene que tener un formato AzXXX, donde XXX son dígitos numéricos.");
	        }
	   }
	
	public void setPorcentajeDeGanancia(double porcentajeDeGanancia, TipoDeAplicacion tipoDeAplicacion) {
	    if((tipoDeAplicacion == TipoDeAplicacion.Cocina || tipoDeAplicacion == TipoDeAplicacion.Pisos) && (porcentajeDeGanancia >= 10 && porcentajeDeGanancia <= 25)) {
	    	this.porcentajeDeGanancia = porcentajeDeGanancia;
	    }else {
		 if((tipoDeAplicacion == TipoDeAplicacion.Ropa || tipoDeAplicacion == TipoDeAplicacion.Multiuso) && (porcentajeDeGanancia >= 10 && porcentajeDeGanancia <= 25)) {
		    this.porcentajeDeGanancia = porcentajeDeGanancia;
	    }
	  }
	}
    
	
	 public void setDescuento(double descuento) {
			if(descuento <= 25 ) {
			   this.descuento = descuento;
		 }else {
			 System.out.println("El descuento de limpieza no puede superar el 25%"); 
		   }
		}
	    
	 public double getDescuento() {
			return descuento;
	}
	 
	 
}
