package Sistemas;

import java.util.ArrayList;
import java.util.Random;
import Apis.DeezerApi;
import Objetos.Cancion;


public class SistemaMusica {

	private ArrayList<Cancion> canciones;
	private ArrayList<Integer> idCanciones;
	
	public SistemaMusica() {
		super();
		this.canciones = new ArrayList<Cancion>();
		this.idCanciones = new ArrayList<Integer>();
		int contador = 0;
		Random r = new Random();
		
		while(contador < 10) {
			int id = r.nextInt((10000000 - 3000000) + 1) + 3000000;
			idCanciones.add(id);
			contador++;
		}
	}
	
	public void mostrarCanciones() {
		
		DeezerApi dzdb = new DeezerApi();
		
		this.canciones = dzdb.get10Songs(idCanciones);
		
		for(Cancion aux : canciones) {
			if(aux.getId() != 0) {
				System.out.println(aux.toString());
			}
		}
	}
}
