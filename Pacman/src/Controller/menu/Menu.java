package Controller.menu;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Dimension;
import java.awt.event.KeyEvent;

public class Menu extends JPanel {
   
	private static final long serialVersionUID = 1L;
	protected JButton bJugar, bInfo, bSalir;

	/* Esta clase se usa como panel para la ventana principal al iniciar la ejecución del programa.
	 * Contiene los botones y las imagenes.
	 */
    public Menu(VentanaPrincipal ventana) {
    	    	
        ImageIcon tituloIcon = createImageIcon("imagenes/titulo.gif");
        ImageIcon bannerIcon = createImageIcon("imagenes/pacman-y-fantasmas.gif");
          
        //Se crea el LayOut de manera que los componentes se acomoden verticalmente.
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
        //Se crean los componentes contenedores de imagenes	
    	JLabel titulo = new JLabel(tituloIcon); 
    	JLabel banner = new JLabel(bannerIcon); 
   
    	//-------------------Botones--------------------------
        bJugar = new JButton("Jugar");
        bJugar.setVerticalTextPosition(AbstractButton.CENTER);
        bJugar.setHorizontalTextPosition(AbstractButton.LEADING); 
        bJugar.setMnemonic(KeyEvent.VK_J);
       
        bInfo = new JButton("Info");
        bInfo.setVerticalTextPosition(AbstractButton.BOTTOM);
        bInfo.setHorizontalTextPosition(AbstractButton.CENTER);
        bInfo.setMnemonic(KeyEvent.VK_I);

        bSalir = new JButton("Salir");
        bSalir.setMnemonic(KeyEvent.VK_S);
   
        //Se agregan las acciones a los botones.
        bJugar.addActionListener(new AccionJugar(ventana));
        bInfo.addActionListener(new AccionInfo());
        bSalir.addActionListener(new AccionSalir());
        
        //Texto al pasar el mouse por encima
        bJugar.setToolTipText("Comenzar juego");
        bInfo.setToolTipText("About");
        bSalir.setToolTipText("Exit");
        
        setFocusableOpaqueVisible(bJugar);
        setFocusableOpaqueVisible(bInfo);
        setFocusableOpaqueVisible(bSalir);
        
        //--------------------------------------------------------------
        
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        banner.setAlignmentX(CENTER_ALIGNMENT);
        bJugar.setAlignmentX(CENTER_ALIGNMENT);
        bInfo.setAlignmentX(CENTER_ALIGNMENT);
        bSalir.setAlignmentX(CENTER_ALIGNMENT);
        
        //Se agregan los componentes al panel.
        add(Box.createRigidArea(new Dimension(0,20)));
        add(titulo);
        add(Box.createRigidArea(new Dimension(0,100)));
        add(bJugar);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(bInfo);
        add(Box.createRigidArea(new Dimension(0,20)));
        add(bSalir);
        add(Box.createRigidArea(new Dimension(0,100)));
        add(banner);
        
    }
    
    //Se declaran visibles y no "Focusables" para que al iniciarse el controlador, no capturen los eventos.
    private void setFocusableOpaqueVisible(JButton boton){
    	boton.setOpaque(true);
    	boton.setFocusable(false);
    	boton.setVisible(true);
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Menu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
  
}