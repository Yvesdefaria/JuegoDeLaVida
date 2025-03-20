package daw;

import java.util.Random;
import java.util.Scanner;

public class Operaciones {
    public static int[][] crearMatriz(int filas){
        int[][] matriz = new int[filas][filas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]=0;
            }
        }

        return matriz;
    }

    public static void mostrarMatriz(int[][]matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
               System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int asignarPorcentaje(int filas){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elegia el porcentaje inicial de celulas vivas");
        int porcentaje = teclado.nextInt();
        int numCasillas = filas*filas;
        return (int)((porcentaje / 100.0) * numCasillas);
  //      return (int)Math.floor((porcentaje/100)*numCasillas);
    }

    public static void colocacionRandom(int[][]matriz, int porcentaje){
        Random r = new Random();
        int fila;
        int columna; 
        for (int i = 0; i <= porcentaje; i++) {
                fila = r.nextInt(0,matriz.length);
                columna = r.nextInt(0,matriz.length);
                matriz[fila][columna]=1;
            
        }
    }

    public static int contarVivas(int[][]matriz){
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j]== 1){
                    cont++;

                }
            }
        } 
        return cont;
    }
}
