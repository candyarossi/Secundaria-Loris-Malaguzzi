package Sistemas;

import Users.User;
import Users.UserList;


public class IssyApp {

	private UserList usuarios;
	
	public IssyApp() {
		super();
		this.usuarios = new UserList();
	}
	
	public User login(String email, String pass) {
		
		boolean flag = false;
		int pos = -1;
		User userLog = new User();
		userLog.setEmail(email);
		userLog.setPassword(pass);
		
		for(int i=0; i<usuarios.contar(); i++) {
			User aux = usuarios.obtener(i);
			if(aux.equals(userLog)) {
				flag = true;
				pos = i;
			}
		}
		
		if(flag) {
			userLog = usuarios.obtener(pos);
			
			if(!pass.equals(userLog.getPassword())) {
				System.out.println("Contraseña Incorrecta.");
				userLog = null;
			}
		}else {
			System.out.println("El usuario no existe.");
			userLog = null;
		}
		
		return userLog;
	}
	
	public void menu(int num) {
		switch(num) {
			case 1:
				SistemaJuegos sistJuegos = new SistemaJuegos();
				sistJuegos.mostrarJuegos();
				break;
			case 2:
				SistemaCine sistPelis = new SistemaCine();
				sistPelis.mostrarPelis();
				break;
			case 3:
				SistemaMusica sistCanciones = new SistemaMusica();
				sistCanciones.mostrarCanciones();
				break;
		}
	}
}
