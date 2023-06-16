package ManipulacionStreams.OperacionesIntermedias01.EjemploStreamsOtros;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    System.out.println("Mostrar las 3 personas con mas edad");

    listaPersonas.stream()
        .sorted((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()))
        .limit(3)
        .map(persona -> persona.getNombre())
        .forEach(System.out::println);

    //guardar el resultado anterior en una lista
    List<String> personasConMasEdad = listaPersonas.stream()
        .sorted((p1, p2) -> Integer.compare(p2.getEdad(), p1.getEdad()))
        .limit(3)
        .map(Persona::getNombre).collect(Collectors.toList());
    System.out.println("personasConMasEdad = \n" + personasConMasEdad);

  }

}
