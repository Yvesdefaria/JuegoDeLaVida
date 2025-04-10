package daw;

import java.util.Scanner;

public class Juego {

    private static Tablero tablero;
    private static int N;

    public Juego(int N) {
        Juego.tablero = new Tablero(N);
    }

   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivo = "";
        String ArchivoCarga;
        int menuColocacion = 0;
        int controlMenu = 0;
        Juego juego = null;
        


        
        System.out.println("-------JUEGO DE LA VIDA-------");
        System.out.println("¿Quieres cargar un archivo? SI(1)/NO(2)");
        int opcion_Cargar = scanner.nextInt();
        if (opcion_Cargar == 1) {
            scanner.nextLine();
            System.out.println("Introduzca el nombre del archivo");
            ArchivoCarga = scanner.nextLine();
            tablero = Tablero.cargar(ArchivoCarga);
            
            tablero.mostrarMatriz();
            
        } else {

            System.out.println("Introduce el tamaño de la matriz (máximo 25):");
            int N = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            if (N > 25) {
                System.out.println("El tamaño máximo permitido es 25.");
                 return;
            }

            juego = new Juego(N);
            

            System.out.println("Menu de la Vida");
            System.out.println("1. Colocacion Random");
            System.out.println("2. Colocacion Manual");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción:");
            menuColocacion = scanner.nextInt();
            scanner.nextLine();
            switch (menuColocacion) {
                case 1 -> {
                    tablero.colocacionRandom();
                    tablero.mostrarMatriz();
                }
                case 2 -> {
                    tablero.colocacionManual();
                    tablero.mostrarMatriz();
                }
                case 3 -> {
                    break;
                }
                default -> {
                }
            }
        }
        
        do {
            System.out.println("Menu Generacion");
            System.out.println("1. Mostrar siguiente generación");
            System.out.println("2. Terminar juego");
            System.out.println("3. Guardar juego");
            System.out.println("Selecciona una opción:");
            controlMenu = scanner.nextInt();
            scanner.nextLine();
            switch (controlMenu) {
                case 1 ->{
                tablero.siguienteGeneracion();
                tablero.mostrarMatriz();
                }
                case 2 -> {
                    break;
                }
                case 3 -> {
                    System.out.println("Elija el nombre del archivo a guardar");
                    archivo = scanner.nextLine();
                    tablero.guardar(archivo);
                    break;
                }
                default -> {
                }
            }
        } while (controlMenu != 2 && controlMenu != 3);

    }
}
