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
import java.util.TreeMap;
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
			
			m.put(nombre, frecuenciaDeOcurrencia == null ? 1 : ++frecuenciaDeOcurrencia );
			
			// La sentencia vacia, es decir, el punto y coma que esta a continuacion
			// el unico objetivo que tiene es que no se vaya el cursor al inicio del
			// del bucle for y deje de ver el valor que tiene la variable 
			// frecuenciaDeOcurrencia. 
			// Solamente es necesario cuando se esta depurando el codigo
			
			// int x = 4;
			
		}
		
		System.out.println("Mapa m resultante: ");
		System.out.println(m);
		
		/* ¿Como se puede ordenar el mapa resultante, es decir, las claves del 
		 * mapa resultante? 
		 * 
		 * Tener presente que si el mapa se ha construido a partir de la clase 
		 * HashMap no se puede ordenar de ninguna manera porque dicha clase 
		 * no garantiza ordenamiento. 
		 * 
		 * Entonces. ¿Como hacer para mostrar el mapa ordenado por las claves?  Insisto.
		 * 
		 * Rta. Crear un nuevo mapa, identico al desordenado, en cuanto a las claves y 
		 * valor de mapa, pero a partir de una clase TreeMap, que si permite
		 * ordenamiento, y se copiaria todo el contenido del mapa desordenado para 
		 * el construido a partir del TreeMap */
		
		/*
		 * A un mapa no se le pueden aplicar los algoritmos, de ordenamiento por ejemplo
		 * que estan implementados en el metodo sort() de la clase Collections, porque 
		 * una interface Map NO hereda de Collection */
		
		// Lexicograficamente quiere decir de la A a la Z
		
		Map<String, Integer> mapaOrdenadoLexicograficamente = new TreeMap<>();
		
		// Lo unico que hay que hacer es copiar todas las entradas del mapa 
		// desordenado en el nuevo mapa
		
		mapaOrdenadoLexicograficamente.putAll(m);
		
		System.out.println("Mapa ordenado lexicograficamente: ");
		System.out.println(mapaOrdenadoLexicograficamente);
		
		/* Ejercicio # 1 del Jueves 2 de Julio 
		 * 
		 * Ordenar las claves del mapa m en orden alfabetico inverso */
		
		// Solucion de Elida
		
		Map<String, Integer> mapaOrdenadoAlfabeticamenteInverso = new TreeMap<>(Comparator.reverseOrder());
		mapaOrdenadoAlfabeticamenteInverso.putAll(m);
		System.out.println("Mapa ordenado alfabeticamente inverso: ");
		System.out.println(mapaOrdenadoAlfabeticamenteInverso);
		
		/* El mapa m se puede obtener en una sola sentencia, utilizando OPERACIONES DE 
		 * AGREGADO.
		 * 
		 * Los mapas, por lo general, se obtienen a partir de recorrer una lista (List)
		 * o un Set, raramente utilizando el metodo put
		 * 
		 * A  modo de ejemplo, vamos a obtener nuevamente el mapa m a partir de recorrer 
		 * la lista con los nombres recibidos como argumentos cuando se lanza la 
		 * aplicacion y le vamos a llamar a dicho mapa mm */
		
		 Map<String, Long> mm = nombres.stream()
				 .collect(Collectors.groupingBy(n -> n, 
						 Collectors.counting()));
		 
		 System.out.println("El mapa mm es exactamente igual que el m, pero obtenido con"
		 		+ "mucho menos esfuerzo: ");
		 
		 System.out.println(m);
		 System.out.println(mm);
		 	
		
		
	}
}











