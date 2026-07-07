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
				.genero(Genero.MUJER).fechaNacimiento(LocalDate.of(1985, Month.OCTOBER, 20 ))
				.salario(new BigDecimal(6000)).build();

		Persona persona3 = Persona.builder().nombre("Luis").apellido1("Acaro").apellido2("Silva").genero(Genero.HOMBRE)
				.fechaNacimiento(LocalDate.of(1972, Month.DECEMBER, 22)).salario(new BigDecimal(6800)).build();

		Persona persona4 = Persona.builder().nombre("Luis").apellido1("Paredes").apellido2("Hernandez")
				.genero(Genero.HOMBRE).fechaNacimiento(LocalDate.of(1972, Month.DECEMBER, 22))
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
		 
		 /*
		  * CREACION DE Colecciones Map Interface (Mapas) a partir de recorrer una lista
		  * de elementos */
		 	
		/* Ejemplo # 1 del Lunes 6 de Julio.
		 * 
		 * Recorrer la lista de personas y obtener una nueva coleccion que agrupe total
		 * de personas por genero */
		 
		 // Para la solucion, lo primero a tener en cuenta es tipo de datos que va a ir
		 // en la clave del mapa y en el valor
		 Map<Genero, Long> personasAgrupadasPorGenero = personas.stream()
				 .collect(Collectors.groupingBy(persona -> persona.genero(), 
						 Collectors.counting()));
		 
		 /* La creacion del mapa anterior esta bien, pero se puede mejorar
		  * ¿Como? 
		  * 
		  * Rta. Substituir la expresion lambda que se pasa al metodo groupingBy por 
		  * el metodo genero por referencia */
		 Map<Genero, Long> personasAgrupadasPorGenero2 = personas.stream()
				 .collect(Collectors.groupingBy(Persona::genero, 
						 Collectors.counting()));
		 
		 
		 /* Ejemplo # 2 del Lunes 6 de Julio.
		  *
		  * Recorrer la coleccion de personas y obtener una nueva coleccion 
		  * que agrupe personas por Genero
		  * */
		 
		 Map<Genero, List<Persona>> personasAgrupadasPorGenero3 = personas.stream()
				 .collect(Collectors.groupingBy(Persona::genero));
		 
		 
		 System.out.println(personasAgrupadasPorGenero3);
		 
		 /* Ejemplo # 3.
		  * 
		  * Recorrer la lista de personas y obtener una nueva colecion que 
		  * agrupe personas por genero y edad */
		 
		 Map<Genero, Map<Long, List<Persona>>> personasPorGeneroYEdad;
		 

		 personasPorGeneroYEdad = personas.stream()
				 .collect(Collectors.groupingBy(Persona::genero, 
						 	Collectors.groupingBy(Persona::edad)));
		 
		 
		 /* Ejemplo # 4 
		  * 
		  * Recorrer la lista de personas y obtener una nueva coleccion que agrupe
		  * nombres de persona, sin duplicados, agrupados por Genero y edad */
		 
		 Map<Genero, Map<Long, Set<String>>> nombresDePersonaPorGeneroYEdad;
		
		 
		nombresDePersonaPorGeneroYEdad = personas.stream()
				.collect(Collectors.groupingBy(Persona::genero,
						Collectors.groupingBy(Persona::edad,
							Collectors.mapping(Persona::nombre,
									Collectors.toSet()))));
		
		System.out.println(nombresDePersonaPorGeneroYEdad);
		 
		/* Una coleccion de tipo Map Interface no se puede recorrer utilizando las tres
		 * formas de recorrer una coleccion (Iterator, for mejorado y operaciones de 
		 * agregado) a no ser que se utilize una de las denominadas vistas de colecciones
		 * (Collection Views), para especificar con que parte de la coleccion Map queremos
		 * trabar.
		 * 
		 * Las vistas de colecciones permiten trabajar con las claves del mapa solamente,
		 * con los valores o con ambos */
		
		/* A continuacion vamos a recorrer cada una de las colecciones Map que hemos
		 * creado, hoy lunes 6 de Julio, primero utilizando sentencia for mejorada y luego Operaciones de
		 * Agregado. */
		
		/* 1- Recorriendo la coleccion de personasAgrupadasPorGenero
		 * 
		 *  Las vistas de colecciones son las siguientes: 
		 *  	- keySet(): Permite acceder solamente a las claves del mapa 
		 *  	- values(): Permite acceder solamente a los valores de cada entrada 
		 *  				del mapa
		 *      - entrySet(): Permite acceder tanto a las claves como a los valores 
		 *      			 de las entradas del mapa */
		
		for (Map.Entry<Genero, Long> entry : personasAgrupadasPorGenero.entrySet()) {
			
			Genero key = entry.getKey();
			Long value = entry.getValue();
			
			System.out.println("Del genero: " + key + ", hay " + value + " personas");
			// System.out.println("Existen " + value + " personas");
		}
		
		/* 2- Recorrer el mapa de personasAgrupadasPorGenero3 y mostrar la lista de
		 * personas de cada genero ordenada primero por edad y luego por el salario */
		
		// Vamos a utilizar sentencia for mejorado, conjuntamente con operaciones de 
		// de agregado a la hora de recorrer la lista de personas de cada genero
		
		for (Map.Entry<Genero, List<Persona>> entry : personasAgrupadasPorGenero3.entrySet()) {
			
			Genero key = entry.getKey();
			
			// value es una lista de personas, por lo tanto, para recorrerla y mostrarla
			List<Persona> value = entry.getValue();
			
			System.out.println("Del genero:  " + key);
			System.out.println("El listado de personas ordenado por edad, primero y"
					+ " salario posteriormente es: ");
			
			// Recordar que value es una lista de personas, 
			// por lo tanto, para recorrerla y mostrarla
			value.stream()
				.sorted(Comparator.comparing(Persona::edad)
						.thenComparing(Persona::salario))
				.forEach(System.out::println);
		}
		
		
	}
}











