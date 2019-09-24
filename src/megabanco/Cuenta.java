package megabanco;

/**
 *
 * @author Felix Lluis Aguilar Ferrer, Adrian Bennassar Polzin.
 */
public class Cuenta {
    private int id, saldo;

    public Cuenta( int id, int saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public int getID() {
        return id;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public void añadirSaldo(int tranf) throws ExceptionTransferencia {
        if ((this.saldo+tranf)<0){
           throw new ExceptionTransferencia(); 
        }
        this.saldo = this.saldo+tranf;
    }
    
    
}
