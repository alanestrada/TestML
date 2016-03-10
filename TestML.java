package testml;
/**
 *
 * @author Alan Estrada
 */
public class TestML {
  
    public static void main(String[] args) {
        
        PrimosHilo numerosprimos= new PrimosHilo("Numeros primos");
        numerosprimos.start();
        PrimosCircularesHilo numprimoscirculares=new PrimosCircularesHilo("Primos circulares",numerosprimos.getListaPrimos());
        numprimoscirculares.start();         
    }  
}
