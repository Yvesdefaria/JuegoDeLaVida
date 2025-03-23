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
}
