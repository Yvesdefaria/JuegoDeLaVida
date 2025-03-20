package daw;

public class Main {
    public static void main(String[] args) {
        int filas = 7;
        int[][]matriz = Operaciones.crearMatriz(filas);
        Operaciones.mostrarMatriz(matriz);
        int porcentaje = Operaciones.asignarPorcentaje(filas);
        Operaciones.colocacionRandom(matriz, porcentaje);
        Operaciones.mostrarMatriz(matriz);
        int cont = Operaciones.contarVivas(matriz);
        System.out.println(cont);
    }
}