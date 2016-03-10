package testml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/**
 *
 * @author Alan Estrada
 */
public class PrimosCircularesHilo extends Thread{
    private String nombre;
    private List<Integer> listaprimos= new  ArrayList();   //Esta lista contiene los numeros primos que van a ser evaluados
    private List<Integer> primoscirculares= new ArrayList();  //Esta contiene los numeros primos criculares que agrego
    private Set<Integer> set_rotados= new HashSet();           //Esta lista contiene los numeros primos rotados
      
    public PrimosCircularesHilo(String nombre,List<Integer> listaprimos){
     super(nombre);   
     this.nombre=nombre;
     this.listaprimos=listaprimos;
       }
        
    public List<Integer> getPrimosCirculares(){
    return this.primoscirculares;
    }      
       
    @Override 
    public void run(){
     synchronized (listaprimos){   
     List<Integer> listaprimoscirculares= new ArrayList();       
     int rotacion=0,tam=1000000;
     String numero;
     Iterator<Integer> iter= this.listaprimos.iterator();  // utilizo un iterador para recorrer la lista de numeros primos
     
     while(iter.hasNext()){
      rotacion=0;   
      numero=Integer.toString(iter.next());
      set_rotados.clear();
      for(int i=0;i< numero.length() && !(Integer.parseInt(numero)%2==0)&& Operaciones.esprimo(Integer.parseInt(numero))&& (!(primoscirculares.contains(Integer.parseInt(numero))));i++){ 
       if(Integer.parseInt(numero)<=tam){
         set_rotados.add(Integer.parseInt(numero));
         numero=Operaciones.circular(numero); 
         rotacion++;
        }
      }  
      if (rotacion==numero.length()){
           primoscirculares.addAll(set_rotados); 
           }
      }      
     listaprimoscirculares.addAll(primoscirculares); 
     Collections.sort(listaprimoscirculares); //ordeno toda la lista con los numeros primos circulares
     
    System.out.println("Lista de números circulares menores que 1 millon:");
    System.out.println(listaprimoscirculares);
    System.out.println("Cantidad de números primos circulares menores que 1 millon: "+ listaprimoscirculares.size());
    listaprimos.notify(); //notifico al primer hilo para que deje de esperar
     }
    }
 
}
