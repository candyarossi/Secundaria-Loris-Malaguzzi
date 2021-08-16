import java.util.*;

class Main
{ 
    public static void main(String args[])
  { 
    // Estructura condicional IF...ELSE
    // Vamos a crear 2 variables para comparar:
    int primerNumero = 5;
    int segundoNumero = 4;
    
    if(primerNumero < segundoNumero){
        // Sentencias que se ejecutan si la Condición1 es true.
        System.out.print(primerNumero, " es menor a ", segundoNumero);
    }else{
        // Sentencias que se ejecutan cuando la Condición1 es false.
        System.out.print(primerNumero, " es mayor a ", segundoNumero);
    }
    
    
    // Estructura condicional IF...ELSE IF...ELSE
    if(primerNumero < segundoNumero){
        // Sentencias que se ejecutan si la Condición1 es true.
        System.out.print(primerNumero, " es menor a ", segundoNumero);
    }else if(primerNumero > segundoNumero){
        // Sentencias que se ejecutan si la Condición1 es false y la Condición2 es true.
        System.out.print(primerNumero, " es mayor a ", segundoNumero);
    }else{
        // Sentencias que se ejecutan cuando todas las Condiciones son false.
        System.out.print(primerNumero, " es igual a ", segundoNumero);
    }
    

    // Estructura condicional SWITCH
    int variable = 10;

    switch (variable) {
        case 1:
            // Sentencias que se ejecutan cuando Variable == Valor1.
            System.out.print(variable);
            break;
        case 2:
            //Sentencias que se ejecutan cuando Variable == Valor2.
            System.out.print(variable);
            break;
        case N:
            //Sentencias que se ejecutan cuando Variable == ValorN.
            System.out.print(variable);
            break;
        default:
            //Sentencias que se ejecutan cuando Variable no coincide con ningún Valor.
            System.out.print(variable);
            break;
    }

    
    // Estructura cíclica WHILE
    // Vamos a imprimir números del 1 al 10:
    int numero = 1;
    
    while(numero < 10){
        // Sentencias que se ejecutan si la Condición1 es true.
        System.out.print(numero);
        numero = numero + 1;
    } 
    
    
    // Estructura cíclica FOR
    // Como se puede usar para Arreglos, vamos a crear uno:
    String[] climas = {"Ecuatorial", "Tropical", "Mediterráneo", "Continental", "Alta Montaña"}
    
    for(int i=0; i<climas.lenght; i++){
        // Sentencias que se ejecutan en cada vuelta del ciclo.
        System.out.print(climas[i]);
    }

    for(String aux : climas){
        // Sentencias que se ejecutan en cada vuelta del ciclo.
        System.out.print(aux.toString());
    }
    
  }
}