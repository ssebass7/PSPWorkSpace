package modelo.entidad;

public abstract class Arma {
	private int da�oMinimo;
	private int da�oMaximo;
	private String tipo;
	
	public int usar() {
		int da�oCausado = Util.generadorNumeros(da�oMinimo, da�oMaximo);
		return da�oCausado;
	}
	
	public int getDa�oMinimo() {
		return da�oMinimo;
	}
	public void setDa�oMinimo(int da�oMinimo) {
		this.da�oMinimo = da�oMinimo;
	}
	public int getDa�oMaximo() {
		return da�oMaximo;
	}
	public void setDa�oMaximo(int da�oMaximo) {
		this.da�oMaximo = da�oMaximo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
