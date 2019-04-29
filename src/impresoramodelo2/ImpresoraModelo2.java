/******************************************************************** 
 *   El siguiente programa es un ejemplo bastante sencillo de 
 *   impresión con JAVA. 
 * 
 ********************************************************************/ 
package impresoramodelo2;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
/**
 * Interfaz gráfica para la impresión de una cadena de texto.
 * @author Ingeniero Ricardo Presilla ricardopresilla@gmail.com.
 * @version 1.0.
 */
public class ImpresoraModelo2 extends JFrame {
    String cadena; 
    JTextField campo; 
    JButton imprimir; 
    JLabel info; 
    Impresora imp; 
    JPanel principal = new JPanel(new BorderLayout());
    JPanel etiq = new JPanel(new FlowLayout()); 
    JPanel dos = new JPanel(new FlowLayout()); 
    //CONSTRUCTOR DE LA CLASE 
    ImpresoraModelo2() { 
        super("Muestra Simple de Impresión en JAVA..."); 
        info = new JLabel("ESCRIBA ALGO EN EL CAMPO Y HAGA CLIC EN IMPRIMIR..."); 
        cadena = new String(); 
        campo = new JTextField(30); 
        imprimir = new JButton("IMPRIMIR"); 
        dos.add(campo); 
        dos.add(imprimir); 
        etiq.add(info); 
        campo.setToolTipText("ESCRIBA ALGO AQUÍ..."); 
        imprimir.setToolTipText("CLIC AQUI PARA IMPRIMIR..."); 
        principal.add(etiq, BorderLayout.NORTH); 
        principal.add(dos, BorderLayout.CENTER); 
        getContentPane().add(principal); 
        //AJUSTO EL TAMAÑO DE LA VENTANA AL MINIMO 
        pack(); 
        //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA 
        this.setResizable(false); 
        //AHORA LA CENTRARÉ EN LA PANTALLA 
        Dimension pantalla, cuadro; 
        pantalla = Toolkit.getDefaultToolkit().getScreenSize(); 
        cuadro = this.getSize(); 
        this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2); 
        //LE AGREGAMOS EL EVENTO AL BOTON "imprimir" 
        imprimir.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent evt) { 
                cadena = ""; 
                cadena = String.valueOf(campo.getText()); 
                if (!cadena.equals("")) { 
                    imp = new Impresora(); 
                    imp.imprimir(cadena);
                } 
                else 
                    System.out.println("NO SE IMPRIME NADA EN BLANCO..."); 
                campo.requestFocus(); 
                campo.select(0, cadena.length()); 
            } 
        }); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ImpresoraModelo2 p = new ImpresoraModelo2(); 
        p.show(); 
        p.addWindowListener(new WindowAdapter() { 
            public void windowClosing(WindowEvent evt) { 
                System.exit(0); 
            } 
        }); 
    }
}