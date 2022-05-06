package fisei.uta.ec.logica;

public class Matematicas {

    public long potencia(int base, int exponente)
    {
        long resultado = 1;

        for (int i=1; i <= exponente; i++)
        {
            resultado *= base;
        }

        return  resultado;
    }

    public static  int sumar(int a, int b)
    {
        return a + b;
    }

    public static int restar(int a, int b)
    {
        return a - b;
    }
}
