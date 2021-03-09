package com.uem.restcoche.controlador;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restcoche.modelo.entidad.Coche;
import com.uem.restcoche.modelo.negocio.GestorCoche;
import com.uem.restcoche.modelo.persistencia.DaoCoche;

//Dentro de un MVC esta capa se encargarioa de recibir la informacion de los 
//clientes, traducirla y mandarsela a la capa de negocios para consultar
//o procesar la peticion 
@RestController
public class ControladorCoche {

	@Autowired
	private GestorCoche gp;
	//ResponseEntity nos permite devolver a parte del objeto, tambien
	//el codigo de respuesta
	@GetMapping("coches")
	public ResponseEntity <List<Coche>> listar(){
		List<Coche> lista = gp.listar();
		ResponseEntity<List<Coche>> re = 
				new ResponseEntity<List<Coche>>(lista,HttpStatus.OK);
		return re;
		
	}
	
	//Cuando tenemos parte de la url que es variable, normalmente un id,
	//debemos de poner esa parte entre corchetes,  para recuperar
	//dicho valor dentro de los argumentos debemos de usar la anotacion 
	//@PathVariable con el nombre de la variable
	@GetMapping("coches/{id}")
	public ResponseEntity<Coche> obtener(@PathVariable("id") int id){
		Coche p = gp.obtener(id);
		HttpStatus codigoRespuesta = null;
		if(p != null) {
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.NOT_FOUND;
		}
		
		ResponseEntity<Coche> re = 
				new ResponseEntity<Coche>(p,codigoRespuesta);
		return re;
	}
	
	// @RequestBody le decimos a spring que el json que venga en el body 
	//de la request http del cliente la convierta automaticamente a un
	//objeto de tipo persona
	@PostMapping("coches")
	public ResponseEntity<Coche> alta(@RequestBody Coche coche){
		Coche pAlta = gp.alta(coche);
		HttpStatus codigoRespuesta = null;
		if(pAlta != null) {
			codigoRespuesta = HttpStatus.CREATED;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}
		
		ResponseEntity<Coche> re = 
				new ResponseEntity<Coche>(pAlta,codigoRespuesta);
		return re;
	}
	@PutMapping("coches/{id}")
	public ResponseEntity<Coche> modificar(@RequestBody Coche coche, 
			@PathVariable("id") int id){
		coche.setId(id);
		
		Coche pModificada = gp.modificar(id, coche);
		
		HttpStatus codigoRespuesta = null;
		if(pModificada != null) {
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}
		
		ResponseEntity<Coche> re = 
				new ResponseEntity<Coche>(pModificada,codigoRespuesta);
		return re;
		
	}
	@DeleteMapping("coches/{id}")
	public ResponseEntity<Integer> borrar(@PathVariable("id") int id){
		
		boolean borrado = gp.borrar(id);
		HttpStatus codigoRespuesta = null;
		if(borrado) {
	
			codigoRespuesta = HttpStatus.OK;
		}else {
			codigoRespuesta = HttpStatus.BAD_REQUEST;
		}
		
		
		
		return new ResponseEntity<Integer>(id,codigoRespuesta);
		
		
		
	}
	

}
