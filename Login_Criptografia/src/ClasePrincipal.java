import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Scanner;

public class ClasePrincipal {

	public static String usernameHashBase64;
	public static String passwordHashBase64;

	public static void main(String[] args) throws NoSuchAlgorithmException {

		EntradaSalida entradaSalida = new EntradaSalida();
		BDD baseDatos = new BDD();
		ClasePrincipal clasePrincipal = new ClasePrincipal();
		Statement stmt = baseDatos.crearConexion();
		
		int opcion = entradaSalida.mostrarMenu();
		
		while (opcion != entradaSalida.SALIR) {
			entradaSalida.esperar();

			switch (opcion) {

			case EntradaSalida.ALTA_USUARIO:
				Scanner sc = new Scanner(System.in);
				String username = "";
				String password = "";
				username = entradaSalida.altaUsuario(sc, entradaSalida.ALTA_USUARIO);
				password = entradaSalida.altaPassword(sc);

				clasePrincipal.pasarAHash(username, password);

				boolean condicion = baseDatos.introducirDatos(usernameHashBase64, passwordHashBase64);

				entradaSalida.mensajeAltaUsuario(condicion);

				break;
			case EntradaSalida.LOGIN_USUARIO:
				
				sc = new Scanner(System.in);
				username = entradaSalida.altaUsuario(sc,entradaSalida.LOGIN_USUARIO);
				password = entradaSalida.altaPassword(sc);
				clasePrincipal.pasarAHash(username, password);
				condicion = baseDatos.compararUsuarioPassword(usernameHashBase64, passwordHashBase64);
				
				entradaSalida.mensajeLogin(condicion);
				break;
			case EntradaSalida.SALIR:

				break;
			}
			System.out.println("espera...");
			entradaSalida.esperar();
			opcion = entradaSalida.mostrarMenu();
		}

		System.out.println("Cargando...");
		entradaSalida.esperar();
		System.out.println(entradaSalida.fin());
	}

	public void pasarAHash(String username, String password) {
		byte[] usernameHash = username.getBytes();
		byte[] passwordHash = password.getBytes();

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(usernameHash);
			byte[] resumenUsername = md.digest();
			usernameHashBase64 = Base64.getEncoder().encodeToString(resumenUsername);
			md.reset();

			md.update(passwordHash);
			byte[] resumenPassword = md.digest();
			passwordHashBase64 = Base64.getEncoder().encodeToString(resumenUsername);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
