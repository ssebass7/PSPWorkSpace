import java.util.ArrayList;

public class testApp {
	public static void main(String[] args) {
		
		Habitacion hab = new Habitacion(20, "salon", 1);
		Habitacion hab2 = new Habitacion(10, "cocina", 2);
		Habitacion hab3 = new Habitacion(15, "servicio", 3);
		
		Direccion dirinq2 = new Direccion("Calle", "Lisboa", "28963", 5);
		Persona inquilino2 = new Persona("Jose", "54250120A", "916869635", dirinq2);
		
		Direccion dirinq = new Direccion("Calle", "Fortuna", "28953", 7);
		Persona inquilino1 = new Persona("Juan", "54190120A", "916869635", dirinq);
		
		Direccion dirprop = new Direccion("Calle", "Mallorca", "28913", 3);
		Persona propietario = new Persona("Juan", "54190120A", "916869635", dirprop);
		
		Direccion dircasa = new Direccion("Calle", "Madrid", "28903", 11);
		
		ArrayList<Habitacion> habcasa1 = new ArrayList<Habitacion>();
		habcasa1.add(hab);
		habcasa1.add(hab2);
		habcasa1.add(hab3);
		
		ArrayList<Persona> inquilinos = new ArrayList<Persona>();
		inquilinos.add(inquilino1);
		inquilinos.add(inquilino2);
		
		int precas1 = 650;
		
		Casa casa1 = new Casa(dircasa, habcasa1, propietario, inquilinos, precas1);
		System.out.println(casa1.toString());
	}
}
