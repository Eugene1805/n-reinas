package com.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aleatorio {

    public static int rnd(int low, int high) {
        int i;
        if (low >= high) {
            i = low;
        } else {
            i = (int) ((Math.random() * (high - low + 1)) + low);
            if (i > high) {
                i = high;
            }
        }
        return (i);
    }

    public static int[] getPermutacion(int boardSize){
        int[] permutacion = new int[boardSize];
        List<Integer> T = new ArrayList();
        /*Genero una lista con números del 0 al tamaño del tablero*/
        for(int i = 0; i < boardSize; i++){
            T.add(i);
        }
        /**
         * Usando el método shuffle obtengo una permutación aleatoria
         * de mi lista generada anteriormente
         */
        Collections.shuffle(T);
        /**
         * este ciclo sólo lo utilizo para transferir mi lista
         * permutada a un arreglo
         */
        for(int i = 0; i < boardSize; i++){
            permutacion[i] = T.get(i);
        }
        return permutacion;

    }
}
