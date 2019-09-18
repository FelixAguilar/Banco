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
public class MetodosyDatos {

    private Cliente[] clientes = new Cliente[0];
    
    
    public Cliente apartado2(int id) throws ExcepcionCuentaNoExiste {
         Cliente cli = null;
         boolean endBucle = false;
         for (int i = 0; (i < clientes.length)&&(endBucle); i++) {
            for (int j = 0; j < clientes[j].getCuentas().length; j++) {
                if (clientes[i].getCuenta(j).getID() == id) {
                   cli = new Cliente(clientes[i].getNombre(),clientes[i].getCuenta(j).getSaldo(),clientes[i].getCuenta(j).getID());
                   endBucle = true;
                }

            }

        }
        if (cli == null) {
            throw new ExcepcionCuentaNoExiste();
        }
        return cli;
    }
}
