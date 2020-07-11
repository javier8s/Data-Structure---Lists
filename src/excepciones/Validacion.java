/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 * @author lydia
 */
public class Validacion extends Exception {

    /**
     * Muestra el mensaje que se recibe
     *
     * @param descripcion
     */
    public Validacion(String descripcion) {
        super(descripcion);
    }


}
