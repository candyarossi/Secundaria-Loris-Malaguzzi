package Sistemas;

import java.util.ArrayList;
import Apis.TMdbApi;
import Objetos.Pelicula;


public class SistemaCine {

	private ArrayList<Pelicula> pelis;
	
	public SistemaCine() {
		super();
		this.pelis = new ArrayList<Pelicula>();
	}
	
	public void mostrarPelis() {
		
		TMdbApi tmdb = new TMdbApi();
		
		this.pelis = tmdb.get10Films(); 
		
		for(Pelicula aux : pelis) {
			System.out.println(aux.toString());
		}
		
	}
}
