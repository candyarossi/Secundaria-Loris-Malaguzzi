import java.util.*;

class Main
{ 
    public static void main(String args[])
  { 
    // Los operadores son &&, || y !
    // Los resultados de combinar TRUE y FALSE con estos operadores son:
    
    // Tabla de resultados operador && ("y")
    // true && true = true
    boolean resultado = true && true;
    System.out.println(resultado);

    // true && false = false
    boolean resultado = true && false;
    System.out.println(resultado);

    // false && true = false
    boolean resultado = false && true;
    System.out.println(resultado);

    // false && false = false
    boolean resultado = false && false;
    System.out.println(resultado);


    // Tabla de resultados operador || ("o")
    // true || true = true
    boolean resultado = true || true;
    System.out.println(resultado);
    // true || false = true
    boolean resultado = true || false;
    System.out.println(resultado);
    // false || true = true
    boolean resultado = false || true;
    System.out.println(resultado);
    // false || false = false
    boolean resultado = false || false;
    System.out.println(resultado);


    // Operador ! 
    // !true = false
    boolean resultado = !true;
    System.out.println(resultado);

    // !false = true
    boolean resultado = !false;
    System.out.println(resultado);

  }
}
