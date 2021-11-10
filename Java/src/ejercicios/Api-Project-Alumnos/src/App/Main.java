package App;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		User usuario = new User("Candela", "Yarossi", "cande@issymail.com", "1234");
		
		ArrayList<Object> favs = new ArrayList<Object>();

		Scanner scan = new Scanner(System.in);
		
		System.out.println("¡Bienvenido a ISSYapp! \nPor favor ingrese su email: ");
		String email = scan.nextLine();
		
		System.out.println("Ahora ingrese su contraseña: ");
		String password = scan.nextLine();
		
		if(email.equalsIgnoreCase(usuario.getEmail())) {
			if(password.equalsIgnoreCase(usuario.getPassword())) {
				//Inicio de app
				menu(scan, favs);
			}else {
				System.out.println("Contraseña incorrecta.");
			}
		}else{
			System.out.println("Usuario incorrecto.");
		}
	}
	
	public static void menu(Scanner scan, ArrayList<Object> favs) {
		
		System.out.println("\nIngrese la opción deseada: \n 1. Ver todos los videojuegos. \n 2. Ver todas las películas. \n 3. Ver todas las canciones. \n 4. Ver mis favoritos. \n 5. Salir.");
		int op = scan.nextInt();
		
		switch(op) {
			case 1:
				//Juegos
				String[] nombresJuegos = {"Counter Strike", "Valorant", "League Of Legends", "World Of Warcraft", "God of War", "Mortal Kombat X", "Quake", "Left 4 Dead", "Dark Souls", "Age Of Empires"};
				IGdbApi api1 = new IGdbApi();
				ArrayList<Videojuego> juegos = api1.get10Games(nombresJuegos);
				
				for(Videojuego aux : juegos) {
					System.out.println(aux.toString());
				}
				
				System.out.println("¿Desea guardar un item en su lista de favoritos? si/no");
				scan.nextLine();
				String rta = scan.nextLine();
				
				if(rta.equalsIgnoreCase("si")) {
					System.out.println("Ingrese el nombre del item a guardar: ");
					String item = scan.nextLine();
					
					Videojuego juego = new Videojuego();;
					try {
						juego = api1.getGameInfoId(item);
					} catch (Exception e) {
						System.out.println("No se pudo recuperar el videojuego.");
						e.printStackTrace();
					}
					
					favs.add(juego);
				}
				
				menu(scan, favs);
				
				break;
			case 2:
				//Peliculas
				TMdbApi api2 = new TMdbApi();
				ArrayList<Pelicula> peliculas = api2.get10Films();
				
				for(Pelicula aux : peliculas) {
					System.out.println(aux.toString());
				}
				
				System.out.println("¿Desea guardar un item en su lista de favoritos? si/no");
				scan.nextLine();
				String rta2 = scan.nextLine();
				
				if(rta2.equalsIgnoreCase("si")) {
					System.out.println("Ingrese el id del item a guardar: ");
					int item = scan.nextInt();
					
					Pelicula pelicula = new Pelicula();
					try {
						pelicula = api2.getFilmInfoId(item, 0);
					} catch (Exception e) {
						System.out.println("No se pudo recuperar la película.");
						e.printStackTrace();
					}
					
					favs.add(pelicula);
				}
				
				menu(scan, favs);
				
				break;
			case 3: 
				//Canciones
				ArrayList<Integer> idCanciones = new ArrayList<Integer>();
				
				int contador = 0;
				Random r = new Random();
				
				while(contador < 10) {
					int id = r.nextInt((10000000 - 3000000) + 1) + 3000000;
					idCanciones.add(id);
					contador++;
				}
				
				DeezerApi api3 = new DeezerApi();
				ArrayList<Cancion> canciones = api3.get10Songs(idCanciones);
				
				for(Cancion aux : canciones) {
					System.out.println(aux.toString());
				}
				
				System.out.println("¿Desea guardar un item en su lista de favoritos? si/no");
				scan.nextLine();
				String rta3 = scan.nextLine();
				
				if(rta3.equalsIgnoreCase("si")) {
					System.out.println("Ingrese el id del item a guardar: ");
					int item = scan.nextInt();
					
					Cancion cancion = new Cancion();
					try {
						cancion = api3.getSongInfo(item);
					} catch (Exception e) {
						System.out.println("No se pudo recuperar la canción.");
						e.printStackTrace();
					}
					
					favs.add(cancion);
				}
				
				menu(scan, favs);
				
				break;
			case 4:
				//FAVs
				for(Object aux : favs) {
					System.out.println(aux.toString());
				}
				
				menu(scan, favs);
				
				break;
			case 5:
				//Salir
				break;
		}
	}

}
