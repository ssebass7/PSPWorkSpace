package com.uem.resttemplate.modelo.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uem.resttemplate.modelo.entidad.Persona;

@Service
public class PersonaProxy {

	//Constante con la URL del servicio rest al que vamos a acceder
	public static final String URL_PERSONAS = "http://localhost:8080/personas/";

	public List<Persona> listar(){
		//Este objeto sera el encargado de hacer las peticiones HTTP
		RestTemplate restTemplate = new RestTemplate();

		//Hacemos una peticion GET a la url y decimos que nos parsee el json a la un array de personas
		//El metodo getForEntity hace la peticion a la URL y tambien le decimos a que clase me tiene que 
		//convertir el json resultante
		//Con el siguiente metedo hacemos una peticion get a "http://localhost:8080/personas/"
		ResponseEntity<Persona[]> response = restTemplate.getForEntity(URL_PERSONAS, Persona[].class);
		
		//Lo que tiene el body es un array de personas, porque el
		//ResponseEntity es un array de personas
		Persona[] arrayPersonas = response.getBody();
		
		//Convertimos el array de personas a una lista de personas
		List<Persona> lista = Arrays.asList(arrayPersonas); 
		
		return lista;
	}
	
	public Persona obtener(int id) {
		RestTemplate restTemplate = new RestTemplate();

		String personaResourceUrl = URL_PERSONAS + id;

		ResponseEntity<Persona> response = restTemplate.getForEntity(personaResourceUrl, Persona.class);
		
		//Esta vez el body solo tendra una persona, no una lista
		return response.getBody();
	}

	public Persona alta(Persona persona) {
		RestTemplate restTemplate = new RestTemplate();

		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Persona> requestBody = new HttpEntity<>(persona);

		// Enviamos la peticion HTTP por POST con el metodo postForObject
		Persona pCreada = restTemplate.postForObject(URL_PERSONAS, requestBody, Persona.class);

		return pCreada;
	}
	
	public Persona modificar(Persona persona) {
		RestTemplate restTemplate = new RestTemplate();

		// Crear un objeto HttpEntity que sera el encargado de
		// rellenar en el body del mensaje Http la entidad que le digamos
		// en este caso, una persona
		HttpEntity<Persona> requestBody = new HttpEntity<>(persona);

		// Enviamos la peticion HTTP por PUT con el metodo exchange
		ResponseEntity<Persona> response = 
				restTemplate.exchange(URL_PERSONAS + persona.getId(), 
						HttpMethod.PUT, 
						requestBody, 
						Persona.class);
 
		return response.getBody();
	}
	
	public void borrar(int id) {
		RestTemplate restTemplate = new RestTemplate();
		 
        // Send request with DELETE method.
        restTemplate.delete(URL_PERSONAS + id);
	}
	

}
