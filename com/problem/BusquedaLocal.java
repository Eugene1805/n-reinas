package com.problem;

import static com.problem.Aleatorio.rnd;

public class BusquedaLocal {

    private Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public BusquedaLocal(int size) {
        this.tablero = new Tablero(size);
    }

    /**
     * @return Regresa una configuración del problema con cero ataques
     */
    public Solucion Algoritmo() {
        Tablero t = new Tablero(tablero.getSize());
        Solucion s = new Solucion(t.getSize());

        return s;
    }

    /**
     * este método genera una perturbación a partir de una solución
     */
    Solucion Tweak(Solucion s){
        Solucion s1 = new Solucion(tablero.getSize());
        s1.setPermutacion(s.getPermutacion().clone());

        /*Genero dos puntos aleatorios del 0 al (boardSize-1)*/
        int p1 = rnd(0, tablero.getSize() - 1);
        int p2 = rnd(0, tablero.getSize() - 1);
        /*Con este ciclo me aseguro que p1 y p2 sean distintos*/
        while (p1 == p2) {
            p1 = rnd(0, tablero.getSize() - 1);
        }

        /*Ejecuto mi intercambio de valores de la permutación de la solución s*/
        int temp = s1.getPermutacion()[p1];
        s1.getPermutacion()[p1] = s1.getPermutacion()[p2];
        s1.getPermutacion()[p2] = temp;

        s1.setAtaques(tablero.contarAtaques(s1.getPermutacion()));

        return s1;
    }
}
