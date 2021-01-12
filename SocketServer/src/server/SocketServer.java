package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACI�N DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		//Este objeto es el que abrir� un puerto
		//Este objeto se encargara de crear el objeto Socket cuando le llegue una petici�n
		ServerSocket servidorSocket = null;
		//El objeto Socket sera el tubo o carretera por el que circulara la informaci�n
		Socket socketConexion = null;
		//Tambiebn necesitamos de unos objetos que trabajen con la informaci�n de entrada y de salida
		PrintStream salida = null;
		InputStreamReader entrada = null;		
		
		try {
			servidorSocket = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			//decimos al socket que escuche peticiones desde la IP y el puerto
			servidorSocket.bind(direccion);
			
			//estamos continuamente escuchando 
			while(true){
				System.out.println("SERVIDOR: Esperando peticion...");
				//Cuando la conexion es establecida, se crea un socket en 
				//para llevar la comunicacion
				socketConexion = servidorSocket.accept();//Se parar� el programa, hasta que entre la peticion de un cliente
													//Y se crear un objeto Socket
				entrada = new InputStreamReader(socketConexion.getInputStream());
				//este InputStreamReader permite leer caracter a caracter
				BufferedReader bf = new BufferedReader(entrada);
				//este BufferedReader permite leer frase a frase
				
				//El servidor se quedar�a aqu� parado hasta que el cliente escriba algo
				String stringRecibido = bf.readLine();//"3-4"
				//MUY IMPORTANTE, la informacion siempre llega en formato STRING
				//TODO LO QUE LLEGA DEL CLIENTE Y LO QUE LE MANDE AL SERVIDOR SON STRING
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split(";");
				int iNumero1 = Integer.parseInt(operadores[0]);//3
				int iNumero2 = Integer.parseInt(operadores[1]);//4
				String iSimboloOperacion = operadores[2];
				int resultado = 0;
				switch (iSimboloOperacion) {
				case "-":
					resultado = iNumero1 - iNumero2;//7 
					break;
				case "+":
					resultado = iNumero1 + iNumero2;//7 
					break;
				case "*":
					resultado = iNumero1 * iNumero2;//7 
					break;
				case "/":
					resultado = iNumero1 / iNumero2;//7 
					break;
				default:
					break;
				}
				
				//Thread.sleep(10000);//simulamos que tardamos un tiempo en calcular
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println(resultado);
				
			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		}finally {//ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
