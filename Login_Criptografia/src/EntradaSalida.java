import java.util.Scanner;

public class EntradaSalida {

	public static final int ALTA_USUARIO = 1;
	public static final int LOGIN_USUARIO = 2;
	public static final int SALIR = 0;
	public static boolean condicion = true;

	public static void esperar() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Fallo de espera");
		}
	}

	public static int mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("MENU:");
		System.out.println(ALTA_USUARIO + "-ALTA USUARIO");
		System.out.println(LOGIN_USUARIO + "-LOGIN USUARIO");
		System.out.println(SALIR + "-SALIR");
		System.out.println("");
		System.out.println("Introduce un numero para realizar la función correspondiente:");
		int num = 0;
		try {
			num = sc.nextInt();
			if (num > 2) {
				System.out.println("//Introduce unicamente valores entre 1 y 5//");
			}
		} catch (Exception e) {
			System.out.println("//Introduce unicamente numeros//");
			num = 5;
		}
		return num;
	}

	public static String fin() {
		String mensaje = "//Ha salido del sistema//";

		return mensaje;
	}

	public static String altaUsuario(Scanner sc, int opcion) {

		String username = "";
		switch (opcion) {
		case 1:
			System.out.println("ALTA USUARIO:");
			System.out.println("");
			break;

		case 2:
			System.out.println("LOG IN USUARIO:");
			System.out.println("");
			break;
		}
		
		System.out.println("Introduce nombre de usuario:\n");
		username = sc.nextLine();

		return username;
	}

	public static String altaPassword(Scanner sc) {

		String password = "";
		System.out.println("Introduce password:\n");
		password = sc.nextLine();

		return password;
	}

	public static void mensajeLogin(boolean condicion) {
		String mensajeConf = "";
		EntradaSalida.condicion = condicion;
		if (condicion) {
			System.out.println("//Datos introducidos correctamente//");
			
			System.out.println("Entrando al sistema...");
			esperar();
			System.out.println("REGISTRADO");
			
		} else {
			System.out.println("//ERROR. Datos no encontrados//");
		}
	}

	public static void mensajeAltaUsuario(boolean condicion) {
		String mensajeConf = "";
		EntradaSalida.condicion = condicion;
		if (condicion) {
			System.out.println("//Datos introducidos correctamente...//");
		} else {
			System.out.println("//ERROR. Datos no introducidos//");
		}
	}

}
