package com.problem;

public class Main {

    public static void main(String[] args) {
        // Tamaño del tablero
        int boardSize = 99;

        // Crear una instancia de BusquedaLocal
        BusquedaLocal ls = new BusquedaLocal(boardSize);
        Tablero t = ls.getTablero();

        // Inicializar los ataques de la solución inicial
        int ataques;

        // Crear la solución inicial
        Solucion solucionActual = new Solucion(boardSize);
        solucionActual.setPermutacion(t.getX());
        solucionActual.setAtaques(t.contarAtaques(solucionActual.getPermutacion()));

        // Imprimir la solución inicial
        System.out.println("Solución Inicial: " + solucionActual);

        do {
            // Crear una nueva solución modificada usando el método Tweak
            Solucion nuevaSolucion = ls.Tweak(solucionActual);

            // Si la nueva solución tiene menos ataques, se actualiza la solución actual
            if (nuevaSolucion.getAtaques() < solucionActual.getAtaques()) {
                solucionActual = nuevaSolucion;
                System.out.println("Nueva Solución con menos ataques: " + solucionActual);
            }

            // Obtener el número de ataques de la solución actual
            ataques = solucionActual.getAtaques();

        } while (ataques != 0); // Continuar iterando hasta que no haya ataques

        // Cuando se encuentre una solución sin ataques, imprimirla
        System.out.println("Solución sin ataques: " + solucionActual);
    }
}
