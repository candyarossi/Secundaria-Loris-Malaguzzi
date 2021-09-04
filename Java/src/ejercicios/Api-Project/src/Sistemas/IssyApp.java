package Sistemas;

import java.util.ArrayList;
import Apis.DeezerApi;
import Apis.IGdbApi;
import Apis.TMdbApi;
import Objetos.Cancion;
import Objetos.Pelicula;
import Objetos.Videojuego;
import Users.User;
import Users.UserList;


public class IssyApp {

	private UserList usuarios;
	private ArrayList<String> favGames;
	private ArrayList<Integer> favFilms;
	private ArrayList<Integer> favSongs;
	
	
	public IssyApp() {
		super();
		this.usuarios = new UserList();
		this.favGames = new ArrayList<String>();
		this.favFilms = new ArrayList<Integer>();
		this.favSongs = new ArrayList<Integer>();
	}
	
	public boolean signin(String name, String surname, String email, String password){
		
		User usuario = new User(name, surname, email, password);
		boolean flag = usuarios.agregarUser(usuario);
		UserList.GuardarArchivo(usuarios);
		
		return flag;
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
	
	public void menu(int num, User usuario) {
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
			case 4: 
				this.mostrarFavs(usuario);
				break;
			case 5:
				UserList.GuardarArchivo(usuarios);
				break;
		}
	}
	
	public boolean agregarAFav(int op, Object obj, User usuario) {
		boolean agregado = false;
		
		switch(op) {
			case 1:
				agregado = usuario.addFavJuegos((String) obj);
				break;
			case 2:
				agregado = usuario.addFavPelis((int) obj);
				break;
			case 3:
				agregado = usuario.addFavCancion((int) obj);
				break;
		}
		 
		return agregado;
	}
	
	public void mostrarFavs(User usuario) {
		
		this.favGames = usuario.getFavGames();
		this.favFilms = usuario.getFavFilms();
		this.favSongs = usuario.getFavSongs();
		
		this.mostrarJuegosFav();  
		this.mostrarPelisFav();  
		this.mostrarCancionFav();  
	}
	
	public void mostrarJuegosFav() { 
		
		if(this.favGames.size() > 0) {
			for(String aux : this.favGames) {
				IGdbApi igdb = new IGdbApi();
				Videojuego juego = new Videojuego();
				
				try {
					juego = igdb.getGameInfoId(aux);
				} catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println(juego.toString());
			}
		}
	}
	
	public void mostrarPelisFav() {
		
		if(this.favFilms.size() > 0) {
			for(Integer aux : this.favFilms) {
				TMdbApi tmdb = new TMdbApi();
				Pelicula peli = new Pelicula();
				
				try {
					peli = tmdb.getFilmInfoId(aux, 0);
				} catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println(peli.toString());
			}
		}
	}

	public void mostrarCancionFav() {
	
		if(this.favSongs.size() > 0) {
			for(Integer aux : this.favSongs) {
				DeezerApi deezer = new DeezerApi();
				Cancion cancion = new Cancion();
				
				System.out.println("Cancion: " + aux);
				
				try {
					cancion = deezer.getSongInfo(aux);
				} catch (Exception e) {
					e.getMessage();
					e.printStackTrace();
				}
				System.out.println(cancion.toString());
			}
		}
	}

}
