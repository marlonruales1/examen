package org.example;
import java.util.Random;
import java.util.Scanner;

public class tableroUno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int[][] tableroUno = new int[10][10]; //numeros aleatorios
        char[][] tableroX = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tableroUno [i][j] = random.nextInt(100) + 1;  // nums  del 1 al 100
                tableroX[i][j] = 'X'; // Tablero  X
            }
        }

        System.out.println("Tablero Uno X:");
        imprimirTableroX(tableroX);

        // Ingresa 10 numeros
        System.out.println("Ingresa 10 números:");
        int[] numerosUsuario = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Número" + (i + 1) + ":");
            numerosUsuario[i] = scanner.nextInt();
        }

        int aciertos = 0;
        for (int num : numerosUsuario) {
            if (existeNum(tableroUno, num)) {
                aciertos++;
                actualizarTablero(tableroX, tableroUno, num);
            }
        }
        System.out.println("Tablero Acertados:");
        imprimirTableroX(tableroX);

        System.out.println("Has acertado " + aciertos + " número(s)!");
    }

    // Ftablero impreso
    public static void imprimirTableroX(char[][] tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    // comprobar
    public static boolean existeNum(int[][] tablero, int num) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void actualizarTablero(char[][] tableroX, int[][] tableroNumeros, int num) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tableroNumeros[i][j] == num) {
                    tableroX[i][j] = (char) (num + '0');
                }
            }
        }
    }
}

