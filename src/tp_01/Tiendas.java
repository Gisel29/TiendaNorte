package tp_01;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Tiendas {
	
	String nombreDeLaTienda;
	int MaximoStock;
	double SaldoEnCaja;
	int TotalDeProductos;
	Map<String, List<Producto>> stock;
	
    List<Producto> ListaDeProductos = new ArrayList<>();

	public Tiendas(String nombreDeLaTienda, int MaximoStock, double SaldoEnCaja ) {

	        this.nombreDeLaTienda = nombreDeLaTienda;
	        this.MaximoStock = MaximoStock;
	        this.SaldoEnCaja = SaldoEnCaja;
	        this.TotalDeProductos = 0;
	        this.stock = new HashMap<>();
	        this.stock.put("Envasados", new ArrayList<>()); 
	        this.stock.put("Limpieza", new ArrayList<>()); 
	        this.stock.put("Bebidas", new ArrayList<>());
    }
	
	public String toString() {
		return  "nombreDeLaTienda: " + nombreDeLaTienda
		         + ", Stock Maximo: " + MaximoStock
		         + ", Saldo en Caja: " + SaldoEnCaja
                 +", Stock de productos: " + stock;
     }

	
	public int getTotalDeProductos() {
		int cantidad = 0;
		for (List<Producto> listaProductos : this.stock.values()) {
			cantidad += listaProductos.size();
		}
		return cantidad;
	}
	
	public String getNombreDeLaTienda() {
		return nombreDeLaTienda;
	}

	public void setNombreDeLaTienda(String nombreDeLaTienda) {
		this.nombreDeLaTienda = nombreDeLaTienda;
	}

	public int getMaximoStock() {
		return MaximoStock;
	}

	public void setMaximoStock(int maximoStock) {
		MaximoStock = maximoStock;
	}

	public double getSaldoEnCaja() {
		return SaldoEnCaja;
	}

	public void setSaldoEnCaja(double saldoEnCaja) {
		SaldoEnCaja = saldoEnCaja;
	}

	public Map<String, List<Producto>> getStock() {
		return stock;
	}

	public void setStock(Map<String, List<Producto>> stock) {
		this.stock = stock;
	}
	
	public int cantidadRestanteEnCaja(Producto producto) {
		return (int) (this.SaldoEnCaja - producto.getPrecioCompra() * producto.getStockDisponible());
	}
	
	public int cantidadRestanteDeProducto() {
	  return this.MaximoStock - this.TotalDeProductos;
	}
	

	public double costoTotalDelProducto(Producto producto, int cantidad) {
	  return producto.getPrecioVenta() * cantidad;
   }
	
	
	public String comprarProducto (Producto producto, int cantidad) {
		
		if(this.cantidadRestanteEnCaja(producto) < 0) {
			System.out.println( "Tiene saldo insuficiente en la caja para comprar");
		 }
		
        if (this.TotalDeProductos + cantidad > this.MaximoStock) {
			  
			System.out.println("Solo se pueden agregar '" + this.cantidadRestanteDeProducto() + "' productos de '"
					+ producto.getNombreDelProducto() + "' porque no hay espacio para almacenar el producto.");
			
			 cantidad = this.cantidadRestanteDeProducto();
        }
    	

        if (producto.cumpleSetPorcentajeDeGanancia()) {
        	System.out.println( "Este producto no cumple con el porcentaje de ganancia: " + producto.getId());
        }
        
        if (producto.getPrecioVenta() + (producto.getPrecioVenta() * producto.getDescuento() / 100) < producto.getPrecioCompra()) {
        	System.out.println( "el precio de venta supera el precio de compra");
        }

        ListaDeProductos.add(producto);
		
		return "La compra se realizo correctamente";
	
		
	}
		
		
	int cantProductoEnvasado = 0;
	int cantProductoBebidas = 0;
	int cantProductoLimpieza = 0;
	
	
	public String venderProductos(String nombre, int cantidad, Producto producto) {
		
		boolean encontroCoincidencia = false;
		nombre = nombre.toLowerCase();

		
		for (Map.Entry<String, List<Producto>> entry : this.stock.entrySet()) {

			String nombreDelProducto = entry.getKey().toLowerCase();

			if (nombreDelProducto.equals(nombre)) {
				encontroCoincidencia = true;
				
				switch (nombreDelProducto) {
			    case "Envasado":
			    	if (cantProductoEnvasado < 3) {
			    		cantProductoEnvasado++;

			    	} else {
			            System.out.println("No se pueden agregar más productos envasados");
			        }
			        break;
			    case "Bebidas":
			        if (cantProductoBebidas < 3) {
			        	cantProductoBebidas++;
			        } else {
			            System.out.println("No se pueden agregar más bebidas");
			        }
			        break;
			    case "Limpieza":
			    	if (cantProductoLimpieza < 3) {
			    		cantProductoLimpieza++;
			        } else {
			            System.out.println("No se pueden vender más productos de limpieza");
			            
			        }
			        break;
			}


	    	if (stock.size() > 3 || stock.size() == 0) {
	    		System.out.println( "No puede comprar, el Máximo de compra es de 3 productos / Mínimo de compra 1 producto");
	    	}

	    	if (!encontroCoincidencia) {
				System.out.println("No se reconoce el producto ingresado. " + "\n" + "Los Tipos de productos validos son: "
						+ "\n" + "*Limpieza *Bebidas *envasados");
			
			}
	    	
	    	if (cantidad > 10 && cantProductoEnvasado <= 3 && cantProductoBebidas <= 3 && cantProductoLimpieza <= 3 ) {
 
	            System.out.println("Solo esta permitido comprar el maximo stock de 10");
	            
	        }
	    	
	    }
		
	  }
		return "Venta concretada";
  }
}

		
	