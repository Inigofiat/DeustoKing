package deustoking;

public class Cupon {
	private int minPuntos;
	private double descuento;
	private String foto;
	private String descripción;
	
	public Cupon() {
		super();
	}
	
	public Cupon(int minPuntos, double descuento, String foto, String descripción) {
		super();
		this.minPuntos = minPuntos;
		this.descuento = descuento;
		this.foto = foto;
		this.descripción = descripción;
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
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	
	@Override
	public String toString() {
		return "Cupon [minPuntos=" + minPuntos + ", descuento=" + descuento + ", foto=" + foto + ", descripción="
				+ descripción + "]";
	}
	
}
