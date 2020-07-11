/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1a;

import excepciones.Validacion;
import lineales.*;


/**
 * @author lydia
 */

public class RunningSG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int opcion = 0;
        boolean flag = true;
        String respuesta = "SN";
        //ArrayColaOrdenada<Corredor> cola = new ArrayColaOrdenada();
        ArrayCola<Corredor> cola = new ArrayCola();

        do {
            System.out.println("MENÚ PRINCIPAL");

            System.out.println("1. Registrar tiempos");
            System.out.println("2. Mostrar datos (ESTADO INICIAl)");
            System.out.println("3. Mostrar ganador");
            System.out.println("4. Mostrar media (minutos)");

            System.out.println("5. Salir");

            System.out.println(" \n\nIntroduzca la opcion");

            try {
                opcion = MyInput.readInt();
            } catch (NumberFormatException e) {
                System.out.println("\nEl valor introducido es incorrecto");
            }
            switch (opcion) {

                case 1:
                    do {
                        try {
                            AñadirCorredor(cola);
                            System.out.println("¿Desea añadir otro corredor?");
                            respuesta = MyInput.readString();
                            respuesta = respuesta.toUpperCase();
                        } catch (Validacion e) {
                            System.out.println(e.getMessage() + "\n\n");

                        } catch (NumberFormatException e) {
                            System.out.println("El valor introducido no es válido\n\n");
                        }
                    } while (respuesta.charAt(0) == 'S');
                    break;

                case 2:
                    if (cola.esVacia()) {
                        System.out.println("\n No hay participantes\n");
                    } else {

                        System.out.println("DATOS INTRODUCIDOS");
                        System.out.println("------------------");
                        System.out.println("Circuito: Subida a San Cebrián");
                        System.out.println("Población: Fuentepelayo");
                        System.out.println("Fecha: 17 de Marzo de 2019");
                        System.out.println("Distancia: 11 Km");

                        System.out.println("\t\t\t CLASIFICACIÓN GENERAL");
                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Corredor/a\t\tTiempo total\t\t\tDiferencia de Tiempo");

                        MostrarDatos(cola);
                    }
                    break;

                case 3:
                    ArrayColaOrdenada<Corredor> colaAux = new ArrayColaOrdenada();
                    if (!cola.esVacia()) {
                        cola.encolar(null);
                        while (cola.primero() != null) {
                            Corredor aux = cola.desencolar();
                            colaAux.encolar(aux);
                            cola.encolar(aux);
                        }
                        cola.desencolar();
                        System.out.println("\n GANADOR");
                        Corredor ganador = colaAux.buscarGanador();
                        System.out.println("El ganador es:" + ganador.getNombre() + "\n\n");

                    } else {
                        System.out.println("\n No hay participantes\n");
                    }

                    break;

                case 4:
                    if (cola.esVacia()) {
                        System.out.println("\n No hay participantes\n");
                    } else {
                        float suma = 0;
                        float media = 0;

                        System.out.println("MEDIAS DE LOS PARTICIPANTES");
                        cola.encolar(null);
                        Corredor aux = cola.desencolar();
                        while (aux != null) {

                            suma = suma + aux.CalculoMedia();
                            cola.encolar(aux);
                            aux = cola.desencolar();

                        }
                        media = suma / cola.getTalla();
                        System.out.println(media + " minutos\n\n");
                    }

                    break;
                case 5:
                    ArrayColaOrdenada<Corredor> ColaAux = new ArrayColaOrdenada();

                    if (cola.esVacia()) {
                        System.out.println("\n No hay participantes\n");
                    } else {
                        System.out.println("DATOS INTRODUCIDOS");
                        System.out.println("------------------");
                        System.out.println("Circuito: Subida a San Cebrián");
                        System.out.println("Población: Fuentepelayo");
                        System.out.println("Fecha: 17 de Marzo de 2019");
                        System.out.println("Distancia: 11 Km");

                        System.out.println("\t\t\t CLASIFICACIÓN GENERAL ORDENADA");
                        System.out.println("-------------------------------------------------------------------------------");
                        System.out.println("Corredor/a\t\tTiempo total\t\tDiferencia de Tiempo (de menor a mayor)");
                        cola.encolar(null);
                        while (cola.primero() != null) {
                            Corredor aux = cola.desencolar();
                            ColaAux.encolar(aux);
                            cola.encolar(aux);
                        }
                        cola.desencolar();
                        MostrarDatosOrdenado(ColaAux.Ordenar());
                    }
                    flag = false;
            }

        } while (opcion < 1 || opcion > 5 || flag == true);

    }

    public static void AñadirCorredor(ArrayCola<Corredor> cola) throws Validacion {

        String nombre;
        int minutos;

        System.out.println("Nuevo Participante");
        System.out.println("------------------");

        System.out.println("Introduzca el nombre del participante:");
        nombre = MyInput.readString();
        if (!vNombreApellido(nombre)) {
            throw new Validacion("Nombre no valido");
        }
        System.out.println("Introduzca el tiempo (minutos)");
        minutos = MyInput.readInt();

        Corredor corredor = new Corredor(nombre, minutos);

        cola.encolar(corredor);

    }

    public static void MostrarDatos(ArrayCola<Corredor> cola) {
        ArrayColaOrdenada<Corredor> colaAux = new ArrayColaOrdenada();
        cola.encolar(null);
        while (cola.primero() != null) {
            Corredor aux = cola.desencolar();
            colaAux.encolar(aux);
            cola.encolar(aux);
        }
        cola.desencolar();
        Corredor ganador = colaAux.buscarGanador();
        cola.encolar(null);
        Corredor primero = cola.MostrarDatos(cola);
        while (primero != null) {
            System.out.println(primero.getNombre() + "\t\t\t" + primero.getTiempo() + "\t\t\t\t" + (primero.getTiempo() - ganador.getTiempo()));

            cola.encolar(primero);
            primero = cola.MostrarDatos(cola);

        }

    }

    public static void MostrarDatosOrdenado(ArrayCola<Corredor> cola) {
        Corredor ganador = cola.primero();
        Corredor primero = cola.MostrarDatos(cola);
        while (primero != null) {
            System.out.println(primero.getNombre() + "\t\t\t" + primero.getTiempo() + "\t\t\t\t" + (primero.getTiempo() - ganador.getTiempo()));

            cola.encolar(primero);
            primero = cola.MostrarDatos(cola);

        }
    }

    /**
     * Valida el nombre y el apellido introducido
     *
     * @param nombre
     * @return
     */
    public static boolean vNombreApellido(String nombre) {
        for (int i = 0; i < nombre.length(); i++) {
            if (!Character.isAlphabetic(nombre.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}
