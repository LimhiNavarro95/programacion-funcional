package entities;

/**
 * Clase Persona que emplearemos para definir una lista de personas que ordenar por distintos criterios
 */

public class Persona
{
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    @Override
    public String toString()
    {
        return nombre + " (" + edad + " años)";
    }
}
