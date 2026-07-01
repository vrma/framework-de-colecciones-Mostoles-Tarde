package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		Persona persona1 = Persona.builder().nombre("Maria").apellido1("lopez").apellido2("fernandes")
				.genero(Genero.MUJER).fechaNacimiento(LocalDate.of(1985, Month.OCTOBER, 20))
				.salario(new BigDecimal(4500)).build();

		Persona persona2 = Persona.builder().nombre("Maria").apellido1("flores").apellido2("Martinez")
				.genero(Genero.MUJER).fechaNacimiento(LocalDate.of(1966, Month.FEBRUARY, 02))
				.salario(new BigDecimal(6000)).build();

		Persona persona3 = Persona.builder().nombre("Luis").apellido1("Acaro").apellido2("Silva").genero(Genero.HOMBRE)
				.fechaNacimiento(LocalDate.of(1972, Month.DECEMBER, 22)).salario(new BigDecimal(6800)).build();

		Persona persona4 = Persona.builder().nombre("Luis").apellido1("Paredes").apellido2("Hernandez")
				.genero(Genero.HOMBRE).fechaNacimiento(LocalDate.of(1997, Month.MARCH, 05))
				.salario(new BigDecimal(5800)).build();

		Persona persona5 = Persona.builder().nombre("Wilson ").apellido1("flores").apellido2("Martinez")
				.genero(Genero.HOMBRE).fechaNacimiento(LocalDate.of(1989, Month.AUGUST, 15))
				.salario(new BigDecimal(6500)).build();

		List<Persona> personas = new ArrayList<Persona>();

		personas.add(persona1);
		personas.add(persona2);
		personas.add(persona3);
		personas.add(persona4);
		personas.add(persona5);

		
		/**
		 * ¿Que es una coleccion Map, que tambien se le llama un mapa?
		 * Es una interface que relaciona claves con Valor en cada entrada
		 * del mapa, y las claves no pueden repetirse
		 * 
		 * Se dice que un mapa (Map Interface) NO es una  verdadera coleccion
		 * porque no hereda de la interfaz Collection, pero puede ser tratada como
		 * una coleccion si se utilizan las vistas de colecciones (Collections Views)
		 */
		
		/* Ejemplo de creacion de un Map, es decir, una coleccion que almacena parejas de
		 * clave y valor, para ello vamos a contar la frecuencia de ocurrencia de 
		 * nombres que se reciben como argumentos de la aplicacion cuando se ejecuta */
		
		// Primero: Convertir el array de argumentos que recibe la aplicacion
		// cuando se ejecuta, es decir, la variable args de tipo String[], que recibe 
		// como parametro el metodo main(), en una coleccion List
		
		List<String> nombres = Arrays.asList(args);
		
		// Comprobar si nombres posee todos los argumentos que recibe la aplicacion
		// cuando se ejecuta
		
		nombres.forEach(System.out::println);
		
		
		// Segundo: Declarar el mapa, especificando el tipo de datos de las claves y de
		// los valores del mapa
		
		Map<String, Integer> m = new HashMap<String, Integer>();
		
		/**
		 * Una de las clases que implementan la interface Map es HashMap, que no permite
		 * ordenar la claves del mapa, pero ofrece un alto rendimiento.
		 * 
		 * Si queremos ordenar las claves del mapa hay que utilizar un TreeMap que si
		 * permite ordenamiento
		 */
		
		// ¿Que diferencia hay entre String (cadena de caracteres) y Stream (flujo) ? 
		// String es una clase que sirve como tipo de dato, cualquier variable de tipo
		// String su valor tiene que estar entre comilla dobles
		// String nombre = "Elida 22323@@ #";
		
		Stream<String> flujoDeString = nombres.stream();
		
		/***
		 * A continuacion vamos a crear la coleccion mapa recorriendo la lista de nombres
		 * con una sentencia for mejorada y comprobaremos, posteriormente, que es
		 * mucho menos codigo si hacemos lo mismo con operaciones de agregado para 
		 * recorrer la coleccion de nombres
		 * 
		 */
		
		for (String nombre : nombres) {
			
			// Comprobar si el nombre ya esta en el mapa m
			// . Lo cual hacemos utilizando el metodo get
			// que busca, en el mapa, el valor asociado a la clave
			// que se le pasa como parametro, si encuentra la clave
			// devuelve el valor asociado a la misma y de lo contrario
			// devuelve null
			Integer frecuenciaDeOcurrencia = m.get(nombre);
			
			m.put(nombre, frecuenciaDeOcurrencia == null ? 1 : frecuenciaDeOcurrencia++ );
			
			
		}
		
		
	}
}











