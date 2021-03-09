package ejercicio.hilos.primos;

import java.util.Date;

public class HilosThread extends Thread {

	private int num;
	private String tipoHilo;

	public HilosThread(int num) {
		this.num = num;
	}

	long tiempoInicial;

	@Override
	public void run() {
		Date date = new Date();
		tiempoInicial = date.getTime();
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != num)) {
			if (num % contador == 0) {
				primo = false;
			}
			contador++;
		}
		if (primo) {
			System.out.println("El numero " + num + " es primo");
		} else {
			System.out.println("El numero " + num + " no es primo cruck");
		}
		syso();
	}

	public void syso() {
		Date date = new Date();
		long tiempoFinal = date.getTime();
		long tiempoEjecucion = tiempoFinal - tiempoInicial;
		System.out.println("El tiempo es: " + + tiempoEjecucion);

	}

}
