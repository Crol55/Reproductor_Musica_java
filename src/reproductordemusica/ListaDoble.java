
package reproductordemusica;

public class ListaDoble {

public Nodo inicio;
public Nodo fin;
  public ListaDoble(){
  inicio=null;
  fin=null;
  }
    public void InsertarInicio(String dato){
    if(inicio==null){
        inicio= new Nodo(dato,null,null);
        fin=inicio;
    
    }else{
     
    Nodo temporal= new Nodo(dato,null,inicio);
    inicio.setAnterior(temporal);
    inicio=temporal;
     
      
    }
    
    }
   
    
    public void InsertarFinal(String dato){
      if(inicio==null){
          inicio=new Nodo(dato,null,null);
      fin=inicio;
      }else{
       Nodo temporal1= new Nodo(dato,fin,null);     
       fin.setSiguiente(temporal1);
       fin=temporal1;
      
      }
    
    
    }
    public String extraerinicio(){
    String datos= inicio.getDato();
     inicio=inicio.getSiguiente();
      if(inicio!=null){
         inicio.setAnterior(null);
      }else 
      {
      fin=null;
      }
    return datos;
    }
    
        public String extraerfin(){// no funciona este codigo
     String datos= fin.getDato();
     fin=fin.getAnterior();
          if(fin!=null){
         fin.setSiguiente(null);
      }else 
      {
      inicio=null;
      }
    return datos;
    }
        
        public void OrdenAdelante(){
        Nodo temp=inicio;
        while(temp!=null){
        
            System.out.println(temp.getDato());
            temp=temp.getSiguiente();
        }
        
        }
        public void OrdenAtras(){
        Nodo temp=fin;
        while(temp!=null){
        
            System.out.println(temp.getDato());
            temp=temp.getAnterior();
        }
        
        }
        
        public boolean Buscar(String dato){
         Nodo temp=inicio;
        while(temp!=null){
        
           if(temp.getDato().equals(dato))
           {
             return true;
           }
        }
        
        return false;
        }
        public int ObtenerTamano(){
        int contador=0;
        Nodo prueba=inicio;
            while(prueba!=null){
            prueba=prueba.getSiguiente();
            contador++;
            
            }
            
            
        return contador;
        }
        
        public String ObtenerPosicion(int indice){
        int contador=0;
        Nodo temp=inicio;
            while(contador<indice){
            temp=temp.getSiguiente();
            contador++;
            }
        return temp.getDato();
        }
       /*
        dependiendo de la posicion en la cual se quiera eliminar el nodo 
        con un ciclo while buscamos la posicion-1 y enlazamos con el siguiente a la posicion
        
        */ 
        public void eliminarnodo(int indice){
        int contador=0;
        Nodo temporal= inicio;
        if(indice==0){
        inicio=inicio.getSiguiente();
        }else{
        while(contador<indice-1){
       temporal=temporal.getSiguiente();
       
        contador++;
        }
        temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
        //System.out.println("el que elimia seria :"+temporal.getDato());
 
          //  System.out.println("el anterior al anterior es:"+temporal.getAnterior().getDato());
        }
        }
        public void eliminarprimero(){
        
        inicio=inicio.getSiguiente();
        }
     
  /*  public static void main(String[] args) {
        ListaDoble lista_enlazada= new ListaDoble();
        lista_enlazada.InsertarInicio("a");
        lista_enlazada.InsertarFinal("b");
        lista_enlazada.InsertarFinal("c");
        lista_enlazada.InsertarFinal("h");
            lista_enlazada.InsertarInicio("C");
                lista_enlazada.InsertarInicio("B");
                    lista_enlazada.InsertarInicio("A");
                    lista_enlazada.InsertarFinal("me debo insertar al final");
        //lista_enlazada.eliminarprimero();
        System.out.println("la posicion buscada fue "+lista_enlazada.ObtenerPosicion(2));
        //lista_enlazada.extraerinicio();
        lista_enlazada.eliminarnodo(3);
        //lista_enlazada.eliminarprimero();
        lista_enlazada.OrdenAdelante();
       // System.out.println(ld.extraerfin());
        System.out.println("el tam;ano fue"+lista_enlazada.ObtenerTamano());
        //System.out.println( lista_enlazada.ObtenerPosicion(0));
        
    }*/
    
}
