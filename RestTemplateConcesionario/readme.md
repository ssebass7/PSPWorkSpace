# Ejemplo RestTemplate

Este ejemplo se trata de consumir mediante Java-Spring el servicio rest que hemos creado en el ejercicio 04_SpringRestPersona

Para ello vamos a usar las librerias estandares de Spring que son RestTemplate.

Para hacer este proyecto:

1. Crear un proyecto Spring boot
2. Ojo! Elegir war en vez de jar
3. Elegir los siguientes starters
	- Spring Web
4. Ojo, este es un proyecto que se levanta en un servidor Tomcat, por lo que pueden entrar en conflicto con el servidor Tomcat del ejercicio 04, por lo tanto se deben de configurar puertos diferentes en el application.properties. En este ejemplo se ha configurado el servidor Tomcat en el puerto 8081	
5. La clase Persona se ha copiado del ejercio 04_SpringRestPersona
6. La clase encargada de hacer la peticiones HTTP al ejercicio 04 es la clase PersonaProxy, que va dentro del modelo

Proxy -> Un proxy, o servidor proxy, en una red informática, es un servidor —programa o dispositivo—, que hace de intermediario en las peticiones de recursos que realiza un cliente a otro servidor.