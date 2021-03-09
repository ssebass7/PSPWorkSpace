
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

public class BDD {

	public static Statement crearConexion() {
		Statement stmt = null;
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			stmt = c.createStatement();
			System.out.println("conexion realizada");
		} catch (SQLException e) {
			System.out.println("conexion no ejecutada");
			e.printStackTrace();

		}
		;
		return stmt;
	}

	public boolean compararUsuarioPassword(String hashUsuarioIntroducido, String hashpasswordIntroducido) {
		Statement stmt = crearConexion();
		String query = "SELECT * FROM usuarios";
		boolean condicion = true;
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {

				String nombre = resultados.getString("username");
				String password = resultados.getString("password");
				if (hashUsuarioIntroducido.equals(nombre) && hashpasswordIntroducido.equals(password)) {

					condicion = true;
				} else {
					condicion = false;
				}

			}

		} catch (SQLException e) {
			condicion = false;
			e.printStackTrace();
		}
		return condicion;
	}

	public boolean introducirDatos(String usernameHashBase64, String passwordHashBase64) {

		Statement stmt = crearConexion();
		boolean condicion = true;
		String queryInsert = "INSERT INTO usuarios VALUES('" + usernameHashBase64 + "','" + passwordHashBase64 + "')";
		try {
			stmt.executeUpdate(queryInsert);
			condicion = true;
		} catch (SQLException e) {

			condicion = false;
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return condicion;

	}

}
