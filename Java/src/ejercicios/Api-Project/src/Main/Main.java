package Main;

import java.util.Scanner;
import Sistemas.IssyApp;
import Users.User;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		IssyApp app = new IssyApp();
		
		//System.out.println("Ingrese su e-mail: ");
		//String email = scan.nextLine();
		
		//System.out.println("Ingrese su password: ");
		//String password = scan.nextLine();
		
		//User usuario = app.login(email, password);
		
		User usuario = app.login("candyarossi@admin.com", "123456");
		
		if(usuario != null) {
			
			String rta = "";
			
			do {
			
				System.out.println("Menú Principal: \n1. Acceder al Sistema Juegos. \n2. Acceder al Sistema Cine. \n3. Acceder al Sistema Canciones. \n4. Ver mis Favoritos. \n5. Salir.");
				int op = scan.nextInt();
				app.menu(op, usuario);
			
				if(op != 4 && op != 5) {
					System.out.println("¿Desea guardar un item en Favoritos? Si / No");
					scan.nextLine();
					String rta2 = scan.nextLine();
			
					if(rta2.equalsIgnoreCase("SI")) {
						
						boolean agregado = false;
						
						if(op == 1) {
							System.out.println("Ingrese su título (Respete las mayúsculas): ");
							//scan.nextLine();
							String tituloFav = scan.nextLine();
							agregado = app.agregarAFav(op, tituloFav, usuario);
						}else {
							System.out.println("Ingrese su número ID: ");
							int idFav = scan.nextInt();
							agregado = app.agregarAFav(op, idFav, usuario);
						}
							
						if(agregado) {
					
							System.out.println("¿Desea volver al Menú principal? Si / No");
							//scan.nextLine();
							rta = scan.nextLine();
						}else {
						System.out.println("No se ha podido agregar el item. \n¿Desea volver al Menú principal? Si / No");
						}
					}
				//}else if(op == 5){
				//	break;
				}else{
					System.out.println("¿Desea volver al Menú principal? Si / No");
					//scan.nextLine();
					rta = scan.nextLine();
				}
			}while (rta.equalsIgnoreCase("SI"));
			
			scan.close();
		}
		
	}
	
}