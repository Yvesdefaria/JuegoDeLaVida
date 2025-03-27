package daw;


public class Juego {
    private Tablero tablero;
    private int generaciones;
    private int[] poblacionPorGeneracion;


    public Juego(int N) {
        this.tablero = new Tablero(N);
        this.generaciones = 0;
        this.poblacionPorGeneracion = new int[25 * 25]; // máximo tamaño de población para generaciones
    }
    public static void main(String[] args) {
        int N = 10;
        Tablero tabl = new Tablero(N);
        Celula matriz[][] = tabl.getMatriz();
        Tablero.mostrarMatriz(matriz);
        
        
       
        int porcentaje =  Tablero.calcularVivasIniciales(N);
        Tablero.colocacionRandom(matriz, porcentaje);
        Tablero.mostrarMatriz(matriz);
        System.out.println(Tablero.contarVivas(matriz));
        System.out.println(Tablero.comprobrarEstado(1, 1, matriz));
        System.out.println();
    }


    
}



