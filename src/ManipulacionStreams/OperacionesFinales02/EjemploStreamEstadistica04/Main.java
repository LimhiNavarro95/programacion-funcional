package ManipulacionStreams.OperacionesFinales02.EjemploStreamEstadistica04;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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

    Optional<Persona> mayor = listaPersonas.stream().max((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));

    if (mayor.isPresent()){
      System.out.println(mayor.get());
    } else if (mayor.isEmpty()) {
      System.out.println("No hubo un dato que extraer");
    }

    //calcular la media
    OptionalDouble mediaEdadesAdultos = listaPersonas.stream()
        .filter(persona -> persona.getEdad() >= 18)
        .mapToDouble(p -> p.getEdad()).average();

    if (mediaEdadesAdultos.isPresent()){
      System.out.println("La media de edad es: " + mediaEdadesAdultos.getAsDouble());
    } else if (mediaEdadesAdultos.isEmpty()){
      System.out.println("No hubo dato que extraer");
    }

  }

}
