package Ventana;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 */
public class Ventana extends JFrame {
    
    static Ventana v;
    
    /*Tamaño de la ventana. Obtenemos herramientas necesarias para comunicarnos 
    con el sistema donde se ejecuta la ventana. Creamos un objeto Dimension con 
    el tamaño de nuestra pantalla.*/
    Toolkit miPantalla = Toolkit.getDefaultToolkit(); 
    Dimension tamañoPantalla = miPantalla.getScreenSize(); 
        
    //Guardamos las constantes que se han registrado en el objeto Dimension.
    int alturaPantalla = tamañoPantalla.height; 
    int anchuraPantalla = tamañoPantalla.width;
    
    //Constantes del menú.
    private final String TITULO = "Banco.";
    private final String CREAR = "Crear cuenta nueva.";
    private final String BUSCARU = "Buscar cuentas por usuario.";
    private final String BUSCARC = "Buscar una cuenta.";
    private final String METER = "Añadir fondos a una cuenta.";
    private final String SACAR = "Extraer fondos a una cuenta.";
    private final String ELIMINAR = "Eliminar una cuenta.";
    private final String SALIR = "Salir del banco.";
    private final Font FUENTE = new Font("serif", Font.BOLD, 20);
    
    /**
     * Constructor de la ventana.
     */
    public Ventana(){
        setTitle(TITULO);
        setSize(anchuraPantalla/2,alturaPantalla/2);
        setLocation(anchuraPantalla/4, alturaPantalla/4);
        setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        initContents();
    }
    
    private void initContents(){
        
        //Creación del Layout principal.
        JPanel ventana = (JPanel) getContentPane();
        
        //Creación del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        
        //Boton de crear cuenta.
        JButton botonCrear = new JButton();
        botonCrear.setText(CREAR);
        botonCrear.setFont(FUENTE);
        menu.add(botonCrear);
        
        //Boton de buscar por cuenta.
        JButton botonBuscarPorUsuario = new JButton();
        botonBuscarPorUsuario.setText(BUSCARU);
        botonBuscarPorUsuario.setFont(FUENTE);
        menu.add(botonBuscarPorUsuario);
        
        //Boton de buscar por usuario.
        JButton botonBuscarPorCuenta = new JButton();
        botonBuscarPorCuenta.setText(BUSCARC);
        botonBuscarPorCuenta.setFont(FUENTE);
        menu.add(botonBuscarPorCuenta);
        
        //Boton de ingresar dinero a cuenta.
        JButton botonIngresar = new JButton();
        botonIngresar.setText(METER);
        botonIngresar.setFont(FUENTE);
        menu.add(botonIngresar);

        //Boton de extraer dinero de cuenta.
        JButton botonExtraer = new JButton();
        botonExtraer.setText(SACAR);
        botonExtraer.setFont(FUENTE);
        menu.add(botonExtraer);
        
        //Boton de eliminar cuenta.
        JButton botonEliminar= new JButton();
        botonEliminar.setText(ELIMINAR);
        botonEliminar.setFont(FUENTE);
        menu.add(botonEliminar);
        
        //Boton de salir.
        JButton botonSalir= new JButton();
        botonSalir.setText(SALIR);
        botonSalir.setFont(FUENTE);
        menu.add(botonSalir);
        
        //Adición de componentes a la pantalla.
        ventana.add(menu, BorderLayout.CENTER);
        
        //Escuchadores de eventos.
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                añadirCuentaVentana();
            }
        });
        
        botonBuscarPorUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                buscarPorClienteVentana();
            }
        });
        
        botonBuscarPorCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                buscarPorCuentaVentana();
            }
        });
        
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                añadirFondosVentana();
            }
        });
        
        botonExtraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                retirarFondosVentana();
            }
        });
        
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                eliminarCuentaVentana();
            }
        });
        
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                v.dispatchEvent(new WindowEvent(v, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
    
    public static void main(String[] args) {
        v = new Ventana();
        v.setVisible(true);
    }
    
    public void añadirCuentaVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(CREAR);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoNombre = new JLabel("Nombre:");
        JTextField nombre = new JTextField();
        linea1.add(infoNombre);
        linea1.add(nombre);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoSaldo = new JLabel("Saldo Inicial:");
        JTextField saldo = new JTextField();
        linea2.add(infoSaldo);
        linea2.add(saldo);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea3.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        menu.add(linea3);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
                errorExisteClienteVentana();
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void buscarPorClienteVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(BUSCARU);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoUsuario = new JLabel("Nombre de cliente:");
        JTextField usuario = new JTextField();
        linea1.add(infoUsuario);
        linea1.add(usuario);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea2.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void buscarPorCuentaVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(BUSCARC);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("ID de la cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea2.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void añadirFondosVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(METER);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("ID de cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoFondos = new JLabel("Fondos a añadir:");
        JTextField fondos = new JTextField();
        linea2.add(infoFondos);
        linea2.add(fondos);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea3.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        menu.add(linea3);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void retirarFondosVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(SACAR);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("ID de cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoFondos = new JLabel("Fondos a retirar:");
        JTextField fondos = new JTextField();
        linea2.add(infoFondos);
        linea2.add(fondos);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea3.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        menu.add(linea3);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void eliminarCuentaVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle(ELIMINAR);
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
                
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoUsuario = new JLabel("Usuario:");
        JTextField usuario = new JTextField();
        linea2.add(infoUsuario);
        linea2.add(usuario);
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("ID de cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea3.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        menu.add(linea3);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });        
    }
    
    public void Popup(JFrame f, String mensaje){
        JOptionPane.showMessageDialog(f, mensaje);
    }
    
    public void errorExisteClienteVentana(){
        JFrame frame = new JFrame();
        frame.setSize(anchuraPantalla/4,alturaPantalla/7);
        frame.setLocation(anchuraPantalla/4, alturaPantalla/4);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setTitle("Problema encontrado.");
        
        //Creación del layout del menú.
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel info = new JLabel("Ya existe un usuario con este nombre, quieres añadirle esta cuenta?");
        linea1.add(info);
        
        //Boton de crear cuenta.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);

        //Boton de cancelar operacion.
        JButton botonCancelar = new JButton();
        botonCancelar.setText("Cancelar");
        linea2.add(botonCancelar);

        //Adición de componentes a la pantalla.
        menu.add(linea1);
        menu.add(linea2);
        frame.add(menu, BorderLayout.CENTER);

        frame.setVisible(true);

        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Metodo a ejecutar  va aqui.
            }
        });

        //Escuchadores de eventos.
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        });           
    }
}