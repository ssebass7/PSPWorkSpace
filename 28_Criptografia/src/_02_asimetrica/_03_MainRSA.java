package _02_asimetrica;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

/*
 * En este apartado estudiaremos el algoritmo RSA, 
 * Desarrollado por Ron Rivest, Adi Shamir y Leonard Adleman 
 * cuyas iniciales dieron nombre al algoritmo. 
 * 
 *  La clave privada, que es distinta para cada usuario. 

    La clave p�blica, que es la misma para todos los usuarios.

	El procedimiento empleado para el cifrado es el siguiente:

    Un proceso que desea enviar un mensaje utiliza la clave p�blica 
    (conocida por todos los procesos) para cifrar el mensaje.

    El proceso destinatario del mensaje podr� descifrarlo utilizando la 
    clave privada, que solo �l conoce, asegurando as� la confidencialidad.

    La clave privada es generada a partir de la clave p�blica, 
    de modo que ambas est�n relacionadas.
 */
public class _03_MainRSA {
	public static void main(String[] args) {
		try {
			//En vez de KeyGenerator usamos KeyPairGenerator
			KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Obtenemos el par de claves (publica y privada)
			KeyPair claves = generador.generateKeyPair();
			System.out.println("Paso 2: Se ha obtenido el par de claves");
			
			Cipher cifrador = Cipher.getInstance("RSA");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			cifrador.init(Cipher.ENCRYPT_MODE, claves.getPublic());
			System.out.println(claves.getPublic().getClass().getName());
			System.out.println("Paso 4: Hemos configurado el descifrador para usar clave publica");
			
			String mensajeOriginal = "La cripta m�gica";
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			//ciframos el mensaje
			byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Paso 5: Hemos preparado y cifrado el mensaje original");
			System.out.println("Mensaje Original: " + mensajeOriginal);
			System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("AHORA VAMOS A DESCIFRAR EL MENSAJE CIFRADO USANDO LA CLAVE PRIVADA");
			cifrador.init(Cipher.DECRYPT_MODE, claves.getPrivate());
			byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
			
		} catch (GeneralSecurityException e) {
			System.out.println("Error al cifrar o descifrar el mensaje");
			System.out.println("Excepci�n de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
