/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductordemusica;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Bitacora {
  File archivo;
     FileReader archivoaleer;  
      public void MelodiaEliminada(String nombre, String fecha) {
     
   
    try{
    archivo=new File("C:\\Users\\carlos\\Documents\\NetBeansProjects\\ReproductorDeMusica\\CancionesEliminadas.csv");
    FileWriter escritor= new FileWriter(archivo,true);// al utilizar true concatena lo ingresado con lo que esta en el archivo
    escritor.write(nombre+","+fecha+"\r");// las comas indican que debe colocarlo en una celda diferente.
    escritor.close(); 
    
    }catch(IOException e){
          System.out.println("Error"+e.getMessage());
       } 
        
    } 
         public void CancionReproducida(String nombre, String hora) {
     
   
    try{
    archivo=new File("C:\\Users\\carlos\\Documents\\NetBeansProjects\\ReproductorDeMusica\\CancionesReproducidas.csv");
    FileWriter escritor= new FileWriter(archivo,true);// al utilizar true concatena lo ingresado con lo que esta en el archivo
    escritor.write(nombre+","+hora+"\r");// las comas indican que debe colocarlo en una celda diferente.
    escritor.close(); 
    
    }catch(IOException e){
          System.out.println("Error"+e.getMessage());
       } 
        
    }
      
      
      
   public String FechayHoraValor(){
    
       String fechita="";
       DateFormat fechas= new SimpleDateFormat("yyyy/MM/dd");
        //DateFormat fechas= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date dia = new Date();
       fechita=fechas.format(dia);
       
    return fechita;
    }
     public String hora(){
    
       String fechita="";
       //DateFormat fechas= new SimpleDateFormat("yyyy/MM/dd");
        DateFormat fechas= new SimpleDateFormat("HH:mm:ss");
       Date dia = new Date();
       fechita=fechas.format(dia);
       
    return fechita;
    }

    
}
