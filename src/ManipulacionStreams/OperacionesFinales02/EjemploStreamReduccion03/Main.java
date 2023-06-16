package ManipulacionStreams.OperacionesFinales02.EjemploStreamReduccion03;

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

    int sumaEdades = listaPersonas.stream()
        .mapToInt(persona -> persona.getEdad())
        .reduce(0, (e1, e2) -> e1 + e2);

    System.out.println("sumaEdades = " + sumaEdades);

    if (listaPersonas.stream().anyMatch(persona -> persona.getEdad() >= 18)){
      System.out.println("Hay al menos un adulto en el grupo");
    } else {
      System.out.println("No hay ningun adulto en el grupo");
    }

  }

}
