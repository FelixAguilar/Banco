package Ventana;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Felix Aguilar Ferrer, Adrian Bennassar Polzin, Alvaro Bueno Lopez.
 */
public class Ventana extends JFrame {
    
    //Constantes del menú.
    private final String TITULO = "Banco";
    private final String CREAR = "Crear cuenta nueva";
    private final String BUSCARU = "Buscar un usuario";
    private final String BUSCARC = "Buscar una cuenta";
    private final String METER = "Añadir fondos";
    private final String SACAR = "Extraer fondos";
    private final String ELIMINAR = "Eliminar una cuenta";
    private final String SALIR = "Salir del banco";
    
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setVisible(true);
    }

    public Ventana() {
        this.setTitle(TITULO);
        this.setDefaultCloseOperation(Ventana.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.initContents();
        this.pack();
    }
    
    private void initContents(){
        JPanel menu = (JPanel) getContentPane();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;

        add(new JLabel("<html><h1><strong><i>"+ TITULO +"</i></strong></h1><hr></html>"), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel butones = new JPanel(new GridBagLayout());

        //Boton de crear cuenta.
        JButton botonCrear = new JButton();
        botonCrear.setText(CREAR);
        butones.add(botonCrear, gbc);

        //Boton de buscar por cuenta.
        JButton botonBuscarPorUsuario = new JButton();
        botonBuscarPorUsuario.setText(BUSCARU);
        butones.add(botonBuscarPorUsuario, gbc);

        //Boton de buscar por usuario.
        JButton botonBuscarPorCuenta = new JButton();
        botonBuscarPorCuenta.setText(BUSCARC);
        butones.add(botonBuscarPorCuenta, gbc);

        //Boton de ingresar dinero a cuenta.
        JButton botonIngresar = new JButton();
        botonIngresar.setText(METER);
        butones.add(botonIngresar, gbc);

        //Boton de extraer dinero de cuenta.
        JButton botonExtraer = new JButton();
        botonExtraer.setText(SACAR);
        butones.add(botonExtraer, gbc);

        //Boton de eliminar cuenta.
        JButton botonEliminar= new JButton();
        botonEliminar.setText(ELIMINAR);
        butones.add(botonEliminar, gbc);

        //Boton de salir.
        JButton botonSalir= new JButton();
        botonSalir.setText(SALIR);
        butones.add(botonSalir, gbc);

        gbc.weighty = 1;
        menu.add(butones, gbc);
        
        //Escuchadores de eventos.
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                AñadirClienteVentana();
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
                AñadirFondosVentana();
            }
        });
        
        botonExtraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ExtraerFondosVentana();
            }
        });
        
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                EliminarCuentaVentana();
            }
        });
        
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.exit(0);
            }
        });
    }    
    
    private void AñadirClienteVentana(){
        
        JFrame frame = nuevaVentana(CREAR);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCliente = new JLabel("Nombre:");
        JTextField cliente = new JTextField();
        linea1.add(infoCliente);
        linea1.add(cliente);
        
        //Campo de texto para los Fondos de la cuenta y label de este.
        JLabel infoFondos = new JLabel("Fondos:");
        JTextField fondos = new JTextField();
        linea2.add(infoFondos);
        linea2.add(fondos);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);
        linea3.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
                ErrorCrearCuentaVentana();
            }
        });     
    }
    
    private void buscarPorClienteVentana(){
        
        JFrame frame = nuevaVentana(BUSCARU);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCliente = new JLabel("Nombre:");
        JTextField cliente = new JTextField();
        linea1.add(infoCliente);
        linea1.add(cliente);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
            }
        });     
    }
    
    private void buscarPorCuentaVentana(){
        
        JFrame frame = nuevaVentana(BUSCARC);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("Cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
            }
        });     
    }
    
    private void AñadirFondosVentana(){
        
        JFrame frame = nuevaVentana(METER);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("Cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Campo de texto para los Fondos de la cuenta y label de este.
        JLabel infoFondos = new JLabel("Fondos:");
        JTextField fondos = new JTextField();
        linea2.add(infoFondos);
        linea2.add(fondos);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);
        linea3.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
            }
        });     
    }
    
    private void ExtraerFondosVentana(){
        
        JFrame frame = nuevaVentana(SACAR);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("Cuenta:");
        JTextField cuenta = new JTextField();
        linea1.add(infoCuenta);
        linea1.add(cuenta);
        
        //Campo de texto para los Fondos de la cuenta y label de este.
        JLabel infoFondos = new JLabel("Fondos:");
        JTextField fondos = new JTextField();
        linea2.add(infoFondos);
        linea2.add(fondos);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);
        linea3.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
            }
        });     
    }
    
    private void EliminarCuentaVentana(){
        
        JFrame frame = nuevaVentana(ELIMINAR);
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        JPanel linea3 = new JPanel();
        linea3.setLayout(new BoxLayout(linea3, BoxLayout.X_AXIS));
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel infoCliente = new JLabel("Nombre:");
        JTextField cliente = new JTextField();
        linea1.add(infoCliente);
        linea1.add(cliente);
        
        //Campo de texto para los Fondos de la cuenta y label de este.
        JLabel infoCuenta = new JLabel("Cuenta:");
        JTextField cuenta = new JTextField();
        linea2.add(infoCuenta);
        linea2.add(cuenta);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea3.add(botonAceptar);
        linea3.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        entrada.add(linea3, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
                Popup(frame, "Eliminada");
            }
        });     
    }
    
    private void ErrorCrearCuentaVentana(){
        
        JFrame frame = nuevaVentana("Error");
        
        JPanel menu = new JPanel();
        menu.setBorder(new EmptyBorder(10, 10, 10, 10));
        menu.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel entrada = new JPanel(new GridBagLayout());
        
        JPanel linea1 = new JPanel();
        linea1.setLayout(new BoxLayout(linea1, BoxLayout.X_AXIS));
        JPanel linea2 = new JPanel();
        linea2.setLayout(new BoxLayout(linea2, BoxLayout.X_AXIS));
        
        
        //Campo de texto para Nombre de la cuenta y label de este.
        JLabel info = new JLabel("<html><body>Ya existe un usuariocon este nombre,<br>quieres añadirle esta cuenta?</body></html>");
        linea1.add(info);
        
        //Botones.
        JButton botonAceptar = new JButton();
        botonAceptar.setText("Aceptar");
        linea2.add(botonAceptar);
        linea2.add(botonRetroceder(frame));
        
        //Adición de componentes a la pantalla.
        entrada.add(linea1, gbc);
        entrada.add(linea2, gbc);
        
        gbc.weighty = 1;
        menu.add(entrada, gbc);
        frame.add(menu);
        frame.pack();
        
        //Escuchadores de eventos.
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                //Añadir metodo a ejecutar.
            }
        });     
    }
    
    public void Popup(JFrame f, String mensaje){
        JOptionPane.showMessageDialog(f, mensaje);
    }
    
    private JButton botonRetroceder(JFrame frame){
        
        //Boton de cancelar operacion.
        JButton boton = new JButton();
        boton.setText("Cancelar");
        
        //Escuchadores de eventos.
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                frame.dispose();
            }
        }); 
        
        return boton;
    }
    
    private JFrame nuevaVentana(String titulo){
        JFrame frame = new JFrame();
        frame.setTitle(titulo);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(Ventana.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        return frame;
    }
    
}