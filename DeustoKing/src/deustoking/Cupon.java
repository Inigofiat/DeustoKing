package deustoking;

public class Cupon {
	private int minPuntos;
	private double descuento;
	private String foto;
	private String descripcion;
	
	public Cupon(int minPuntos, double descuento, String foto, String descripcion) {
		super();
		this.minPuntos = minPuntos;
		this.descuento = descuento;
		this.foto = foto;
		this.descripcion = descripcion;
	}
	
	public int getMinPuntos() {
		return minPuntos;
	}
	public void setMinPuntos(int minPuntos) {
		this.minPuntos = minPuntos;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Cupon [minPuntos=" + minPuntos + ", descuento=" + descuento + ", foto=" + foto + ", descripción="
				+ descripcion + "]";
	}
	
}
