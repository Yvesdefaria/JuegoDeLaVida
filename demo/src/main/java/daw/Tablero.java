package daw;

import java.util.Random;
import java.util.Scanner;

public class Tablero {
    private Celula[][] matriz;
    private int N;
    private static final int MAX_SIZE = 25;

    //Constructor de la clase Tablero
    public Tablero(int N) {
        this.matriz = new Celula[N][N];
        this.N = N;

        // Iniciamos la matriz de células
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = new Celula();
            }
        }
    }

    public Celula[][] getMatriz(int fila,int columna) {
        return matriz;
    }

    public int getN() {
        return N;
    }

    public static int getMaxSize() {
        return MAX_SIZE;
    }

   // public static int[][] crearMatriz(int filas) {
     //   int[][] matriz = new int[filas][filas];
       // for (int i = 0; i < matriz.length; i++) {
         //   for (int j = 0; j < matriz[i].length; j++) {
          //      matriz[i][j] = 0;
          //  }
        //}
     //   return matriz;
   // }

// Método para mostrar el estado actual del tablero
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Metodo que nos da la cantidad de celulas vivas
    public static int crearVivas(int N) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elegia el porcentaje inicial de celulas vivas");
        double porcentaje = teclado.nextDouble();
        double numCasillas = N * N;
        teclado.close();
        return (int) ((porcentaje * numCasillas) / 100.0);
    }
    //Metodo para colocar las celulas en el tablero de forma aleatoria
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
//Metodo para colocar las celulas en el tablero elijiendo la casilla
    public static void colocacionManual(int[][] matriz, int porcentaje) {

    }
    //Nos devuelve la cantidad de vivas en el tablero
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
    //Metodo que nos dice si una celula esta viva o muerta
    public static boolean comprobrarEstado(int fila, int columna, int[][] matriz) {
        return (matriz[fila][columna] == 1 ? true : false);
    }
}
