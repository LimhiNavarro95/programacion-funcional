package ejemplolambdas.introduccion;

/**
 * Clase para implementar de forma tradicional la interfaz Serie
 */

public class Serie5 implements Serie {

    @Override
    public int siguiente(int n) {
        return n + 5;
    }

}
