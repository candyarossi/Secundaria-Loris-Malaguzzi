package Sistemas;

import java.util.ArrayList;
import Apis.IGdbApi;
import Objetos.Videojuego;


public class SistemaJuegos {

	private ArrayList<Videojuego> juegos;
	private String[] nombresJuegos = {"Counter-Strike: Global Offensive","The Legend Of Zelda","Minecraft","Valorant","Cyberpunk 2077","Genshin Impact","Clash Royale","League Of Legends","Fall Guys","Outlast"};

	public SistemaJuegos() {
		super();
		this.juegos = new ArrayList<Videojuego>();
	}
	
	public void mostrarJuegos() {
		
		IGdbApi igdb = new IGdbApi();
		
		this.juegos = igdb.get10Games(nombresJuegos);
		
		for(Videojuego aux : juegos) {
			System.out.println(aux.toString());
		}
	}
	
}
