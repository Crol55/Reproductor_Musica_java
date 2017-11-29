
package reproductordemusica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class Registro extends JFrame implements ActionListener{
   public JLabel usuario,bloqueo;
   public JButton aceptar;
   public JTextField ingreso;
   public JPasswordField contrasena;
   public String nombrecito,password;
   public int conta=0;
   Almacenar_Usuario lista= new Almacenar_Usuario();
 //metodo para recuperar el nombre del usuario
   public void getnombre(String nombreusuario){
     String nombre=nombreusuario;
         JOptionPane.showMessageDialog(null,"el nombre almacenado fue "+nombre); 
    }
 
 //-------------------------------
    public Registro(){ //------>CONSTRUCTOR
        
     super("Registro De Usuarios");
     setSize(500,200);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setResizable(false);
     Container contenedor= getContentPane();
     GridBagLayout gb= new GridBagLayout();
     contenedor.setLayout(gb);
     GridBagConstraints atributos = new GridBagConstraints();
     //------> creando los atributos para agregarle al boton dependienndo de donde se pondran los swings 
     usuario= new JLabel("INGRESE NOMBRE DE USUARIO  :");
     
       atributos.gridx = 0;// dependiendo en donde se quiere colocar en el eje x
        atributos.gridy = 0;// eje y creando filas, y escogiendo la posion 1.
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;
    contenedor.add(usuario,atributos);
    
    // INGRESA EL USUARIO --------------------------
    ingreso= new JTextField(20);
        atributos.gridx = 1;
        atributos.gridy = 0;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.EAST;
        
     contenedor.add(ingreso,atributos);
     //---------LAbel de contrasena---------------------
         bloqueo = new JLabel("INGRESE CONTRASENA");
        atributos.gridx = 0;
        atributos.gridy = 1;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;// traslada el boton al este de su posicion
         
        contenedor.add(bloqueo, atributos);
       //---------Password o cotrasena--------------------------
    contrasena= new JPasswordField(20);
      
        atributos.gridx = 1;// dependiendo en donde se quiere colocar en el eje x
        atributos.gridy = 1;// eje y creando filas, y escogiendo la posion 1.
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.EAST;
      
     contenedor.add(contrasena,atributos);
     //-----------------------------------------------------------
         aceptar = new JButton("Aceptar");// boton aceptar
        atributos.gridx = 1;
        atributos.gridy = 2;
        atributos.gridwidth = 1;
        atributos.gridheight = 1;
        atributos.anchor = GridBagConstraints.WEST;// traslada el boton al este de su posicion
        aceptar.addActionListener(this);
        contenedor.add(aceptar, atributos);
    //-----------------------------------------------------------------
        
    }
   @Override
          public void actionPerformed(ActionEvent ev) {
              Registro r= new Registro();
                 Almacenar_Usuario almacenamiento= new Almacenar_Usuario();
              if(ev.getSource()==aceptar){
              if((ingreso.getText().isEmpty()&&(contrasena.getText().isEmpty()))){
                   JOptionPane.showMessageDialog(null,"RELLENE LAS CASILLAS, AMBAS ESTAN VACIAS");
              }else if((contrasena.getText().isEmpty()||(ingreso.getText().isEmpty()))){
                  JOptionPane.showMessageDialog(null,"FALTA UNA CASILLA, AMBAS DEBEN ESTAR LLENAS");
              }else{
               // Registro re= new Registro();
             
              char p[]=contrasena.getPassword();
               password=new String(p);// LA CONTRASENA LA VOLVEMOS STRING PARA PODER ALMACENARLA
                nombrecito=ingreso.getText();
               almacenamiento.LeerArchivo();
    
                 for (int i = 0; i < almacenamiento.lista_nombres.size(); i++) {
                     System.out.println("yo si me ejecute");
             if((ingreso.getText().equals(almacenamiento.lista_nombres.get(i))&&(password.equals(almacenamiento.lista_contrasena.get(i))))){
                
               JOptionPane.showMessageDialog(null,"El nombre de usuario y contrasena ya han sido utilizados","Error",JOptionPane.INFORMATION_MESSAGE);
               ingreso.setText("");contrasena.setText("");
              break; 
             } else{          
                 conta=conta+1;
             }
           }  if(conta==almacenamiento.lista_contrasena.size()){
             Login log= new Login();
            almacenamiento.guardar(ingreso.getText(), contrasena.getText(),r.FechayHoraValor());
           JOptionPane.showMessageDialog(null,"Felicidades ha sido registrado con exito","Exito",JOptionPane.INFORMATION_MESSAGE);
            log.setVisible(true);
           dispose();
          
           }
               
              }
              }
              
              
          }
          public String FechayHoraValor(){
    
       String fechita="";
    
        DateFormat fechas= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date dia = new Date();
       fechita=fechas.format(dia);
       
    return fechita;
    }
    /* public static void main(String[] args) {
          
       Registro re= new Registro();
       re.setVisible(true);
       
       
    }*/
    
    
}

