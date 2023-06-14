package ejemplolambdas.InterfazComparator;

import entities.Persona;

import java.util.Comparator;

public class ComparadorPersonas implements Comparator<Persona> {

  @Override
  public int compare(Persona o1, Persona o2) {
    //la resta de edades determina que persona es mas joven dependiendo del signo del numero
    return o1.getEdad() - o2.getEdad();
  }

}
