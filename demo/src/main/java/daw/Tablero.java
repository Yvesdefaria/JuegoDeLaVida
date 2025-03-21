package daw;

import java.util.Random;
import java.util.Scanner;

public class Tablero {

    // private int fila;
    // private int columna;

    // private int[][] matriz;
    // private int generacion;
    // private int numeroDeVivas;

    public static int[][] crearMatriz(int filas) {
        int[][] matriz = new int[filas][filas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }

        return matriz;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int crearVivas(int filas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elegia el porcentaje inicial de celulas vivas");
        double porcentaje = teclado.nextDouble();
        double numCasillas = filas * filas;
        teclado.close();
        return (int) ((porcentaje * numCasillas) / 100.0);
    }

    public static void colocacionRandom(int[][] matriz, int porcentaje) {
        Random r = new Random();
        int fila;
        int columna;
        for (int i = 0; i <= porcentaje; i++) {
            fila = r.nextInt(0, matriz.length);
            columna = r.nextInt(0, matriz.length);
            matriz[fila][columna] = 1;

        }
    }

    public static void colocacionManual(int[][] matriz, int porcentaje){
        
    }

    public static int contarVivas(int[][] matriz) {
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    cont++;

                }
            }
        }
        return cont;
    }

    public static boolean comprobrarEstado(int fila, int columna,int[][]matriz){
        return(matriz[fila][columna]==1 ? true : false);
    }
}
