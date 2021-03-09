package com.uem.restcoche.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.uem.restcoche.modelo.entidad.Coche;
import com.uem.restcoche.modelo.persistencia.DaoCoche;

@RestController
public class GestorCoche {

	@Autowired
	private DaoCoche daoCoche;

	public List<Coche> listar() {
		// aqui podria poner toda la logica de negocio de mi app
		// ejemplos:
		// 1 - puede el usuario consultar las personas
		// 2- Tengo que mostrar todas las personas o solo algunas?
		List<Coche> lista = daoCoche.findAll();
		return lista;

	}

	/**
	 * Metodo que busca en la bbdd un objto persona dado un id
	 * 
	 * @param id representa el id a buscar
	 * @return el objeto persona en caso de que exista en la bbdd y null en caso de
	 *         que no
	 */
	public Coche obtener(int id) {
		Optional<Coche> opt = daoCoche.findById(id);
		if (opt.isPresent()) {

			return opt.get();// findById devuelve un optional

		} else {

			return null;

		}
	}

	/**
	 * Metodo que da de alta a una persona en la bbdd, no debemos pasar id
	 * 
	 * @param coche el objeto que vamos a dar de alta en la bbdd
	 * @return la persona dada de alta en la bbdd o null en caso de que el nombre de
	 *         la persona tenga menos de 3 caracteres
	 */
	public Coche alta(Coche coche) {
		// podriamos poner toda la logica de la aplicacion
		// En caso de que tengamos una regla de negocio de que el nombre
		// tenga que tener al menos 3 caracteres, la podriamos aqui
		
		Coche p = daoCoche.save(coche);
		return p;
	}

	public Coche modificar(int id, Coche coche) {
		Coche p;
		if (daoCoche.findById(id).isPresent()) {
			
			 p = daoCoche.save(coche);
			 
		}else {
			
			p = null;
		}
		return p;
		// si ejecutamos el save con un id modificamos dicho registro
		// si no le pasamos id, como en el caso de arriba, lo damos de alta
		
	}

	public boolean borrar(int id) {
		if (daoCoche.findById(id).isPresent()) {
			daoCoche.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
