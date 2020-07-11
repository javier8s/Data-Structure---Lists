/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales;

import modelos.*;

/**
 * @author lydia
 */
public class ArrayCola<E> implements Cola<E> {

    protected E elArray[];
    protected int fin, primero, tallaActual;
    protected static final int CAPACIDAD_POR_DEFECTO = 10;

    public ArrayCola() {
        elArray = (E[]) new Object[CAPACIDAD_POR_DEFECTO];
        tallaActual = 0;
        primero = 0;
        fin = -1;//elArray.length - 1;
    }

    private void duplicarArray() {
        E nuevoArray[] = (E[]) new Object[elArray.length * 2];
        for (int i = 0; i < tallaActual; i++, primero = aumentar(primero)) {
            nuevoArray[i] = elArray[primero];
        }
        elArray = nuevoArray;
        primero = 0;
        fin = tallaActual - 1;

    }

    private int aumentar(int indice) {
        if (++indice == elArray.length) {
            indice = 0;
        }
        return indice;
    }

    @Override
    public void encolar(E x) {
        if (tallaActual == elArray.length) {
            duplicarArray();
        }
        fin = aumentar(fin);
        elArray[fin] = x;
        tallaActual++;

    }

    @Override
    public E desencolar() {
        E Primero = elArray[primero];
        primero = aumentar(primero);
        tallaActual--;
        return Primero;
    }

    @Override
    public E primero() {
        return elArray[primero];
    }

    @Override
    public boolean esVacia() {
        if (tallaActual == 0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        String cad = "";
        int aux = primero;
        for (int i = 0; i < tallaActual; i++, aux = aumentar(aux)) {
            cad += elArray[aux] + "";

        }
        return cad;
    }

    public int getTalla() {
        return tallaActual;
    }

    public E MostrarDatos(ArrayCola<E> cola) {

        E elemento = cola.desencolar();

        if (elemento == null) {
            return null;
        } else {
            return elemento;
        }

    }


}
