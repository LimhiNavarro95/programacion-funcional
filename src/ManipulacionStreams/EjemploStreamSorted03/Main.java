package ManipulacionStreams.EjemploStreamSorted03;

import entities.Persona;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    // se establecen los comparators para hacer la ordenacion
    Comparator<Persona> cEdad = (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad());
    Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());

    // se ordena la lista aplicando los comparators
    listaPersonas.stream()
        .sorted(cEdad.thenComparing(cNombre))
        .forEach(System.out::println);

  }

}
