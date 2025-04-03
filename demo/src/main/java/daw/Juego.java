package daw;

import java.util.Scanner;

public class Juego {
    private static Tablero tablero;
    private int generaciones;
    private int[] poblacionPorGeneracion;

    public Juego(int N) {
        Juego.tablero = new Tablero(N);
        this.generaciones = 0;
        this.poblacionPorGeneracion = new int[N * N]; // máximo tamaño de población para generaciones
    }

    public void mostrarGeneracionSiguiente() {
        tablero.siguienteGeneracion();
        generaciones++;
        tablero.mostrarMatriz();
    
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el tamaño de la matriz (máximo 25):");
        int N = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        Juego juego = null;
        if (N > 25) {
            System.out.println("El tamaño máximo permitido es 25.");
            return;
        }

        juego = new Juego(N);
        int menuColocacion = 0;
        while (menuColocacion != 3) {
            System.out.println("Menu de la Vida");
            System.out.println("1. Colocacion Ramdon");
            System.out.println("2. Colocacion Manual");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción:");
            menuColocacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            if (menuColocacion==1) {
                tablero.colocacionRandom();
                tablero.mostrarMatriz();
            }else if(menuColocacion==2){
                tablero.colocacionManual();
                tablero.mostrarMatriz();
            }else if(menuColocacion==3){
                break;
            }
        int controlMenu = 0;
        while (controlMenu != 2) {
            System.out.println("Menu Generacion");
            System.out.println("1. Mostrar siguiente generación");
            System.out.println("2. Terminar juego");
            System.out.println("3. Guardar juego");
            System.out.println("Selecciona una opción:");
            controlMenu = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (controlMenu == 1) {
                juego.mostrarGeneracionSiguiente();
                tablero.comprobarMatrizRepe();
            } else if (controlMenu == 2) {
                break;
            } else if (controlMenu == 3) {
                break;
            }
            
        }
        }
        
    }
}
