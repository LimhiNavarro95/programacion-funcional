package ManipulacionStreams.EjemploStreamMap02;

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

    //se extraen los nombres del listado original, solo obteniendo un Stream de String's
    Stream<String> nombres = listaPersonas.stream()
                                          .map(persona -> persona.getNombre());
    System.out.println("Nombres de personas");
    nombres.forEach(System.out::println);

    List<String> datosPersonas = new ArrayList<>();
    datosPersonas.add("Adrian:30");
    datosPersonas.add("Julia:45");

    //en una sola linea, se transofrma cada String en un objeto, a partir de la lista anterior de datosPersonas
    datosPersonas.stream().map(s -> new Persona(s.split(":")[0], Integer.parseInt(s.split(":")[1])))
        .forEach(System.out::println);

    //el mapeo sirve para obtener datos concretos de una coleccion o bien transformar datos a una nueva coleccion

    List<String> nombresList = listaPersonas.stream().map(persona -> persona.getNombre()).collect(Collectors.toList());
    System.out.println("nombresList = \n" + nombresList);

  }

}
