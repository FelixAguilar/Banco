/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megabanco;

/**
 *
 * @author Adrián & Álvaro
 */
public class MetodosyDatos {

    private Cliente[] clientes = new Cliente[0];
    private int posCli = 0;

    public MetodosyDatos() {
    };
    
    
    public Cliente buscarCuenta(int id) throws ExcepcionCuentaNoExiste {
        Cliente cli = null;
        boolean endBucle = false;
        for (int i = 0; (i < clientes.length) && (endBucle); i++) {
            for (int j = 0; j < clientes[j].getCuentas().length; j++) {
                if (clientes[i].getCuenta(j).getID() == id) {
                    cli = new Cliente(clientes[i].getNombre(), clientes[i].getCuenta(j).getSaldo(), clientes[i].getCuenta(j).getID());
                    endBucle = true;
                }

            }

        }
        if (cli == null) {
            throw new ExcepcionCuentaNoExiste();
        }
        return cli;
    }


    /*Método para comprobar si un cliente pasado por parámetro ya existe en el 
    array de clientes*/
    public boolean clienteExistente(String nom) {
        boolean existe = false;
        for (int i = 0; i < posCli; i++) {
            if (nom.equals(clientes[i].getNombre())) {
                existe = true;
            }
        }
        return existe;

    }

    /*Método para comprobar hay algún cliente dentro del array de clientes*/
    public boolean hayClientes() {
        boolean hayCli = false;
        if (clientes[0] != null) {
            hayCli = true;

        }
        return hayCli;
    }

    /*Método para crear un nuevo cliente*/
    public Cliente nuevoCliente(String nom, int sal) {
        int idIni = posCli;
        Cliente cli = new Cliente(nom, sal, idIni);

        try {
            redimensionarArrayCli(false, 1);
            if (hayClientes()) {
                if (clienteExistente(nom)) {
                    throw new ExceptionClienteExistente();
                }
            }
            clientes[posCli] = cli;
            posCli++;
        } catch (ExceptionClienteExistente e) {
            System.out.println("\nERROR: Cliente Existente!");
        }
        return cli;

    }

    /*Método para imprimir los clientes existentes por pantalla*/
    public void clientesToString() {

        for (int i = 0; i < clientes.length; i++) {
            System.out.println(clientes[i]);
        }
    }

    /*Método para redimensionar el array de clientes*/
    private void redimensionarArrayCli(boolean eliminar, int indice) {

        if (eliminar) {

            Cliente[] temporal = new Cliente[this.clientes.length - 1];

            for (int i = 0; i < temporal.length; i++) {
                if (indice < i) {
                    temporal[i] = this.clientes[i];
                } else {
                    temporal[i] = this.clientes[i + 1];
                }
            }

            this.clientes = temporal;
        } else {
            Cliente[] temporal = new Cliente[this.clientes.length + indice];

            for (int i = 0; i < this.clientes.length; i++) {
                temporal[i] = this.clientes[i];
            }

            this.clientes = temporal;
        }

    }
}
