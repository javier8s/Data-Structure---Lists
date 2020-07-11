/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1a;

/**
 * @author lydia
 */
public class Corredor implements Comparable<Corredor> {

    String nombre;
    int minutos;

    public Corredor(String nombre, int minutos) {
        this.nombre = nombre;
        this.minutos = minutos;

    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempo() {
        return minutos;
    }

    @Override
    public int compareTo(Corredor aux) {
        if (this.minutos < aux.minutos) {
            return -1;
        } else {
            return 1;
        }
    }

    public int CalculoMedia() {
        int suma = 0;

        suma = suma + minutos;

        return suma;

    }
}
