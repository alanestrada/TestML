package testml;
/**
 *
 * @author Alan Estrada
 */
public class Operaciones {
 
 public static boolean esprimo(int num){
   if(num<11) return false;                  //Considero los numeros primos >= 11 para evaluar los números mayores o iguales a dos digitos
    else
        for(int i=2;i<=Math.sqrt(num);i++){  // utilizo la raíz cuadrada del número para que busque los primos menores al resultado de la raiz cuadrada para no hacer la busqueda entera. La raiz cuadrada si no nos da un numero exacto "el número evaluado" es una tentativa de número primo
        if (num%i==0)
          return false;  
        }
    return true;
    }
 
 public static String circular (String num){ //metodo para realizar la rotacion de los digitos > = 2
  String primero=num.substring(1);
  String ultimo=String.valueOf(num.charAt(0));
  num=primero.concat(ultimo);
     return num;
  }
 }

