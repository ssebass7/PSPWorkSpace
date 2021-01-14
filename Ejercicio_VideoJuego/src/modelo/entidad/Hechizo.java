package modelo.entidad;

public class Hechizo extends Arma{

	private int procentajeMagiaCaotica;
	
	@Override
	public int usar() {
		int da�oGeneral = super.usar();
		int numeroAleatorio = Util.generadorNumeros(1, 100);
		if(numeroAleatorio <= procentajeMagiaCaotica) {
			System.out.println("MAGIA CAOTICA!!");
			da�oGeneral = da�oGeneral * 2;
		}
		
		return da�oGeneral;
	}

	public int getProcentajeMagiaCaotica() {
		return procentajeMagiaCaotica;
	}

	public void setProcentajeMagiaCaotica(int procentajeMagiaCaotica) {
		this.procentajeMagiaCaotica = procentajeMagiaCaotica;
	}

	
}
