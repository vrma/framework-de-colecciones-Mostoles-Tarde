package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) {

		/*
		 * Operaciones de Agregado, para recorrer y operar con los elementos de una
		 * coleccion
		 * 
		 * En el siguiente enlace se hace una breve introduccion a las Operaciones de
		 * Agregado
		 * https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.
		 * html
		 * 
		 * Y en el link siguiente ya se abordan con mas profundidad:
		 * https://docs.oracle.com/javase/tutorial/collections/streams/index.html
		 * 
		 * Las Operaciones de Agregado implican convertir la coleccion en un flujo
		 * (Stream) de elementos que comienzan a circular por una tuberia (pipeline),
		 * que podemos entenderla como una linea de produccion, por ejemplo, una cadena
		 * donde se rellenan latas de conserva, que en cada punto de la cadena se hace
		 * una operacion diferente, sobre la lata de conserva, es decir, un operador la
		 * rellena, otro le pone la etiqueta otro la cierra, otro la mete en una caja,
		 * etc.
		 * 
		 * Concretamente, la tuberia es una secuencia de operaciones de agregado, es
		 * decir, operaciones que agrupan los elementos que van circulando por la
		 * tuberia para hacer algun tipo de operacion.
		 * 
		 * Especificamente, la tuberia son los metodos de la clase Stream, que tiene un
		 * origen que puede ser una coleccion, un array, un socket de red, etc., tambien
		 * tiene cero, una o varias operaciones intermedias y solamente una operacion
		 * terminal, al final de la tuberia, que reducirá todos los elementos que van
		 * pasando por la tuberia a un solo elemento, o a una nueva coleccion
		 * 
		 * Las Operaciones de Agregado no es una sintaxis bonita, sino el soporte de la
		 * JVM que tienen detras estas operaciones es muy superior a todo lo que
		 * anteriormente existia con los bucles explicitos (entiendase for clasico y
		 * mejorado, while, do while, etc)
		 */

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

		/* Se puede ordenar una coleccion a medida que se recorre, y no dejarla permanentemente
		 * ordenada como sucede con el metodo sort() de la clase Collections */
		
		// Ejemplo # 1. Ordenar la coleccion de personas mientras se recorre, segun el 
		// el orden natural
		
		System.out.println("Ejemplo # 1");
		personas.stream()
			.sorted()
			.forEach(System.out::println);
		
		// Ejemplo # 2. Ordenar la coleccion de personas mientras se recorre por el salario
		// de la persona
		System.out.println("Ejemplo # 2");
		personas.stream()
			.sorted(Comparator.comparing(Persona::salario))
			.forEach(System.out::println);

		
		/* Ejercicio # 1 del martes 30 de Junio.
		 * 
		 * Ordenar el listado de personas, por salario de mayor a menor salario */
		
		// Suministrado por Jakelin
		
		 
		/* Ordenar el listado de personas, por salario de mayor a menor salario */
         System.out.println("ejercicio 1 ");
         
         personas.stream()
	        .sorted(Comparator.comparing(Persona::salario).reversed())
	        .forEach(System.out::println);
		
		/* Ejercicio # 2. Ordenar por Genero, primero y luego por salario, a medida que se
		 * recorre la coleccion de persona para mostrarla */
         
         // Suministrado por Carlos
        System.out.println("Ejercicio #2");
 		personas.stream()
 			.sorted(Comparator.comparing(Persona::genero)
 					.thenComparing(Persona::salario))
 			.forEach(System.out::println);
		
		
		/* Ejercicio # 3. Mostrar la persona que tiene el mayor salario de todas las 
		 * personas. */
 		System.out.println("Ejercicio 3. Persona con el mayor salario");
		Optional<Persona> personaOptional = personas.stream()
			.max(Comparator.comparing(Persona::salario));
		
		if (personaOptional.isPresent())
		    System.out.println(personaOptional.get());
		
		/* Ejercicio # 4. 
		 * 
		 * Recuperar la persona del genero MUJER, que tenga el menor salario */
		Optional<Persona>  optionalDePersona =  personas.stream()
			.filter(persona -> persona.genero().equals(Genero.MUJER))
			.min(Comparator.comparing(Persona::salario));
		
		if (optionalDePersona.isPresent()) {
			
			// Quiere decir que en la "cajita" del Optional esta presente  la persona
			// que es del genero MUJER y que tiene el menor salario
			
			Persona personaMujerConMenorSalario = optionalDePersona.get();
			
			System.out.println("Persona Mujer con el menor salario " + 
			              personaMujerConMenorSalario);
		}
			
		
	}
}











