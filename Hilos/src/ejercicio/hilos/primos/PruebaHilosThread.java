package ejercicio.hilos.primos;

import java.util.Date;
import java.util.Scanner;

public class PruebaHilosThread {
	
	public static int num1;
	public static int num2;
	public static int num3;

	public static void main(String[] args) {


		
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un numero");
		num1 = sc.nextInt();

		System.out.println("Introduce el segundo numero");
		num2 = sc.nextInt();

		System.out.println("Introduce el tercer numero");
		num3 = sc.nextInt();
		
		HilosThread hilo1 = new HilosThread(num1);
		hilo1.setName("hilo1");

		HilosThread hilo2 = new HilosThread(num2);
		hilo2.setName("hilo2");

		HilosThread hilo3 = new HilosThread(num3);
		hilo3.setName("hilo3");
		
		Date date = new Date();
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		
	}
}
