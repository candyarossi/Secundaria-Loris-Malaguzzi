class CrearKey
 {
   public static void imprimirKey()
   { 
     String key = generarKey();
     System.out.println("Key: " + key);
   }
   
   public static char generarChar(){
     int numero = (int)(Math.random()*90+1);
     char letra = 'a';
     if(numero >= 48 && numero <= 57){
         letra = (char)numero;
     }else if(numero >= 65 && numero <= 90){
         letra = (char)numero;
     }else if(numero == 48 || numero == 49 || numero == 65 ){
         letra = 'a';
     }
     return letra;
   }
   
   public static String generarKey(){
     StringBuilder strbuilder = new StringBuilder();
     while(strbuilder.length() < 25){
         char letra = generarChar();
         
         if(letra != 'a'){
           strbuilder.append(letra);
         }
     }
     for(int i=5; i<25; i=i+6){
         strbuilder.insert(i, "-");
     }
     return strbuilder.toString();
   }
 }