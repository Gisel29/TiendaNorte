package tp_01;
import java.time.LocalDate;

public abstract class Producto  {
    
	 String Id;
	 String nombreDelProducto;
	 String descripcion;
	 int stockDisponible;
	 double precioVenta;
	 double precioCompra;
     double descuento;
	 double porcentajeDeGanancia;
	 boolean disponibleParaVenta;
	 LocalDate vencimiento;
	 double calorias;
	
  
  
	
	public String toString() {
	    return "Id: " + Id
	    		+ ", NombreDelProducto: " + nombreDelProducto
	            + ", Descripción: " + descripcion
	            + ", stock: " + stockDisponible
	            + ", Precio De Venta: " + precioVenta
	            + ", PrecioCompra: "+ precioCompra
	            + ", Descuento: " + descuento
	            + ", Porcentaje De Ganancia:" + porcentajeDeGanancia
	            + ", Disponible Para Venta: " + disponibleParaVenta;
	            
	}	
	 
	
	  public Producto(String Id, String descripcion, int stockDisponible, double precioVenta, double precioCompra, double descuento, double porcentajeDeGanancia, boolean disponibleParaVenta) {
	        this.Id = Id;
	        this.descripcion = descripcion;
	        this.stockDisponible = stockDisponible;
	        this.precioVenta = precioVenta;
	        this.precioCompra = precioCompra;
	        this.descuento = descuento;
	        this.porcentajeDeGanancia = porcentajeDeGanancia;
	        this.disponibleParaVenta = disponibleParaVenta;
	  }

public String getId() {
		return Id;
}

public void setId(String id) {
		Id = id;
}

public String getNombreDelProducto() {
	return nombreDelProducto;
}


public void setNombreDelProducto(String nombreDelProducto) {
	this.nombreDelProducto = nombreDelProducto;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


public int getStockDisponible() {
	return stockDisponible;
}


public void setStockDisponible(int stockDisponible) {
	this.stockDisponible = stockDisponible;
}

public void descuentoDeStock(int stockDisponible) {
	this.stockDisponible -= stockDisponible;
}


public void setPrecioVenta(double precioVenta) {
	this.precioVenta = precioVenta;
 }

public double getPrecioVenta() {
	return precioVenta;
}

public double getPrecioCompra() {
	return precioCompra;
}


public void setPrecioCompra(double precioCompra) {
	this.precioCompra = precioCompra;
}


public void setDescuento(double descuento) {
	this.descuento = descuento;
 }

public double getDescuento() {
	return descuento;
}

public void setPorcentajeDeGanancia(double porcentajeGanancia) {
	this.porcentajeDeGanancia = porcentajeGanancia;
}


public double getPorcentajeDeGanancia() {
	return porcentajeDeGanancia;
}

public abstract boolean cumpleSetPorcentajeDeGanancia();

public void setDisponibleParaVenta(boolean disponibleParaVenta) {
	this.disponibleParaVenta = disponibleParaVenta;
}


public boolean isDisponibleParaVenta() {
	return disponibleParaVenta;
}



}



