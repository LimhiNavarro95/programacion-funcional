package ejemplolambdas.InterfazConsumer;

import entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

    //el method reference que se hace aqui, indica que el parametro que se le pasa a la funcion de la derecha va a ser directamente el objeto que tiene a la izquierda
    Consumer<Persona> imprimir = System.out::println;

    //listaPersonas.forEach((persona) -> imprimir.accept(persona));
    listaPersonas.forEach(imprimir);

    System.out.println();
    //segunda forma
    procesar(listaPersonas, imprimir);

  }

  public static void procesar (List<Persona> personas, Consumer<Persona> consumer){
    personas.forEach(consumer);
  }

}
