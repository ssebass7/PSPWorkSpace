package com.uem.resttemplate.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uem.resttemplate.modelo.entidad.Coche;

@Service
public class CocheProxy {

	//Constante con la URL del servicio rest al que vamos a acceder
	public static final String URL_COCHES = "http://localhost:8080/coches/";

	public List<Coche> listar(){
		//Este objeto sera el encargado de hacer las peticiones HTTP
		RestTemplate restTemplate = new RestTemplate();

		//Hacemos una peticion GET a la url y decimos que nos parsee el json a la un array de personas
		//El metodo getForEntity hace la peticion a la URL y tambien le decimos a que clase me tiene que 
		//convertir el json resultante
		//Con el siguiente metedo hacemos una peticion get a "http://localhost:8080/personas/"
		ResponseEntity<Coche[]> response = restTemplate.getForEntity(URL_COCHES, Coche[].class);
		
		//Lo que tiene el body es un array de personas, porque el
		//ResponseEntity es un array de personas
		Coche[] arrayCoches = response.getBody();
		
		//Convertimos el array de personas a una lista de personas
		List<Coche> lista = Arrays.asList(arrayCoches); 
		
		return lista;
	}
	
	public Coche obtener(int id) {
		RestTemplate restTemplate = new RestTemplate();

		String cochesResourceUrl = URL_COCHES + id;

		ResponseEntity<Coche> response = restTemplate.getForEntity(cochesResourceUrl, Coche.class);
		
		//Esta vez el body solo tendra una persona, no una lista
		return response.getBody();
	}

	public Coche alta(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		// Enviamos la peticion HTTP por POST con el metodo postForObject
		Coche cCreada = restTemplate.postForObject(URL_COCHES, requestBody, Coche.class);

		return cCreada;
	}
	
	public Coche modificar(Coche coche) {
		RestTemplate restTemplate = new RestTemplate();

		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Coche> requestBody = new HttpEntity<>(coche);

		// Enviamos la peticion HTTP por PUT con el metodo exchange
		ResponseEntity<Coche> response = 
				restTemplate.exchange(URL_COCHES + coche.getId(), 
						HttpMethod.PUT, 
						requestBody, 
						Coche.class);
 
		return response.getBody();
	}
	
	public void borrar(int id) {
		RestTemplate restTemplate = new RestTemplate();
		 
        // Send request with DELETE method.
        restTemplate.delete(URL_COCHES + id);
	}
	

}
