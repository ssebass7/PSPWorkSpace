package com.uem.resttemplate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.uem.resttemplate.modelo.entidad.Persona;
import com.uem.resttemplate.modelo.proxy.PersonaProxy;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
				
		PersonaProxy pProxy = 
				context.getBean("personaProxy",PersonaProxy.class);
	
		System.out.println("LISTAR");
		List<Persona> listaPersonas = pProxy.listar();
		System.out.println(listaPersonas);
		
		System.out.println("OBTENER");
		Persona p2 = pProxy.obtener(1);
		System.out.println(p2);
		
		Persona p1 = new Persona();
		//no le ponemos el id, porque el servicio rest me asignara el id
		p1.setNombre("Harry Potter");
		p1.setPeso(78.9);
		p1.setEdad(45);
		
		System.out.println("ALTA");
		p1 = pProxy.alta(p1);
		//con la respuesta del servicio rest, ya tengo el objeto con el id
		System.out.println(p1);
		
		p2 = new Persona();
		p2.setNombre("Ernion Güesley");
		p2.setPeso(45);
		p2.setEdad(19);
		p2.setId(2);
		
		System.out.println("MODIFICAR");
		Persona p3 = pProxy.modificar(p2);
		
		System.out.println(p3);
		
		System.out.println("BORRAR");
		pProxy.borrar(1);
		System.out.println("Persona borrada");
		
		System.out.println("LISTAR");
		listaPersonas = pProxy.listar();
		System.out.println(listaPersonas);
		
	}

}
