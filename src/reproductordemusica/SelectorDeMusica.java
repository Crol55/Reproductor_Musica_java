
package reproductordemusica;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;


public class SelectorDeMusica extends JFrame {
    File rutas;
    public boolean existencia;
    public int estado,x=0;
    public File[] ficheros,RUTAS;
     ListaDoble MultiLista= new ListaDoble();
     ListaDoble ListaDeRutas= new ListaDoble();
    /*
    En esta clase encontramos
    el jfilechooser que nos serviara para
    almacenar el nombre de la cancion
    y almcenar la ruta de la cancion.
    
    */
    String rutapath,nombreruta;
public void selectordemusica(){
    JFileChooser file= new JFileChooser();
    file.setMultiSelectionEnabled(true);
      estado=file.showOpenDialog(this);
      
      if(estado==0){ // si es igual a 0 significa que se selecciono un archivo
          existencia=false;
        //  System.out.println("la existencia de debe de ser false porq se sselecicon archivo"+existencia);
  try{
     
     ficheros=file.getSelectedFiles();
     
     
       // rutas=file.getSelectedFile();
        
        for (int i = 0; i < ficheros.length; i++) {
         
          nombreruta=file.getName(ficheros[i]);// recuperamos el nombre de cada cancion
          rutapath=ficheros[i].getAbsolutePath();// recuperamos todos las rutas absolutas de todas las canciones ingresadas.
         //System.out.println("Esta ruta  "+rutapath);
           MultiLista.InsertarFinal(nombreruta);
           ListaDeRutas.InsertarFinal(rutapath);// ingresamos todas las rutas a la listaderutas y la enviamos al reproductor.
            //System.out.println("los ficheros se deben vaciar por lo tanto debe dar una respuesta diferente en la misma posicion "+ficheros[0]);
      }
       } catch(NullPointerException e){
           System.out.println("No selecciono ningun archivo");
       }

      }else{
        existencia=true;
         // System.out.println(" la existencia debe ser cierta "+existencia);
      } 
}


    
    


   
    public SelectorDeMusica(){
   //Reproductor instanciareproductor= new Reproductor();  
    }
   
}
