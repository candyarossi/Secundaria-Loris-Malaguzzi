import java.util.*;

class Main
{ 
    public static void main(String args[])
  {
    // Escribir el código necesario para determinar si 2 strings son iguales o no
    String str1 = "Hola";
    String str2 = "Hello";

    if(str1.equals(str2)){  // O con equalsIgnoreCase
        System.out.println("Son iguales.");
    }else{
        System.out.println("No son iguales.");
    }

    // O también

    if(str1.compareTo(str2) == 0){  // O con compareToIgnoreCase
        System.out.println("Son iguales.");
    }else{
        System.out.println("No son iguales.");
    }

  }
}