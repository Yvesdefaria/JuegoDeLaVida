package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tablero {

   

    private Celula[][] matriz;
    private int N;
    private static final int MAX_SIZE = 25;
    private List<Celula[][]> lista_Matrizes = new ArrayList<>();
    private int contadorRepe = 1;  
    private int generaciones;
    private List<Integer> poblacionPorGeneracion = new ArrayList<>();

    // Constructor de la clase Tablero
    public Tablero(int N) {
        this.matriz = new Celula[N][N];

        // Iniciamos la matriz de células
        if (N <= MAX_SIZE && N > 0) {
            this.N = N;
        } else {
            this.N = 25;  
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matriz[i][j] = new Celula(false);
            }
        }
    }
     
     private Celula[][] clonarMatriz(Celula[][] matrizOriginal) {
        Celula[][] matrizClonada = new Celula[matrizOriginal.length][matrizOriginal[0].length];
        for (int i = 0; i < matrizOriginal.length; i++) {
            for (int j = 0; j < matrizOriginal[i].length; j++) {
                matrizClonada[i][j] = new Celula(matrizOriginal[i][j].isEstaVivo());
            }
        }
        return matrizClonada;
    }

    public Celula[][] getMatriz(int fila, int columna) {
        return matriz;
    }

    public int getN() {
        return N;
    }
     public static int getMAX_SIZE() {
        return MAX_SIZE;
    }


    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(matriz);
        result = prime * result + N;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tablero other = (Tablero) obj;
        if (!Arrays.deepEquals(matriz, other.matriz))
            return false;
        if (N != other.N)
            return false;
        return true;
    }

    // Método para mostrar el estado actual del tablero
    public  void mostrarMatriz() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matriz[i][j].isEstaVivo()) {
                    System.out.print("\u25A0 ");
                } else {
                    System.out.print("\u25AB ");
                }

            }
            System.out.println();
        }
    }

    // Método que calcula la cantidad inicial de células vivas según un porcentaje
    public static int calcularVivasIniciales(int N) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Elija el porcentaje inicial de células vivas (0-100):");
        double porcentaje = teclado.nextDouble();

        // Validar que el porcentaje esté en el rango permitido
        while (porcentaje < 0 || porcentaje > 100) {
            System.out.println("Porcentaje inválido. Introduzca un valor entre 0 y 100:");
            porcentaje = teclado.nextDouble();
            teclado.nextLine(); // Limpiar buffer
        }

        double numCasillas = N * N;
        return (int) ((porcentaje * numCasillas) / 100.0);
    }

    // Metodo para colocar las celulas en el tablero de forma aleatoria
    public  void colocacionRandom() {
        Random r = new Random();
        int porcentaje = calcularVivasIniciales(N);
        int fila;
        int columna;
        do {

            fila = r.nextInt(matriz.length);
            columna = r.nextInt(matriz.length);
            matriz[fila][columna].setEstaVivo(true);

        } while (contarVivas(matriz) != porcentaje);

    }
    // Metodo para colocar las celulas en el tablero elijiendo la casilla

    public  void colocacionManual() {
        Scanner teclado = new Scanner(System.in);
        int porcentaje = calcularVivasIniciales(N);
        int fila;
        int columna;
        for (int i = 0; i < porcentaje; i++) {
            System.out.println("Indique la fila(1-N)");
            fila = teclado.nextInt();
            System.out.println("Indique la columna(1-N)");
            columna = teclado.nextInt();
            matriz[fila - 1][columna - 1].setEstaVivo(true);
        }
    }

    // Nos devuelve la cantidad de vivas en el tablero
    public static int contarVivas(Celula[][] matriz) {
        int cont = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].isEstaVivo() == true) {
                    cont++;

                }
            }
        }
        return cont;
    }

    // Metodo que nos dice si una celula esta viva o muerta
    public static boolean comprobarEstado(int fila, int columna, Celula[][] matriz) {
        return (matriz[fila][columna].isEstaVivo());
    }

    public Celula[][] getMatriz() {
        return matriz;
    }

    // metodo para comprobar si la posicion no esta fuera de la matriz
    public static boolean posicionValida(int fila, int columna, Celula[][] matriz) {
        return fila >= 0 && fila < matriz.length && columna >= 0 && columna < matriz[fila].length;
    }

    // metodo la imprimir las casillas de alrededor
    public  int contarVecina(int fila, int columna ) {
        boolean estado;
        int cont = 0;
        // recorro la fila anterio, lasuya y las posterior

        for (int i = fila - 1; i <= fila + 1; i++) {
            // recorro la columna anterio, lasuya y las posterior
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (posicionValida(i, j, matriz)) {

                    estado = comprobarEstado(i, j, matriz);
                    if (estado && !(i==fila && j==columna)) {
                        cont++;
                    }
                }

            }

        }
        return cont;

    }

    public void siguienteGeneracion(){
        Celula[][] nuevaMatriz = new Celula[N][N];
       
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                nuevaMatriz[i][j] = new Celula();
            }
        }
        
        int vecinoVivo = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                vecinoVivo = contarVecina(i, j);
                if (matriz[i][j].isEstaVivo()) {
                    if (vecinoVivo == 2 || vecinoVivo == 3) {
                        nuevaMatriz[i][j].setEstaVivo(true);
                    }else{
                        nuevaMatriz[i][j].setEstaVivo(false);
                    }
                }else{
                    if ( vecinoVivo == 3) {
                        nuevaMatriz[i][j].setEstaVivo(true);
                    }
                }
            }
        }

        comprobarMatrizRepe();
        this.generaciones++;
        this.poblacionPorGeneracion.add(contarVivas(nuevaMatriz));

        this.matriz = nuevaMatriz;
       
    }



    public boolean comprobarMatrizRepe() {
        lista_Matrizes.add(clonarMatriz(this.matriz));

        if (lista_Matrizes.size() > 3) {
            lista_Matrizes.remove(0);
        }

        if (lista_Matrizes.size() == 3) {
            if (Arrays.deepEquals(lista_Matrizes.get(0), lista_Matrizes.get(1)) &&
                Arrays.deepEquals(lista_Matrizes.get(1), lista_Matrizes.get(2))) {
                return false;
            }
        }

        return true;
    }
     public void guardar(String archivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println(N + " " + N);
            pw.println(generaciones);
            for (Celula[] fila : matriz) {
                for (Celula c : fila) {
                    pw.print((c.isEstaVivo() ? 1 : 0) + " ");
                }
                pw.println();
            }
            for (Object Gen : poblacionPorGeneracion) {
                pw.print(Gen + " ");
            }
            
            pw.println();
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    
    public static Tablero cargar(String archivo) {
        try (Scanner sc = new Scanner(new File(archivo))) {
            int filas = sc.nextInt();
            sc.nextInt();
            int gen = sc.nextInt();
            Tablero t = new Tablero(filas);
            t.generaciones = gen;

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < filas; j++) {
                    if (sc.nextInt() == 1) {
                        t.matriz[i][j].setEstaVivo(true);
                    }
                }
            }

            while (sc.hasNextInt()) {
                t.poblacionPorGeneracion.add(sc.nextInt());
            }

            return t;
        } catch (IOException e) {
            System.out.println("Error al cargar archivo.");
            return null;
        }
    }
    
}
