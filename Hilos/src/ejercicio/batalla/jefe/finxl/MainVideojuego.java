package ejercicio.batalla.jefe.finxl;

import java.util.ArrayList;
import java.util.List;

public class MainVideojuego {

	public static void main(String[] args) {
		Personaje p1 = new Guerrero();
		Arma espada = new Espada();
		Personaje p2 = new Healer();
		Arma rezo = new Rezo();
		
		espada.setDañoMaximo(25);
		espada.setDañoMinimo(10);
		
		p1.setNombre("Conan");
		p1.setNivel(3);
		p1.setPuntosVida(150);
		p1.setIniciativa(5);
		p1.setArma(espada);
		
		rezo.setDañoMaximo(20);
		rezo.setDañoMinimo(5);
		
		p2.setNombre("Scooby");
		p2.setNivel(5);
		p2.setPuntosVida(150);
		p2.setIniciativa(4);
		p2.setArma(rezo);
		
		Mago p3 = new Mago();
		Hechizo hechizo = new Hechizo();
		
		hechizo.setDañoMaximo(20);
		hechizo.setDañoMinimo(10);
		hechizo.setProcentajeMagiaCaotica(50);
		
		p3.setNombre("Gandalf");
		p3.setNivel(7);
		p3.setPuntosVida(150);
		p3.setIniciativa(6);
		p3.setArma(hechizo);
		p3.setInteligencia(4);
		
		List<Personaje> listaPersonajes = new ArrayList<Personaje>();
		listaPersonajes.add(p1);
		listaPersonajes.add(p2);
		listaPersonajes.add(p3);
		
		int contrincante1 = Util.generadorNumeros(0, 3);
		int contrincante2 = 0;
		do {
			contrincante2 = Util.generadorNumeros(0, 3);
		}while(contrincante1 == contrincante2);
		
		Personaje luchador1 = listaPersonajes.get(contrincante1);
		Personaje luchador2 = listaPersonajes.get(contrincante2);
		
		Arena arena = new Arena(luchador1, luchador2);
		Personaje pg = arena.combate();
		
		System.out.println("Personaje ganador!!" + pg.getNombre());
		
	}

}
