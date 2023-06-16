package ManipulacionStreams.OperacionesFinales02.EjemploStreamCadena02;

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

    String nombresAdultos = listaPersonas.stream()
        .filter(persona -> persona.getEdad() >= 18)
        .map(persona -> persona.getNombre())
        .collect(Collectors.joining(",", "Nombres adultos: ", ". Fin"));

    System.out.println(nombresAdultos);
    
  }

}

