package ManipulacionStreams.OperacionesIntermedias01.EjemploStreamFilter01;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {

    List<Persona> listaPersonas = new ArrayList<>();
    listaPersonas.add(new Persona("Nacho", 42));
    listaPersonas.add(new Persona("Juan", 70));
    listaPersonas.add(new Persona("Mario", 7));
    listaPersonas.add(new Persona("Ana", 2));
    listaPersonas.add(new Persona("Laura", 4));
    listaPersonas.add(new Persona("Enrique", 42));
    listaPersonas.add(new Persona("May", 41));

    Stream<Persona> streamPersonas = listaPersonas.stream();
    Stream<Persona> adultosStream = streamPersonas.filter(persona -> persona.getEdad() >= 18);

    System.out.println("Personas adultas, impresion por medio de Strem");
    adultosStream.forEach(persona -> System.out.println(persona));

    System.out.println("En una linea, se puede poner lo que hacen 3 lineas y sin definir un objeto stream");
    listaPersonas.stream()
        .filter(p-> p.getEdad() >= 18 && p.getNombre().startsWith("M")) //filtro con dos condiciones gracias al AND
        .forEach(System.out::println);

    //Guardado de una lista aplicando el stream gracias al "collect"
    List<Persona> adultosList = listaPersonas.stream().filter(p-> p.getEdad() >= 18).collect(Collectors.toList());
    System.out.println("adultosList = \n" + adultosList);

  }
}
