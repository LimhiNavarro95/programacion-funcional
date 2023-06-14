package ejemplolambdas.InterfazComparator;

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

    //se ordena de menor a mayor edad edad
    ComparadorPersonas cp = new ComparadorPersonas();
    listaPersonas.sort(cp);
    System.out.println("se ordena de menor a mayor edad edad");
    for (Persona p : listaPersonas){
      System.out.println(p.toString());
    }
    System.out.println();

    // ordenar de mayor a menor edad (CON CLASE ANONIMA)
    listaPersonas.sort(new Comparator<Persona>() {
      @Override
      public int compare(Persona o1, Persona o2){
        return o2.getEdad() - o1.getEdad();
      }
    });
    System.out.println("ordenar de mayor a menor edad");
    for (Persona p : listaPersonas){
      System.out.println(p.toString());
    }
    System.out.println();

    // ordenar por nombre (de menor a mayor)
    listaPersonas.sort((o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
    System.out.println("ordenar por nombre");
    for (Persona p : listaPersonas){
      System.out.println(p.toString());
    }
    System.out.println();

    // (MEJORADO) ordenar por nombre (de menor a mayor)
    listaPersonas.sort(Comparator.comparing(Persona::getNombre));
    System.out.println("ordenar por nombre (MEJORADO)");
    for (Persona p : listaPersonas){
      System.out.println(p.toString());
    }
    System.out.println();

    // ordenar por edad ascendente y en caso de igualdad, por nombre
    Comparator<Persona> cEdad = (p1, p2) -> p1.getEdad() - p2.getEdad();
    Comparator<Persona> cNombre = (p1, p2) -> p1.getNombre().compareTo(p2.getNombre());
    listaPersonas.sort(cEdad.thenComparing(cNombre));
    System.out.println("ordenar por edad ascendente y en caso de igualdad, por nombre");
    for (Persona p : listaPersonas){
      System.out.println(p.toString());
    }
    System.out.println();

  }

}
