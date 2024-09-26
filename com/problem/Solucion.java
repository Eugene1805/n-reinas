package com.problem;

import java.util.Arrays;

/**
 *
 * @author sdi
 */
public class Solucion implements Comparable<Solucion>{

    private int[] permutacion;
    private int ataques;

    public Solucion(int D) {
        permutacion = new int[D];
    }

    public int[] getPermutacion() {
        return permutacion;
    }

    public void setPermutacion(int[] permutacion) {
        this.permutacion = permutacion;
    }

    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    @Override
    public int compareTo(Solucion t) {
        //orden descendente
        return Integer.compare(t.getAtaques(), ataques);
    }

    @Override
    public String toString(){
        return Arrays.toString(getPermutacion())+" "+ataques;
    }



}
