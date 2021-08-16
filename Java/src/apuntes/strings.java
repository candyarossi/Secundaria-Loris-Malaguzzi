import java.util.*;

class Main
{ 
    public static void main(String args[])
  { 
    // Manejo de Strings

    // Declaramos una String
    String nombre = "Candela";


    // Nos devuelve el tamaño que tiene la cadena
    System.out.println(nombre.length());


    // Devuelve el carácter que se encuentra en el índice indicado
    System.out.println(nombre.chatAt(4));


    // Nos devuelve la posición de un carácter dentro de la cadena de texto
    System.out.println(nombre.indexOf("e"));


    // Nos permite comparar si dos cadenas de texto son iguales
    String nombre2 = "candela";
    System.out.println(nombre1.equals(nombre2));


    // Compara dos cadenas de caracteres omitiendo si los caracteres están en mayúsculas o en minúsculas
    System.out.println(nombre1.equalsIgnoreCase(nombre2));


    // En este caso compara a las cadenas léxicamente
    System.out.println(nombre1.compareTo(nombre2));


    // Este método se comportará igual que el anterior. Pero ignorando las mayúsculas
    System.out.println(nombre1.compareToIgnoreCase(nombre2));


    // Convierte todos los caracteres en minúsculas
    System.out.println(nombre.toLowerCase());


    // Convierte todos los caracteres a mayúsculas
    System.out.println(nombre.toUpperCase());


    // Elimina los espacios en blanco de la cadena
    String nombre = "Candela Yarossi";
    System.out.println(nombre.trim());


    // Este método lo utilizaremos cuando lo que queramos hacer sea el remplazar un carácter por otro
    String nombre = "Cande";
    System.out.println(nombre. replace("e","y"));

  }
}
