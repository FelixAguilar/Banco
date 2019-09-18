package megabanco;

/**
 *
 * @author Felix Lluis Aguilar Ferrer, Adrian Bennassar Polzin.
 */
public class ExceptionTransferencia extends Exception{

    public ExceptionTransferencia() {
        super("Saldo negativo");
    }
}
