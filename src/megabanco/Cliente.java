package megabanco;

import megabanco.Cuenta;

/**
 *
 * @author felix
 */
public class Cliente {

    private String nombre;
    private Cuenta[] cuentas;

    public Cliente(String nombre, int saldo, int idCuenta) {
        this.nombre = nombre;
        this.cuentas = new Cuenta[1];
        cuentas[0] = new Cuenta(idCuenta, saldo);
    }

    public String getNombre() {
        return nombre;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuenta(int indice, Cuenta cuenta) {
        cuentas[indice]=cuenta;
    }

    public Cuenta getCuenta(int indice) {
        return cuentas[indice];
    }

    public void redimensionarArrayCuentas(boolean eliminar, int indice) {

        if (eliminar) {

            Cuenta[] temporal = new Cuenta[this.cuentas.length - 1];

            for (int i = 0; i < temporal.length; i++) {
                if (indice < i) {
                    temporal[i] = this.cuentas[i];
                } else {
                    temporal[i] = this.cuentas[i + 1];
                }
            }

            this.cuentas = temporal;
        } else {
            Cuenta[] temporal = new Cuenta[this.cuentas.length + indice];

            for (int i = 0; i < this.cuentas.length; i++) {
                temporal[i] = this.cuentas[i];
            }

            this.cuentas = temporal;
        }

    }

}
