package Main;

import java.util.Scanner;
import Sistemas.IssyApp;
import Users.User;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		IssyApp app = new IssyApp();
		
		System.out.println("\nSeleccione una opción: \n1. Registrarse. \n2. Iniciar Sesión. \n3. Salir.");
		int op = scan.nextInt();
		
		switch(op) {
			case 1: 
				registrarse(scan, app);
				break;
			case 2: 
				iniciarSesion(scan, app);
				break;
			case 3:
				break;
		}
		
		scan.close();

	}
	
	public static void registrarse(Scanner scan, IssyApp app) {
		System.out.println("\nIngrese su nombre: ");
		scan.nextLine();
		String name = scan.nextLine();
		
		System.out.println("\nIngrese su apellido: ");
		String surname = scan.nextLine();
		
		System.out.println("\nIngrese su e-mail: ");
		String email = scan.nextLine();
		
		System.out.println("\nIngrese su password: ");
		String password = scan.nextLine();
		
		boolean flag = app.signin(name, surname, email, password);
		
		if(flag) {
			System.out.println("\nIngrese al sistema con su cuenta nueva.");
			iniciarSesion(scan, app);
		}
	}
	
	public static void iniciarSesion(Scanner scan, IssyApp app) {
		System.out.println("\nIngrese su e-mail: ");
		scan.nextLine();
		String email = scan.nextLine();
		
		System.out.println("\nIngrese su password: ");
		String password = scan.nextLine();
		
		User usuario = app.login(email, password);
		
		if(usuario != null) {
			sesionIniciada(scan, app, usuario);
		}else {
			String[] args = {};
			main(args);
		}
	}
	
	public static void sesionIniciada(Scanner scan, IssyApp app, User usuario) {
		
			System.out.println("\nMenú Principal: \n1. Acceder al Sistema Juegos. \n2. Acceder al Sistema Cine. \n3. Acceder al Sistema Canciones. \n4. Ver mis Favoritos. \n5. Salir.");
			int op = scan.nextInt();
			app.menu(op, usuario);
		
			if(op != 4 && op != 5) {
				System.out.println("\n¿Desea guardar un item en Favoritos? Si / No");
				scan.nextLine();
				String rta = scan.nextLine();
		
				if(rta.equalsIgnoreCase("SI")) {
					
					boolean agregado = false;
					
					if(op == 1) {
						System.out.println("\nIngrese su título (Respete las mayúsculas): ");
						String tituloFav = scan.nextLine();
						agregado = app.agregarAFav(op, tituloFav, usuario);
					}else {
						System.out.println("\nIngrese su número ID: ");
						int idFav = scan.nextInt();
						agregado = app.agregarAFav(op, idFav, usuario);
					}
						
					if(agregado) {
				
						System.out.println("\nEl item se ha agregado correctamente.");
						sesionIniciada(scan, app, usuario);
					}else {
						System.out.println("\nNo se ha podido agregar el item.");
						sesionIniciada(scan, app, usuario);
					}
				}else {
					sesionIniciada(scan, app, usuario);
				}
			}else if(op == 4) {
				sesionIniciada(scan, app, usuario);
			}
		
	}
	
}