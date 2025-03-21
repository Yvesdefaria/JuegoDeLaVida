package daw;

public class Juego {
    public static void main(String[] args) {
        int filas = 7;
        int[][]matriz = Tablero.crearMatriz(filas);
        Tablero.mostrarMatriz(matriz);
        int porcentaje = Tablero.numeroDeVivas(filas);
        Tablero.colocacionRandom(matriz, porcentaje);
        Tablero.mostrarMatriz(matriz);
        int cont = Tablero.contarVivas(matriz);
        System.out.println(cont);
        Tablero t1 = new Tablero();
        
    }
}
