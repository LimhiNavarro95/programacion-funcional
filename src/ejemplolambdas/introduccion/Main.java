package ejemplolambdas.introduccion;

/**
 * Programa principal para probar distintas implementaciones de la interfaz Serie
 */

public class Main {

    public static void main(String[] args) {
        int n=0;
        Serie5 serie5 = new Serie5();

        //10 primeros numeros de 5 en 5 sando la clase Serie5
        System.out.println("Numeros de 5 en 5 usando objeto Serie5");
        for (int i=0; i<5; i++){
            System.out.println(n);
            n = serie5.siguiente(n);
        }

        System.out.println("Numeros de 5 en 5 usando clase anonima");
        Serie s5b = new Serie() {
            @Override
            public int siguiente(int n) {
                return n+5;
            }
        };
        n=0;
        for (int i=0; i<5; i++){
            System.out.println(n);
            n = s5b.siguiente(n);
        }

        System.out.println("Numeros de 5 en 5 usando expresion lambda");
        Serie s5c = (num) -> num + 5;
        n=0;
        for (int i=0; i<5; i++){
            System.out.println(n);
            n = s5c.siguiente(n);
        }

    }

    /*public static void main(String[] args) {
        // ===================== CLASES "NORMALES" ========================
        int n = 0;
        Serie5 s5 = new Serie5();

        System.out.println("Números de 5 en 5 usando objeto Serie5:");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(n);
            n = s5.siguiente(n);
        }

        // ===================== CLASES ANÓNIMAS ========================

        Serie s5b = new Serie()
        {
            @Override
            public int siguiente(int n)
            {
                return n + 5;
            }
        };

        n = 0;
        System.out.println("Números de 5 en 5 usando clase anónima:");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(n);
            n = s5b.siguiente(n);
        }

        // ===================== EXPRESIONES LAMBDA ========================

        Serie s5c = num -> num + 5;

        n = 0;
        System.out.println("Números de 5 en 5 usando expresión lambda:");
        for(int i = 0; i < 10; i++)
        {
            System.out.println(n);
            n = s5c.siguiente(n);
        }
    }*/
}
