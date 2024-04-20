package org.example;

import java.util.Scanner;

public class Main
{

//Multiplicar matriz de 2x3 con 3x2
    public static void main(String[] args)

    {
        Scanner scanner = new Scanner(System.in);

        // Obtener las dimensiones de la primera matriz
        System.out.println("Ingrese las dimensiones de la primera matriz:");
        int rows1 = obtenerDimension("filas", scanner);
        int cols1 = obtenerDimension("columnas", scanner);

        // Obtener las dimensiones de la segunda matriz
        System.out.println("Ingrese las dimensiones de la segunda matriz:");
        int rows2 = obtenerDimension("filas", scanner);
        int cols2 = obtenerDimension("columnas", scanner);

        // Verificar si es posible multiplicar las matrices
        if (cols1 != rows2) {
            System.out.println("No se pueden multiplicar las matrices. El número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz.");
            return;
        }

        // Inicializar las matrices
        int[][] matriz1 = nuevaMatriz("primera", rows1, cols1, scanner);
        int[][] matriz2 = nuevaMatriz("segunda", rows2, cols2, scanner);

        // Multiplicar las matrices
        int[][] resultado = multiplicarMatrices(matriz1, matriz2);

        // Imprimir el resultado
        System.out.println("El resultado de la multiplicación es:");
        imprimirMatriz(resultado);

        scanner.close();
    }

    // Método para obtener la dimensión de la matriz (filas o columnas)
    public static int obtenerDimension(String tipo, Scanner scanner) {
        System.out.print("Ingrese el número de " + tipo + ": ");
        return scanner.nextInt();
    }

    // Método para crear una nueva matriz
    public static int[][] nuevaMatriz(String nombre, int rows, int cols, Scanner scanner) {
        System.out.println("Ingrese los elementos de la " + nombre + " matriz:");
        int[][] matriz = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Ingrese el elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        return matriz;
    }

    // Método para multiplicar dos matrices
    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int rows1 = matriz1.length;
        int cols1 = matriz1[0].length;
        int cols2 = matriz2[0].length;

        int[][] resultado = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    // Método para imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        int rows = matriz.length;
        int cols = matriz[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }


}