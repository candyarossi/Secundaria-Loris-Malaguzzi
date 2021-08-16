import java.util.*;

class Main
{  
  public static void main(String args[])
  {  
    // Declaración de variables
    char letra = "c";
    String nombre = "Candela";
    int numeroEntero = 587;
    double numeroDecimal = 3.14;
    boolean booleano = true;


    // Salida por pantalla 
    System.out.println("Hello World!"); 

    String variable = "Candela";
    System.out.println("Hello " + variable);


    // Ingreso por teclado
    // Palabras:
    Scanner scan = new Scanner(System.in);
    String variable = scan.nextLine();
    scan.close();

    // Letras:
    Scanner scan = new Scanner(System.in);
    char variable = scan. next().charAt(0);
    scan.close();

    // Números enteros:
    Scanner scan = new Scanner(System.in);
    int variable = scan. nextInt();
    scan.close();

    // Números decimales:
    Scanner scan = new Scanner(System.in);
    double variable = scan. nextDouble();
    scan.close();

  }
}