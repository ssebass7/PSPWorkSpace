package com.uem.resttemplate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.uem.resttemplate.modelo.entidad.Coche;
import com.uem.resttemplate.modelo.proxy.CocheProxy;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
				
		CocheProxy cProxy = 
				context.getBean("cocheProxy",CocheProxy.class);
	
		System.out.println("LISTAR");
		List<Coche> listaCoches = cProxy.listar();
		System.out.println(listaCoches);
		
		System.out.println("OBTENER");
		Coche c2 = cProxy.obtener(1);
		System.out.println(c2);
		
		Coche c1 = new Coche();
		//no le ponemos el id, porque el servicio rest me asignara el id
		c1.setModelo("bmw serie 1");
		c1.setMatricula("1234ASD");
		c1.setPrecio(5000);
		
		System.out.println("ALTA");
		c1 = cProxy.alta(c1);
		//con la respuesta del servicio rest, ya tengo el objeto con el id
		System.out.println(c1);
		
		c2 = new Coche();
		c2.setModelo("bmw serie 9");
		c2.setMatricula("1264AAD");
		c2.setPrecio(230000);
		c2.setId(2);
		
		System.out.println("MODIFICAR");
		Coche c3 = cProxy.modificar(c2);
		
		System.out.println(c3);
		
		System.out.println("BORRAR");
		cProxy.borrar(1);
		System.out.println("Coche borrado");
		
		System.out.println("LISTAR");
		listaCoches = cProxy.listar();
		System.out.println(listaCoches);
		
	}

}
