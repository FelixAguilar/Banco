/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megabanco;

/**
 *
 * @author Adrián
 */
public class ExcepcionCuentaNoEncontrada extends Exception{
    
        public ExcepcionCuentaNoEncontrada() {
            super("Cliente no encontrado en la base de datos");
    } 
}
