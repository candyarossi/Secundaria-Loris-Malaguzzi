// MODELO GENERICO DE CLASE
// Importación de utilidades o librerías externas
import java.util.*;

// Declaración de la clase
class Clase
{  
    // Lista de Atributos:
    private String attr_string;
    private int attr_int;
    private boolean attr_boolean;
    
    // Métodos:
    // Constructores: (Son 2: uno que inicia todos los atributos en "vacío", y otro que recibe valores)
    public Clase(){
        this.attr_string = "";  // o también -> this.attr_string = new String();
        this.attr_int = 0;
        this.attr_boolean = false; // o true, lo que necesiten al comenzar
    }
    
    public Clase(String new_string, int new_int, boolean new_boolean){
        this.attr_string = new_string;
        this.attr_int = new_int;
        this.attr_boolean = new_boolean;
    }
    
    // Getters y Setters: (Uno de cada uno por cada atributo)
    // Setter: (Asigna un valor al atributo)
    public void setAttr_string(String new_string){
        this.attr_string = new_string;
    }
    
    public void setAttr_int(int new_int){
        this.attr_int = new_int;
    }
    
    public void setAttr_boolean(boolean new_boolean){
        this.attr_boolean = new_boolean;
    }
    
    // Getter: (Devuelve el valor del atributo)
    public String getAttr_string(){
        return this.attr_string;
    }
    
    public int getAttr_int(){
        return this.attr_int;
    }
    
    public boolean getAttr_boolean(){
        return this.attr_boolean;
    }
    
    // Métodos sobreescritos:
    // Son métodos que están definidos en clases padres y podemos cambiarles la funcionalidad
    // Para eso utilizamos la palabra @Override
    @Override
    public String toString(){
        return "Clase: [Attr_string: " + this.attr_string + ", Attr_int: " + this.attr_int + ", Attr_boolean: " + this.attr_boolean + "]";
    }
    
}