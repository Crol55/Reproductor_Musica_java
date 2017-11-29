
package reproductordemusica;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music {
    
 FileInputStream FIS;
 BufferedInputStream BIS;
 public long longitudsonido;
 public long sedetuvo;
 boolean reproduciendo=false,acti;
 public String ruuta;
 public Player player;
  public int bites;
 SelectorDeMusica selector= new SelectorDeMusica();
 
 public void reproducir(String ru){
     try {
         
         FIS= new FileInputStream(ru);// lee la ruta que le entra como parametro
         BIS= new BufferedInputStream(FIS);
         player= new Player(BIS);// ingresamos directo la ruta a player para que pueda reproducirla
         longitudsonido=FIS.available();// la cantidad total que dura la cancion
        
         ruuta= ru;
         reproduciendo=true;
     } catch (FileNotFoundException | JavaLayerException ex) {
         Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
     }
  new Thread()
        {
            @Override
            public void run(){
                
                try {
                    player.play();// reproducimos la ruta ingresada
                      if(player.isComplete()){
                   
                      }
                } catch (JavaLayerException ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            }
        }.start(); 
 }
 public boolean secompleto(){
 
 return acti;
 }
 public void detener(){
 if(reproduciendo==true){
   
     //System.out.println("ya esta reproduciendo");
    player.close();
    sedetuvo=0;
    longitudsonido=0;
    reproduciendo=false;
 } else{
     System.out.println("no se esta reproduciendo nada");
 }
 
 }
 public void pausar(){
 if(reproduciendo==true){
     try {
         sedetuvo=FIS.available();
         player.close();
     } catch (IOException ex) {
         Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 
 }
   public void resume(){
     try {
         FIS= new FileInputStream(ruuta);
          BIS= new BufferedInputStream(FIS);
     player = new Player(BIS);
     FIS.skip(longitudsonido-sedetuvo);
     
     
     } catch (FileNotFoundException | JavaLayerException ex) {
         Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
     }
  
    new Thread()
        {
            @Override
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            }
        }.start();
   } 
    
    
}
