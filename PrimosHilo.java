package testml;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alan Estrada
 */
public class PrimosHilo extends Thread{
    private String nombre;
    private List<Integer> listaprimos= new ArrayList();
        
    public PrimosHilo(String nom){
     super(nom);
     nombre=nom;        
    }
    
    public List<Integer> getListaPrimos(){
     return this.listaprimos;
    } 
               
    @Override
    public void run(){ 
      synchronized (listaprimos){
          
     {for(int i=11;i<1000000;i++){   //empieza en 11 porque considero los numeros primos mayores e iguales a dos digitos
       if(Operaciones.esprimo(i))
           listaprimos.add(i);
             }
         try {
             listaprimos.wait();  //lo detengo para que pueda usarlo 
         } catch (InterruptedException ex) {
             Logger.getLogger(PrimosHilo.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    }
    }
   }

