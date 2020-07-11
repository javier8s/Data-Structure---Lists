/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales;

import modelos.ColaOrdenada;

/**
 * @author lydia
 */
public class ArrayColaOrdenada<E extends Comparable<E>> extends ArrayCola<E> implements ColaOrdenada<E> {


    public ArrayColaOrdenada<E> Ordenar() {
        ArrayColaOrdenada<E> colaAux = new ArrayColaOrdenada();

        boolean flag = false;
        this.encolar(null);
        while (this.primero() != null) {
            if (colaAux.esVacia()) {
                this.encolar(this.primero());
                E aux = (E) this.desencolar();

                if (aux.compareTo((E) this.primero()) < 0) {//El menor es aux
                    colaAux.encolar(aux);
                    this.encolar(this.primero());
                    colaAux.encolar((E) this.desencolar());

                } else {
                    this.encolar(this.primero());
                    colaAux.encolar((E) this.desencolar());
                    colaAux.encolar(aux);
                }
                colaAux.encolar(null);
            } else {

                E aux = colaAux.desencolar();
                while (aux != null) {
                    if (aux.compareTo((E) this.primero()) < 0) {//el menor es aux
                        colaAux.encolar(aux);
                        aux = colaAux.desencolar();
                    } else {
                        this.encolar(this.primero());
                        colaAux.encolar((E) this.desencolar());
                        flag = true;
                        colaAux.encolar(aux);
                        aux = colaAux.desencolar();
                        while (aux != null) {
                            colaAux.encolar(aux);
                            aux = colaAux.desencolar();
                        }
                    }

                }
                if (aux == null) {
                    if (flag == false) {
                        this.encolar(this.primero());
                        colaAux.encolar((E) this.desencolar());

                    }
                    colaAux.encolar(aux);
                    flag = false;
                }

            }

        }
        this.desencolar();

        return colaAux;
    }

    public E buscarGanador() {

        return (E) this.Ordenar().primero();
    }


}
