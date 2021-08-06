class Persona {
    
    private String nombre;
    private String apellido;

    public Persona(){
        this.nombre = "";
        this.apellido = new String();
    }

    public Persona(String nuevo_nombre, String nuevo_apellido){
        this.nombre = nuevo_nombre;
        this.apellido = nuevo_apellido;
    }

    public String toString(){

        return "Datos de la persona: " + this.nombre + " " + this.apellido;
    }
}
