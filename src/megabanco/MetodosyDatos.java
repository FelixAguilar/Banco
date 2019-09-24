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
    
     public String apartado3(String nombreCliente) throws ExcepcionClienteNoEncontrado{
        String salida = null;
        int indice;
        indice = buscarCliente(nombreCliente);
        for (int i = 0; i < clientes[indice].getCuentas().length; i++) {
            salida += "Cuenta " + clientes[indice].getCuenta(i).getID() + ": Saldo: " + 
                    clientes[indice].getCuenta(i).getSaldo() + "\n";
        }
        return salida;
    }
     
    public void apartado6(String nombreCliente, int idCuenta) throws ExcepcionClienteNoEncontrado, ExcepcionCuentaNoEncontrada{
        int indice = buscarCliente(nombreCliente);
        int indiceCuenta = encontrarCuenta(idCuenta, indice);
        clientes[indice].redimensionarArrayCuentas(true, indiceCuenta);
            if (clientes[indice].getCuentas().length == 0) {
                redimensionarArrayCli(true, indice);
            }
    }
    
    private int buscarCliente(String nombreCliente) throws ExcepcionClienteNoEncontrado{
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNombre().equals(nombreCliente)) {
                return i;
            }
        }
        throw new ExcepcionClienteNoEncontrado();
   } 
    
    public int encontrarCuenta(int id, int indiceCliente) throws ExcepcionCuentaNoEncontrada{
        for (int i = 0; i < 10; i++) {
            if(clientes[indiceCliente].getCuentas()[i].getID() == id){
                return i;
            }
        }
        throw new ExcepcionCuentaNoEncontrada();
    }
    
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
