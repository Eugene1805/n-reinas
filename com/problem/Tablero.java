package com.problem;

import java.util.Arrays;

public class Tablero {
    private int size;
    private int evals = 0;
    private Solucion s;
    private int[] x;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getEvals() {
        return evals;
    }

    public void setEvals(int evals) {
        this.evals = evals;
    }

    public Solucion getS() {
        return s;
    }

    public void setS(Solucion s) {
        this.s = s;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public Tablero(int size) {
        this.size = size;
        init();
    }

    private void init() {
        s = new Solucion(size);
        s.setPermutacion(Aleatorio.getPermutacion(getSize()));
        s.setAtaques(contarAtaques(s.getPermutacion()));
        evals++;
        x = Arrays.copyOf(s.getPermutacion(),getSize());
    }

    public int contarAtaques(int[] permutacion) {
        int ataques = 0;
        int n = permutacion.length;
        /**
         * Se obtiene la matriz con el tablero
         * el tablero contiene 1 donde hay reina y 0 en caso
         * contrario
         */
        int[][] board = getTablero(permutacion);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) { // hay una reina
                    // 1. Buscar en diagonal inferior derecha
                    for (int k = 1; i + k < n && j + k < n; k++) {
                        if (board[i + k][j + k] == 1) {
                            ataques++;
                        }
                    }

                    // 2. Buscar en diagonal inferior izquierda
                    for (int k = 1; i + k < n && j - k >= 0; k++) {
                        if (board[i + k][j - k] == 1) {
                            ataques++;
                        }
                    }

                    // 3. Buscar en diagonal superior derecha
                    for (int k = 1; i - k >= 0 && j + k < n; k++) {
                        if (board[i - k][j + k] == 1) {
                            ataques++;
                        }
                    }

                    // 4. Buscar en diagonal superior izquierda
                    for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
                        if (board[i - k][j - k] == 1) {
                            ataques++;
                        }
                    }
                }
            }
        }
        return ataques;
    }

    private int[][] getTablero(int[] permutacion) {
        int boardSize = permutacion.length;
        int[][] board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = (permutacion[i] == j) ? 1 : 0;
            }
        }
        return board;
    }
}
