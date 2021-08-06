package Main;

import java.util.Scanner;
import Sistemas.IssyApp;
import Users.User;


public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		IssyApp app = new IssyApp();
		
		System.out.println("Ingrese su e-mail: ");
		
		String email = scan.nextLine();
		
		System.out.println("Ingrese su password: ");
		
		String password = scan.nextLine();
		
		User usuario = app.login(email, password);
		
		if(usuario != null) {
			
			System.out.println("Menú Principal: \n1. Acceder al Sistema Juegos. \n2. Acceder al Sistema Cine. \n3. Acceder al Sistema Canciones.");
			
			int op = scan.nextInt();
			app.menu(op);
			scan.close();
		}
		
	}
	
}