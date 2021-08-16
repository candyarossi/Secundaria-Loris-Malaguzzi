import java.util.*;

class Main
{  
  public static void main(String args[])
  {  
    // Existen 2 formas de crear objetos:
    // Instanciando un objeto con los valores de los atributos
      Clase clase1 = new Clase("String", 1, true);

    // Instanciando un objeto vacío y luego agregando algunos o todos valores de los atributos
      Clase clase2 = new Clase();
      clase2.setAttr_string("String");
      clase2.setAttr_int(1);
      clase2.setAttr_boolean(true);

    // Existen 2 formas de obtener la información de un objeto:
    // Imprimiendo en pantalla todo el objeto
      System.out.println(clase1.toString());

    //  Imprimiendo en pantalla cada uno de sus valores, o el que se necesite
      System.out.println("Attr_string de Clase: " + clase2.getAttr_string());
      System.out.println("Attr_int de Clase: " + clase2.getAttr_int());
      System.out.println("Attr_boolean de Clase: " + clase2.getAttr_boolean());
  }
}