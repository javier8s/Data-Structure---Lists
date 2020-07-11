package practica1a;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.io.*;
import java.util.ArrayList;

/**
 * @author lydia
 */
public class MyInput {
//Lee una cadena de caracteres desde el teclado

    /**
     * @return
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return string;
    }
//Lee un dato tipo int desde el teclado

    /**
     * @return
     * @throws NumberFormatException
     */
    public static int readInt() throws NumberFormatException {

        return Integer.parseInt(readString());

    }
//Lee un dato tipo double desde el teclado

    /**
     * @return
     */
    public static double readDouble() {
        return Double.parseDouble(readString());
    }
//Lee un dato tipo byte desde el teclado

    /**
     * @return
     */
    public static byte readByte() {
        return Byte.parseByte(readString());
    }
//Lee un dato tipo short desde el teclado

    /**
     * @return
     */
    public static short readShort() {
        return Short.parseShort(readString());
    }
//Lee un dato tipo long desde el teclado

    /**
     * @return
     */
    public static long readLong() {
        return Long.parseLong(readString());
    }
//Lee un dato tipo float desde el teclado

    /**
     * @return
     */
    public static float readFloat() {
        return Float.parseFloat(readString());
    }

    /**
     * @param nombreFichero
     * @return
     */
    public static ArrayList<String> leeFichero(String nombreFichero) throws FileNotFoundException {
        ArrayList<String> v = new ArrayList<String>();
        File fichero = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fichero = new File(nombreFichero);
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                v.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return v;
    }
}

