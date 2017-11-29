package reproductordemusica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class Reproductor extends JFrame implements ActionListener{

    Music mus = new Music();
    public JPanel panelcentral, panelinferior, panelsuperior;
    public JButton agregar, modificar, eliminar, eliminadocompleto;
    public JButton iniciar, pausar, adelante, atras, stop;
    public JTextField buscar,re;
    public DefaultListModel modelo;
    public JList lista;
    public JLabel b,info,saa;
    public int x = 1, actual,contador=0,fin=0,fin2=0,contador4=0,fin4=0,principal=0;
    int y = 0;
    int almacen,selec=-1;
    public int seleccion[];
    public boolean Activado = false, pausa = false, completada,detenido,adelantado=false,completo; // para saber si ya esta sonando musica o no
    SelectorDeMusica selector = new SelectorDeMusica();
    Music m= new Music();
    ListaDoble listadoble = new ListaDoble();
    ListaDoble ListaMayores= new ListaDoble();
   Bitacora bit= new Bitacora();
    public Reproductor() {

        super("Reproductor");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Container contenedor = getContentPane();
        BorderLayout bl = new BorderLayout();
        contenedor.setLayout(bl);

        //--------------panel superior-----------------//
        panelsuperior = new JPanel();
        iniciar = new JButton("|>");
        pausar = new JButton("||");
        adelante = new JButton("->");
        atras = new JButton("<-");
        stop = new JButton("stop");
      
        GridLayout gl = new GridLayout();
        panelsuperior.setLayout(gl);
        panelsuperior.add(atras);
        atras.addActionListener(this);
        panelsuperior.add(stop);
        stop.addActionListener(this);
        panelsuperior.add(iniciar);
        iniciar.addActionListener(this);
        panelsuperior.add(pausar);
        pausar.addActionListener(this);
        panelsuperior.add(adelante);
        adelante.addActionListener(this);
      
    
        contenedor.add(panelsuperior, BorderLayout.NORTH);

        //-----------Panel central -------------------//
        panelcentral = new JPanel();
    
        lista = new JList();//instanceamos el jlist.
       // lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        modelo = new DefaultListModel();
      re=new JTextField(20);
        lista.setFont(new Font("Verdana", Font.BOLD, 12));
        lista.setForeground(Color.WHITE);
        lista.setBackground(Color.BLACK);
        lista.setModel(modelo);
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints atributos = new GridBagConstraints();
        panelcentral.setLayout(gb);
        atributos.gridx = 0;
        atributos.gridy = 0;
        atributos.gridwidth = 0;//indica que ocupe filas
        atributos.gridheight = 1;//indica columnas
        atributos.weighty = 1.0; // estira la lista en la columna hasta completar la ventana
        atributos.weightx = 1.0;// estira la lista en las filas hasta completar la ventana
        atributos.fill = GridBagConstraints.HORIZONTAL;
        atributos.weighty = 0.0;
        atributos.weightx = 0.0;
        panelcentral.add(re,atributos);
        atributos.gridx = 0;// indica donde comenzar
        atributos.gridy = 1;
        atributos.gridwidth = 2;//indica que ocupe 3filas
        atributos.gridheight = 2;//indica 3columnas
        atributos.weighty = 1.0; // estira la lista en la columna hasta completar la ventana
        atributos.weightx = 1.0;// estira la lista en las filas hasta completar la ventana
       atributos.fill = GridBagConstraints.BOTH;

        panelcentral.add(new JScrollPane(lista), atributos);// le agregamos la opcion de scroll al jlist donde estaran las canciones.
       
        contenedor.add(panelcentral, BorderLayout.CENTER);
        //---------panel inferior---------------------//
        panelinferior = new JPanel();
        agregar = new JButton("+");
        agregar.addActionListener(this);// vigilamos el boton
        modificar = new JButton("( )");
        modificar.addActionListener(this);// vigilamos el boton
        eliminar = new JButton("-");
        eliminar.addActionListener(this);
        eliminadocompleto = new JButton("Borrar");
        eliminadocompleto.addActionListener(this);
        buscar = new JTextField(10);
        b = new JLabel("Buscar");
        FlowLayout fl = new FlowLayout();
        panelinferior.setLayout(fl);
        panelinferior.add(agregar);
        panelinferior.add(modificar);
        panelinferior.add(eliminar);
        panelinferior.add(eliminadocompleto);
        panelinferior.add(b);
        panelinferior.add(buscar);
        contenedor.add(panelinferior, BorderLayout.SOUTH);
  
    }
public void detenercancion(){
  try {
                mus.detener();
                Activado=false;
                pausa=false;
                detenido=true;
                pausar.setEnabled(true);
                iniciar.setEnabled(true);
            } catch (Exception ex) {
                //   Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }


}

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == agregar) {//------- metodo para agregar canciones////////
            selector.selectordemusica();// utilizamos la instancia de seleccion de musica para abrir el jfilechooser
            if (selector.estado == 0) {
               // System.out.println("si ejecuto el condicional");
                for (int i = y; i < selector.MultiLista.ObtenerTamano(); i++) {
                    modelo.addElement(x + "-" + selector.MultiLista.ObtenerPosicion(i));// agregamos el nombre de la cancion al modelo del jlist
                    lista.setModel(modelo);// agregamos a las lista lo almacenado en el modelo
                    listadoble.InsertarFinal(selector.rutapath);

                    x = x + 1;
              // System.out.println("si me ejecutor");

                    selector.rutapath = "";
                    selector.nombreruta = "";
                  //  System.out.println(" el valor de y antes de cambiar " + y);
                    y++;
                }

            } else {
                System.out.println(" no se selecciono ningun archivo");
            }
        } else if (ev.getSource() == modificar) {
            System.out.println("se va a modificar el archivo");

            
        } else if (ev.getSource() == eliminar) {//=============== boton para eliminar =================///
            if (lista.getSelectedIndex() >= 0) {
            Bitacora bit= new Bitacora();
              int  z=lista.getSelectedIndex();
                modelo.removeElementAt(lista.getSelectedIndex());
                // System.out.println("la eliminada sera "+selector.MultiLista.ObtenerPosicion(z));
                bit.MelodiaEliminada(selector.MultiLista.ObtenerPosicion(z),bit.FechayHoraValor());
                selector.ListaDeRutas.eliminarnodo(z);
                selector.MultiLista.eliminarnodo(z);
               
            } else {
                JOptionPane.showMessageDialog(null, "no ha seleccionado nada", "No Selecciono", JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (ev.getSource() == eliminadocompleto) {
            modelo.clear();
            adelantado=false;
            selec=-1;
        } else if (ev.getSource() == iniciar) {     //--- boton para reproducir la musica----//
              selec=lista.getSelectedIndex();
              seleccion = lista.getSelectedIndices();// recuperamos el indice del jlist
             // fin=lista.getSelectedIndex();
             
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen canciones a reproducir ", "Vacio", JOptionPane.ERROR_MESSAGE);
             
            }
             
            else if(pausa==true){
            try {
                    mus.resume();
                    pausar.setEnabled(true);
                    iniciar.setEnabled(false);
                } catch (Exception ex) {
                    //  Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
                }
                pausa = false;
                
            }
           // /else  {
              
               else if (selec==-1) {
 JOptionPane.showMessageDialog(null, "No ha seleccionado cancion ", "Seleccione cancion a reproducir", JOptionPane.ERROR_MESSAGE);
                } else {adelantado=true;
                    //System.out.println("adelantado "+adelantado);
                     if(seleccion[0]-actual!=0){
                         contador=0; fin=0;contador4=0;fin4=0;}
                    String cancioncita;
                    cancioncita = selector.ListaDeRutas.ObtenerPosicion(seleccion[0]);
                                 // selector.ListaDeRutas.OrdenAdelante();
                    mus.reproducir(cancioncita);
                    re.setText(selector.MultiLista.ObtenerPosicion(selec));
                    bit.CancionReproducida(re.getText(), bit.hora());
                    Activado = true;
                    if (Activado == true) {
                        iniciar.setEnabled(false);
                    } else {
                        iniciar.setEnabled(true);
                    }
                }
           

        } else if (ev.getSource() == stop) {        //===============METODO PARA DETENER LA CANCION====================//////
          if(Activado==true){
            iniciar.setEnabled(true);

            try {
                mus.detener(); re.setText("");
                Activado=false;
                pausa=false;
                detenido=true;
                pausar.setEnabled(true);
            } catch (Exception ex) {
                //   Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }
         } else{   JOptionPane.showMessageDialog(null, "NO EXISTE CANCION A DETENER ", "ERROR", JOptionPane.ERROR_MESSAGE);  } 
        }
        
          else if (ev.getSource() == pausar) {     //================metodo para pausar //==================
       if(Activado==false){
       JOptionPane.showMessageDialog(null, "No existen canciones a pausar ", "ERROR", JOptionPane.ERROR_MESSAGE);
       }else{
            try {
                mus.pausar();
                pausar.setEnabled(false);
                iniciar.setEnabled(true);
                pausa = true;
                
            } catch (Exception ex) {
                // Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }
              } 
        } else if (ev.getSource() == adelante) {     //============ METODO PARA ADELANTAR =======================
      Reproductor r = new Reproductor();     
      if(adelantado==false){
JOptionPane.showMessageDialog(null, "No ha seleccionado cancion a reproducir ", "Seleccione cancion", JOptionPane.ERROR_MESSAGE);
      }
       else if(selector.ListaDeRutas.ObtenerTamano()-fin==1){// para saber si la lista ya fue recorrida hasta el final
JOptionPane.showMessageDialog(null, "Se ha llegado al final de la lista ", "Fin", JOptionPane.ERROR_MESSAGE);}
         else{
           
          actual=seleccion[0];
          if((Activado==true) || (detenido==true)){
            if(Activado==true || pausa==true){
                try {
                mus.detener();
                pausa=false;
                pausar.setEnabled(true);
            } catch (Exception ex) {
                //   Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }     
             
       }
            contador++;
           fin=actual+contador;
              //System.out.println("la cancion a reproducir seria"+fin);
           // System.out.println("EL QUE LLEVA LA CUENTA REAL adelante :"+actual);
            String can;
                    can = selector.ListaDeRutas.ObtenerPosicion(fin);
                     mus.reproducir(can);
                     re.setText(selector.MultiLista.ObtenerPosicion(fin));
                     bit.CancionReproducida(re.getText(), bit.hora());
                     iniciar.setEnabled(false);
                     Activado=true;
      }else{
       JOptionPane.showMessageDialog(null, "No se puede avanzar porque no se puede partir de ningun punto ", "SIN PUNTO DE PARTIDA", JOptionPane.ERROR_MESSAGE);
       }
     }}
        else if(ev.getSource()==atras){      /////------ metodo para atrasar la cancion --------  //////////
              Reproductor r = new Reproductor();
          if(selec==-1){
         JOptionPane.showMessageDialog(null, "Debe reproducir una cancion primero", "No se puede retroceder", JOptionPane.ERROR_MESSAGE);
         
         } else {
             actual=seleccion[0];
         if((Activado==true) || (detenido==true)){
            if(Activado==true || pausa==true){
                try {
                mus.detener();
                pausa=false;
                pausar.setEnabled(true);
            } catch (Exception ex) {
                //   Logger.getLogger(Reproductor.class.getName()).log(Level.SEVERE, null, ex);
            }     
             
       }
            contador--;
            fin=actual+contador;

            if (fin<0){
        
            r.detenercancion();
                System.out.println("no debo reproducir");}
            else{
            String canc;
                    canc = selector.ListaDeRutas.ObtenerPosicion(fin);
                     mus.reproducir(canc);
                     re.setText(selector.MultiLista.ObtenerPosicion(fin));
                     bit.CancionReproducida(re.getText(), bit.hora());
                     iniciar.setEnabled(false);
                     Activado=true;}
      }else{
       JOptionPane.showMessageDialog(null, "No se puede avanzar porque no se puede partir de ningun punto ", "SIN PUNTO DE PARTIDA", JOptionPane.ERROR_MESSAGE);
       } //aqui debo colocar el fin
        
        
        
        }
      }

    }

    public static void main(String[] args) {
        Reproductor reproductor = new Reproductor();
        reproductor.setVisible(true);

    }
}
