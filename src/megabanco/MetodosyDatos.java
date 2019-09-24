package megabanco;

/**
 * Clase que contiene todos los métodos para el funcionamiento del banco.
 * 
 @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 */
public class MetodosyDatos {

    // Lista clientes.
    private Cliente[] clientes = new Cliente[0];

    /**
     * Método para añadir un cliente o cuenta a la lista de clientes.
     * 
     * @param nom
     * @param sal
     * @return
     * @throws ExceptionClienteExistente 
     */
    public String apartado1(String nom, int sal) throws ExceptionClienteExistente {
        String s="";
        int ID = generadorID();
        try {
            int ind = buscarCliente(nom);
            clientes[ind].redimensionarArrayCuentas(false, 1);
            clientes[ind].setCuenta(clientes[ind].getCuentas().length - 1, new Cuenta(ID, sal));
            s += "Cuenta añadida a cliente existente.\n";
            s += "Nombre cuenta: " + clientes[ind].getNombre() + ".\n";
            s += "ID Cuenta: " + clientes[ind].getCuentas()[clientes[ind].getCuentas().length-1].getID() + ".\n";
            s += "Saldo: " + clientes[ind].getCuentas()[clientes[ind].getCuentas().length-1].getSaldo() + ".\n";
            
        } catch (ExcepcionClienteNoEncontrado ex) {
            redimensionarArrayCli(false, 1);
            clientes[clientes.length - 1] = new Cliente(nom, sal,ID );
            s += "Cuenta añadida a cliente nuevo.\n";
            s += "Nombre cuenta: " + clientes[clientes.length-1].getNombre() + ".\n";
            s += "ID Cuenta: " + clientes[clientes.length-1].getCuentas()[0].getID() + ".\n";
            s += "Saldo: " + clientes[clientes.length-1].getCuentas()[0].getSaldo() + ".\n";
            
        }
        return s;
    }
    
    /**
     * Método que dada una cuenta muestra información sobre ésta.
     * 
     * @param id
     * @return
     * @throws ExcepcionCuentaNoExiste 
     */
    public Cliente apartado2(int id) throws ExcepcionCuentaNoExiste {
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
    
    /**
     * Método que dado un cliente muestra todas las cuentas asociadas.
     * 
     * @param nombreCliente
     * @return
     * @throws ExcepcionClienteNoEncontrado 
     */
    public String apartado3(String nombreCliente) throws ExcepcionClienteNoEncontrado {
        String salida = null;
        int indice;
        indice = buscarCliente(nombreCliente);
        for (int i = 0; i < clientes[indice].getCuentas().length; i++) {
            salida += "Cuenta " + clientes[indice].getCuenta(i).getID() + ": Saldo: "
                    + clientes[indice].getCuenta(i).getSaldo() + "\n";
        }
        return salida;
    }
    
    /**
     * Método para añadir o quitar saldo de una cuenta.
     * 
     * @param ID
     * @param sal
     * @param añadir
     * @throws ExceptionTransferencia
     * @throws ExcepcionCuentaNoEncontrada 
     */
public String apartado4y5(int ID, int sal, boolean añadir) throws ExceptionTransferencia, ExcepcionCuentaNoEncontrada{
        if(sal<=0){
            throw new ExceptionTransferencia();
        }
        boolean fin = false;
        for (int i = 0; i < clientes.length && !fin ; i++) {
            try {
                int ind=buscarCuenta(i,ID);
                fin=true;
                if(!añadir){
                    sal=-sal;
                }
                clientes[i].getCuenta(ind).actualizarSaldo(sal);
                return "El saldo de la cuenta " + ID + "es: " + clientes[i].getCuenta(ind).getSaldo();
            } catch (ExcepcionCuentaNoEncontrada ex) {}
        }
            throw new ExcepcionCuentaNoEncontrada();
    }
    
/**
     * Método dada una cuenta borra esta, y si el cliente se queda sin cuentas
     * borra el cliente también.
     * 
     * @param nombreCliente
     * @param idCuenta
     * @return 
     * @throws ExcepcionClienteNoEncontrado
     * @throws ExcepcionCuentaNoEncontrada 
     */
    public String apartado6(String nombreCliente, int idCuenta) throws ExcepcionClienteNoEncontrado, ExcepcionCuentaNoEncontrada {
        int indice = buscarCliente(nombreCliente);
        int indiceCuenta = buscarCuenta(idCuenta, indice);
        clientes[indice].redimensionarArrayCuentas(true, indiceCuenta);
        if (clientes[indice].getCuentas().length == 0) {
            redimensionarArrayCli(true, indice);
            return "El cliente ha sido borrado con éxito";
        }
        return "La cuenta ha sido borrado con éxito";
    }
    
    /**
     * Método que genera una ID única nueva para una cuenta.
     * 
     * @return 
     */
    private int generadorID() {
        int ID = 0;
        for (Cliente cliente : clientes) {
            for (Cuenta cuenta : cliente.getCuentas()) {
                if(ID<cuenta.getID()){
                    ID=cuenta.getID();
                }
            }
        }
        return ID+1;
    }

    /**
     * Método utilizado para buscar un cliente en concreto, si no lo encuentra
     * lanza una excepción.
     * 
     * @param nombreCliente
     * @return
     * @throws ExcepcionClienteNoEncontrado 
     */
    private int buscarCliente(String nombreCliente) throws ExcepcionClienteNoEncontrado {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNombre().equals(nombreCliente)) {
                return i;
            }
        }
        throw new ExcepcionClienteNoEncontrado();
    }

    
    /**
     * Método utilizado para buscar un cliente en concreto, si no la encuentra
     * lanza una excepción.
     * 
     * @param id
     * @param indiceCliente
     * @return
     * @throws ExcepcionCuentaNoEncontrada 
     */
    private int buscarCuenta(int id, int indiceCliente) throws ExcepcionCuentaNoEncontrada {
        for (int i = 0; i < 10; i++) {
            if (clientes[indiceCliente].getCuentas()[i].getID() == id) {
                return i;
            }
        }
        throw new ExcepcionCuentaNoEncontrada();
    }

    /**
    * Método que permite realizar dos acciones sobre el array clientes:
    *   1.- Eliminar una posición marcada por índice del array.
    *   2.- Añade tantas posiciones como marca el índice al array.
    * 
    * @param eliminar
    * @param indice 
    */
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
