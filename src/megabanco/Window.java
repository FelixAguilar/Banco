package megabanco;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Felix Lluis Aguilar Ferrer, Adrian Bennassar Polzin.
 */
public class Window extends JFrame {
    
    /*Tamaño de la ventana. Obtenemos herramientas necesarias para comunicarnos 
    con el sistema donde se ejecuta la ventana. Creamos un objeto Dimension con 
    el tamaño de nuestra pantalla.*/
    Toolkit myScreen = Toolkit.getDefaultToolkit(); 
    Dimension screenSize = myScreen.getScreenSize(); 
        
    //Guardamos las constantes que se han registrado en el objeto Dimension.
    int screenHeight = screenSize.height; 
    int screenWidth = screenSize.width;
    
    //Constantes del menú.
    private final String TITLE = "Banco.";
    private final String USER = "Cliente:";
    private final String ACCOUNT = "Cuenta:";
    private final String VALUE = "Saldo:";
    private final String CREATE = "Crear cliente nuevo.";
    private final String SEARCHBYUSER = "Buscar cuentas por usuario.";
    private final String SEARCHBYACCOUNT = "Buscar una cuenta.";
    private final String ADD = "Añadir fondos a una cuenta.";
    private final String SUB = "Extraer fondos a una cuenta.";
    private final String DELETE = "Eliminar una cuenta.";
    private final Font FONT = new Font("serif", Font.BOLD, 20);
    
    /**
     * Constructor de la ventana.
     */
    public Window(){
        setTitle(TITLE);
        setSize(screenWidth/2,screenHeight/2);
        setLocation(screenWidth/4, screenHeight/4);
        setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        initContents();
    }
    
    private void initContents(){
        
        //Creación del Layout principal.
        JPanel window = (JPanel) getContentPane();
        
        //Creación del menú.
        JPanel action1 = new JPanel();
        action1.setLayout(new BoxLayout(action1, BoxLayout.X_AXIS));
        
        //Creación del menú.
        JPanel action2 = new JPanel();
        action2.setLayout(new BoxLayout(action2, BoxLayout.X_AXIS));
        
        JPanel input = new JPanel();
        input.setLayout(new BoxLayout(input, BoxLayout.Y_AXIS));
        
        //Creación del contenedor.
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));        
        sidePanel.add(action1);
        sidePanel.add(action2);
        sidePanel.add(input);
        
        //Campo de cliente.
        JLabel labelUser= new JLabel();
        labelUser.setText(USER);
        labelUser.setFont(FONT);
        input.add(labelUser);
        JTextField textUser = new JTextField();
        textUser.setFont(FONT);
        input.add(textUser);
        
        //Campo de cuenta.
        JLabel labelAccount= new JLabel();
        labelAccount.setText(ACCOUNT);
        labelAccount.setFont(FONT);
        input.add(labelAccount);
        JTextField textAccount = new JTextField();
        textAccount.setFont(FONT);
        input.add(textAccount);
        
        //Campo de saldo.
        JLabel labelValue= new JLabel();
        labelValue.setText(VALUE);
        labelValue.setFont(FONT);
        input.add(labelValue);
        JTextField textValue = new JTextField();
        textValue.setFont(FONT);
        input.add(textValue);
        
        //Boton de crear cuenta.
        JButton buttonCreate = new JButton();
        buttonCreate.setText(CREATE);
        buttonCreate.setFont(FONT);
        action1.add(buttonCreate);
        
        //Boton de buscar por cuenta.
        JButton buttonSearchbyAccount = new JButton();
        buttonSearchbyAccount.setText(SEARCHBYACCOUNT);
        buttonSearchbyAccount.setFont(FONT);
        action1.add(buttonSearchbyAccount);
        
        //Boton de buscar por usuario.
        JButton buttonSearchbyUser = new JButton();
        buttonSearchbyUser.setText(SEARCHBYUSER);
        buttonSearchbyUser.setFont(FONT);
        action1.add(buttonSearchbyUser);
        
        //Boton de ingresar dinero a cuenta.
        JButton buttonAdd = new JButton();
        buttonAdd.setText(ADD);
        buttonAdd.setFont(FONT);
        action2.add(buttonAdd);

        //Boton de extraer dinero de cuenta.
        JButton buttonSubtract = new JButton();
        buttonSubtract.setText(SUB);
        buttonSubtract.setFont(FONT);
        action2.add(buttonSubtract);
        
        //Boton de eliminar cuenta.
        JButton buttonDelete= new JButton();
        buttonDelete.setText(DELETE);
        buttonDelete.setFont(FONT);
        action2.add(buttonDelete);
        
        //Adición de componentes a la pantalla.
        window.add(sidePanel, BorderLayout.CENTER);
        
        //Escuchadores de eventos.
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.out.println("Hola1");
            }
        });
        
        buttonSearchbyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.out.println("Hola3");
            }
        });
        
        buttonSearchbyUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                JOptionPane jop = new JOptionPane();
                jop.setFont(FONT);
                jop.showMessageDialog(window, "Ventana de Informacion.");
            }
        });
        
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.out.println("Hola4");
            }
        });
        
        buttonSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.out.println("Hola5");
            }
        });
        
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) { 
                System.out.println("Hola6");
            }
        });
    }
    
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
    
}
