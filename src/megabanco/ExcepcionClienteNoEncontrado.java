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
public class ExcepcionClienteNoEncontrado extends Exception{
    
    public ExcepcionClienteNoEncontrado() {
        super("Cliente no encontrado en la base de datos");
    }
    
}
