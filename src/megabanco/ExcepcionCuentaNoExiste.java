/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megabanco;

/**
 *
 * @author iespa
 */
public class ExcepcionCuentaNoExiste extends Exception {
    public ExcepcionCuentaNoExiste() {
        super ("La cuenta no existe en la base de datos.");
    }
}
