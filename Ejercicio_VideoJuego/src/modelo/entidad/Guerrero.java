package modelo.entidad;

public class Guerrero extends Personaje{

	private int fuerza;
	
	@Override
	public void atacar(Personaje p) {
		int da�oTotal = 0;
		if(this.getArma() instanceof Espada || 
				this.getArma() instanceof Arco) {
			da�oTotal = getArma().usar() + fuerza;
		}else {
			da�oTotal = getArma().usar();
		}
		
		da�oTotal += getNivel() * 2;
		System.out.println("Guerrero hace " + da�oTotal);
		p.setPuntosVida(p.getPuntosVida() - da�oTotal);	
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}
	
	
	
}
