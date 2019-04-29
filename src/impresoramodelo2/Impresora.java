/********************************************************************
 * La siguiente clase llamada "Impresora", es la encargada de
 * establecer la fuente con que se va a imprimir, de obtener el 
 * trabajo de impresion, la página. En esta clase hay un método
 * llamado imprimir, el cual recibe una cadena y la imprime.
 * 
 ********************************************************************/ 
package impresoramodelo2;

import java.awt.*;

/**
 * Clase encargada de establecer la fuente de letras, obtener el trabajo de 
 * impresión y la página ha imprimir. En esta clase contiene un método llamado 
 * imprimir, el cual recibe una cadena y la imprime.
 * @author Ingeniero Ricardo Presilla ricardopresilla@gmail.com.
 * @version 2.0.
 */
public class Impresora {
    /**Almacena la fuente ó tipo de letras, el estilo y el tamaño.*/
    Font fuente = new Font("Dialog", Font.PLAIN, 10); 
    /**Almacena el Trabajo de impresión.*/
    PrintJob pj; 
    /**Almacena la página.*/
    Graphics pagina; 
/********************************************************************
 * A continuación el constructor de la clase. Aquí lo único que
 * hago es tomar un objeto de impresion.
 * 
 ********************************************************************/ 
    Impresora() { 
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
    } 
/********************************************************************
 * A continuación el método "imprimir(String)", el encargado de
 * colocar en el objeto gráfico la cadena que se le pasa como
 * parámetro y se imprime.
 * 
 * @param Cadena    Tipo string.
 ********************************************************************/ 
    public void imprimir(String Cadena) { 
    //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try { 
            pagina = pj.getGraphics();
            pagina.setFont(fuente); 
            pagina.setColor(Color.black); 
            pagina.drawString(Cadena, 60, 60); 
            pagina.dispose(); 
            pj.end(); 
        }catch(Exception e) { 
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
        }
    }//FIN DEL PROCEDIMIENTO imprimir(String...) 
    /**
     * Método para imprimir una cadena de caracteres.
     * @param Cadena Tipo string.
     */
    public void imprimirHoja(String Cadena) { 
    //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try { 
            pagina = pj.getGraphics();
            pagina.setFont(fuente); 
            pagina.setColor(Color.black); 
            for(int i=0;i<640;i=i+20){
                pagina.drawString(Cadena, 60, i); 
            }
            pagina.dispose(); 
            pj.end(); 
        }catch(Exception e) { 
            System.out.println("LA IMPRESION HA SIDO CANCELADA...");
        }
    }//FIN DEL PROCEDIMIENTO imprimir(String...) 
//FIN DE LA CLASE Impresora   
}
