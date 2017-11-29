
package reproductordemusica;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;
public class Login extends JFrame implements ActionListener{
  public JLabel usuario,pass;
  public JTextField user,contrasena;
  public JButton logear;
  public int contador=0;
    public Login(){
    super("LOGIN USUARIO");
     setSize(500,200);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setResizable(false);
     Container contenedor= getContentPane();
     GridBagLayout gb= new GridBagLayout();
     contenedor.setLayout(gb);
     GridBagConstraints atributos = new GridBagConstraints();
     //------> creando los atributos para agregarle al boton dependienndo de donde se pondran los swings 
     
     
     usuario= new JLabel("   USUARIO       :");
     
       atributos.gridx = 0;// dependiendo en donde se quiere colocar en el eje x
        atributos.gridy = 0;// eje y creando filas, y escogiendo la posion 1.
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;
    contenedor.add(usuario,atributos);
    
    // INGRESA EL USUARIO --------------------------
    user= new JTextField(20);
        atributos.gridx = 1;
        atributos.gridy = 0;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.EAST;
        
     contenedor.add(user,atributos);
     //---------LAbel de contrasena---------------------
         pass= new JLabel(" CONTRASENA: " );
        atributos.gridx = 0;
        atributos.gridy = 1;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;// traslada el boton al este de su posicion
         
        contenedor.add(pass, atributos);
       //---------Password o cotrasena--------------------------
    contrasena= new JPasswordField(20);
      
        atributos.gridx = 1;// dependiendo en donde se quiere colocar en el eje x
        atributos.gridy = 1;// eje y creando filas, y escogiendo la posion 1.
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.EAST;
      
     contenedor.add(contrasena,atributos);
     //-----------------------------------------------------------
         logear = new JButton("LOGIN");// boton aceptar
        atributos.gridx = 1;
        atributos.gridy = 2;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;// traslada el boton al este de su posicion
        logear.addActionListener(this);
        contenedor.add(logear, atributos);
    }
    //-----------------------------------------------------------------
        
    
    
    
    
  @Override
     public void actionPerformed(ActionEvent ev) {
     Almacenar_Usuario lista= new Almacenar_Usuario();
         if(ev.getSource()==logear){
       if((user.getText().isEmpty())&&(contrasena.getText().isEmpty())){
        JOptionPane.showMessageDialog(null,"AMBAS CASILLAS ESTAN VACIAS","ERROR",JOptionPane.ERROR_MESSAGE);
       } else if((user.getText().isEmpty())||(contrasena.getText().isEmpty())){
        JOptionPane.showMessageDialog(null,"UNA CASILLA ESTA VACIA","ERROR",JOptionPane.WARNING_MESSAGE);
       }else {      
           lista.LeerArchivo();// ARRASTRAR TODO LOS NOMBRES Y CONTRASENAS DEL REGISTRO
           System.out.println("si llego hasta este punto");
           for (int i = 0; i < lista.lista_nombres.size(); i++) {
               //System.out.println("el tamano de la lista es "+lista.lista_nombres.size());
             if((user.getText().equals(lista.lista_nombres.get(i))&&(contrasena.getText().equals(lista.lista_contrasena.get(i))))){
                 // VERIFICA SI EL NOMBRE INGRESADO ESTA EN EL REGISTRO
               JOptionPane.showMessageDialog(null,"Bienvenido "+user.getText(),"Exito",JOptionPane.INFORMATION_MESSAGE);
               contador=0;
               Reproductor r= new Reproductor();
               r.setVisible(true);
               dispose();
             } else{
                contador=contador+1;             
                
             }
           }
             
        if(contador==lista.lista_contrasena.size()){// si el contador llegase a ser el mismo que la longitud significa q no encontro el usuario.
           JOptionPane.showMessageDialog(null,"EL Usuario Ingresado no Existe","Debe Registrarse ahora",JOptionPane.ERROR_MESSAGE);
           dispose();
            Registro r= new Registro();
            r.setVisible(true);
            
         } 
            
             
           
           
         
       }
         
         }
         
     }
     public static void main(String[] args) {
     JFrame.setDefaultLookAndFeelDecorated(true);// permite decorar por medio de substance
      SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
      SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SteelBlueTheme");
       Login log= new Login();
       log.setVisible(true);
      
    }
    
}
