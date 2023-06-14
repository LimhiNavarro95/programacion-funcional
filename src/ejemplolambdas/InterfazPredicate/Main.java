package ejemplolambdas.InterfazPredicate;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

  static List<Persona> filtrar(List<Persona> personas, Predicate<Persona> predicate){
    List<Persona> resultado = new ArrayList<>();
    for (Persona persona : personas){
      if (predicate.test(persona)){
        resultado.add(persona);
      }
    }
    return resultado;
  }

  public static void main(String[] args) {

    List<Persona> listaPersonas = new ArrayList<>();
    listaPersonas.add(new Persona("Nacho", 42));
    listaPersonas.add(new Persona("Juan", 70));
    listaPersonas.add(new Persona("Mario", 7));
    listaPersonas.add(new Persona("Ana", 2));
    listaPersonas.add(new Persona("Laura", 4));
    listaPersonas.add(new Persona("Enrique", 42));
    listaPersonas.add(new Persona("May", 41));

    //comprobacion para verificar si es adulto
    Predicate<Persona> adulto = (persona) -> persona.getEdad() >= 18;
    System.out.println(adulto.test(listaPersonas.get(2)));

    //filtrado de las personas adultas
    //de esta manera se le pueden pasar diferentes predicados para diferente tipo de filtrado
    List<Persona> adultos = filtrar(listaPersonas, (persona) -> persona.getEdad() >= 18);
    System.out.println("Listado de personas adultos");
    System.out.println(adultos);

    List<Persona> personasM = filtrar(listaPersonas, (persona) -> persona.getNombre().startsWith("M"));
    System.out.println("Listado de personas con nombre que empiezan con M");
    System.out.println(personasM);

    // combinar varios predicados a una funcion!
    Predicate<Persona> predicateAdulto = p -> p.getEdad() >= 18;
    Predicate<Persona> predicateNombreM = p -> p.getNombre().startsWith("M");
    List<Persona> adultosConM = filtrar(listaPersonas, predicateAdulto.and(predicateNombreM));
    System.out.println("Listado de personas adultos que empiezan con M");
    System.out.println(adultosConM);

  }
}
