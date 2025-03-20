package daw;

public class Operaciones {
    public static int[][] crearMatriz(int n){
        int[][] matriz = new int[n][n];
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
}
