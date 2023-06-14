package ejemplolambdas.InterfazFunction;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

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

    //bi funcion que filtra personas por edad
    BiFunction<List<Persona>, Integer, List<Persona>> minEdad = (lista, edad) -> {
      List<Persona> resultado = new ArrayList<>();
      /*for(Persona p : lista) {
        if(p.getEdad() >= edad){
          resultado.add(p);
        }
      }*/
      lista.forEach((p) -> {
        if(p.getEdad() >= edad){
          resultado.add(p);
        }
      });
      return resultado;
    };

    //funcion que muestra nombre de personas separados por coma
    Function<List<Persona>, String> listaAsString = (list) -> {
      String result = "";
      for(int i= 0; i < list.size(); i++){
        if (i < list.size() - 1) {
          result += list.get(i) + ", ";
        } else {
          result += list.get(i);
        }
      }
      return result;
    };

    int edadAdulto = 18;

    List<Persona> adultos = minEdad.apply(listaPersonas, edadAdulto);
    System.out.println("Personas con al menos " + edadAdulto + " anios \n" + adultos);

    System.out.println("Nombres separados por comas");
    System.out.println(listaAsString.apply(listaPersonas));

    //combinacion de funciones
    BiFunction<List<Persona>, Integer, String> nombresAdultos = minEdad.andThen(listaAsString);
    System.out.println("Combinacion de funciones - (nombres de personas adultas) (separadas por comas)");
    System.out.println(nombresAdultos.apply(listaPersonas, 18));

  }

}
