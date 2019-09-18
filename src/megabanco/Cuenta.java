package megabanco;

/**
 *
 * @author Felix Lluis Aguilar Ferrer, Adrian Bennassar Polzin.
 */
public class Cuenta {
    private int numeroCuenta, saldo;

    public Cuenta( int numeroCuenta, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
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
