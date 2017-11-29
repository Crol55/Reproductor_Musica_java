/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductordemusica;
public class Nodo {
  String dato;
   Nodo anterior;
   Nodo siguiente;

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
   
   public Nodo(String dat,Nodo anterior,Nodo siguiente){
   dato=dat;
   this.anterior= anterior;
   this.siguiente = siguiente;
   
   
   }
   
}
