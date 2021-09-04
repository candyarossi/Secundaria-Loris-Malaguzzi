package Main;

import java.util.Scanner;
import Sistemas.IssyApp;
import Users.User;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		IssyApp app = new IssyApp();
		
		System.out.println("Seleccione una opción: \n1. Registrarse. \n2. Iniciar Sesión.");
		int op = scan.nextInt();
		
		if(op == 1) {
			registrarse(scan, app);
		}else if(op == 2) {
			iniciarSesion(scan, app);
		}
	
		scan.close();

	}
	
	public static void registrarse(Scanner scan, IssyApp app) {
		System.out.println("Ingrese su nombre: ");
		scan.nextLine();
		String name = scan.nextLine();
		
		System.out.println("Ingrese su apellido: ");
		String surname = scan.nextLine();
		
		System.out.println("Ingrese su e-mail: ");
		String email = scan.nextLine();
		
		System.out.println("Ingrese su password: ");
		String password = scan.nextLine();
		
		boolean flag = app.signin(name, surname, email, password);
		
		if(flag) {
			System.out.println("Ingrese al sistema con su cuenta nueva.");
			iniciarSesion(scan, app);
		}
	}
	
	public static void iniciarSesion(Scanner scan, IssyApp app) {
		System.out.println("Ingrese su e-mail: ");
		scan.nextLine();
		String email = scan.nextLine();
		
		System.out.println("Ingrese su password: ");
		String password = scan.nextLine();
		
		User usuario = app.login(email, password);
		
		//User usuario = app.login("candyarossi@admin.com", "123456");
		
		if(usuario != null) {
			sesionIniciada(scan, app, usuario);
		}
	}
	
	public static void sesionIniciada(Scanner scan, IssyApp app, User usuario) {
		
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
						String tituloFav = scan.nextLine();
						agregado = app.agregarAFav(op, tituloFav, usuario);
					}else {
						System.out.println("Ingrese su número ID: ");
						int idFav = scan.nextInt();
						agregado = app.agregarAFav(op, idFav, usuario);
					}
						
					if(agregado) {
				
						System.out.println("¿Desea volver al Menú principal? Si / No");
						scan.nextLine();
						rta = scan.nextLine();
					}else {
						System.out.println("No se ha podido agregar el item. \n¿Desea volver al Menú principal? Si / No");
						rta = scan.nextLine();
					}
				}
			}else if(op == 5){ 
				break;
			}else{
				System.out.println("¿Desea volver al Menú principal? Si / No");
				scan.nextLine();
				rta = scan.nextLine();
			}
		}while (rta.equalsIgnoreCase("SI"));
		
	}
	
}