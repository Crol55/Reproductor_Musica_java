package reproductordemusica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
public class Almacenar_Usuario{
 //Registro reg= new Registro();   
   ArrayList<String> lista_nombres= new ArrayList<>();
    ArrayList<String> lista_contrasena= new ArrayList<>();

     File archivo;
     FileReader archivoaleer;
  
   
 
  
    public void guardar(String nombre, String contrasena,String fecha) {
     // archivo=new File("C:\\Users\\carlos\\Documents\\NetBeansProjects\\ReproductorDeMusica\\archivo.csv");
   
    try{
    archivo=new File("C:\\Users\\carlos\\Documents\\NetBeansProjects\\ReproductorDeMusica\\nombre.csv");
    FileWriter escritor= new FileWriter(archivo,true);// al utilizar true concatena lo ingresado con lo que esta en el archivo
    escritor.write(nombre+","+contrasena+","+fecha+"\r");// las comas indican que debe colocarlo en una celda diferente.
    escritor.close(); 
    
    }catch(IOException e){
          System.out.println("Error"+e.getMessage());
       } 
        
    }
    
    public  void LeerArchivo(){
    try{
      archivo=new File("C:\\Users\\carlos\\Documents\\NetBeansProjects\\ReproductorDeMusica\\nombre.csv");
       archivoaleer= new FileReader(archivo);
        BufferedReader br= new BufferedReader(archivoaleer);
        String linea="";
         while ((linea = br.readLine())!=null){// leer linea por linea
             String [] datos = linea.split(",");
          //   System.out.println("sii recupere el texto en la posicion 0  "+datos[1]);
             lista_nombres.add(datos[0]);// almacenamos todos los nombres en una lista de nombres.
             lista_contrasena.add(datos[1]);
     
            
         }
         br.close();
         archivoaleer.close();
    }catch(IOException e){
    
    
    
    }
        
        
    }
   public static void main(String[] args) {
     
    
    }
}
