package ejemplolambdas.introduccion;

/**
 * Interfaz que usaremos en este ejemplo, para representar distintas series numéricas
 */

@FunctionalInterface
public interface Serie {
    int siguiente(int n);
}
