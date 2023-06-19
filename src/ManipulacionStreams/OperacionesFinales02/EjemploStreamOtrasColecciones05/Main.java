package ManipulacionStreams.OperacionesFinales02.EjemploStreamOtrasColecciones05;

import entities.Persona;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    // Ejemplo con array
    Persona[] arrayPersonas = new Persona[5];
    arrayPersonas[0] = new Persona("Nacho", 42);
    arrayPersonas[1] = new Persona("Juan", 70);
    arrayPersonas[2] = new Persona("Mario", 7);
    arrayPersonas[3] = new Persona("Laura", 4);
    arrayPersonas[4] = new Persona("May", 41);

    List<Persona> adultos = Arrays.stream(arrayPersonas)
        .filter(persona -> persona.getEdad() >= 18)
        .collect(Collectors.toList());

    System.out.println("adultos -> \n" + adultos);

    //la operacion inversa
    /*Persona[] adultosArray = Arrays.stream(arrayPersonas)
        .filter(persona -> persona.getEdad() >= 18)
        .toArray(size -> new Persona[size]);*/

    //Ejemplo con map

    Map<String, Persona> mapaPersonas = new HashMap<>();
    mapaPersonas.put("11111111A", new Persona("Nacho", 42));
    mapaPersonas.put("22222222B", new Persona("Juan", 70));
    mapaPersonas.put("33333333C", new Persona("Mario", 7));
    mapaPersonas.put("44444444D", new Persona("Laura", 4));
    mapaPersonas.put("55555555E", new Persona("May", 41));

    //obtener lista de adultos (solo nombres por medio de "value()")
    List<Persona> adultosMapa = mapaPersonas
        .values()
        .stream()
        .filter(persona -> persona.getEdad() >= 18)
        .collect(Collectors.toList());

    System.out.println("adultosMapa -> \n" + adultosMapa);

    //obtener DNI de adultos (solo el key del mapa por medio de "entrySet()")
    List<String> dniAdultos = mapaPersonas
        .entrySet()
        .stream()
        .filter(persona -> persona.getValue().getEdad() >= 18)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());

    System.out.println("dniAdultos -> \n" + dniAdultos);

  }

}
