package megabanco;

/**
 *
 * @author Felix Lluis Aguilar Ferrer, Adrian Bennassar Polzin.
 */
public class Cuenta {
    private String cliente;
    private int numeroCuenta, saldo;

    public Cuenta(String cliente, int numeroCuenta, int saldo) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void addSaldo(int tranf) throws ExceptionTransferencia {
        if ((this.saldo+tranf)<0){
           throw new ExceptionTransferencia(); 
        }
        this.saldo = this.saldo+tranf;
    }
    
    
}
