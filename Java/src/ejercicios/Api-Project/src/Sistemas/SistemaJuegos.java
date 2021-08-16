package Sistemas;

import java.util.ArrayList;
import Apis.IGdbApi;
import Objetos.Videojuego;


public class SistemaJuegos {

	private ArrayList<Videojuego> juegos;
	private String[] nombresJuegos = {"Counter-Strike%20Global%20Offensive","The%20Legend%20Of%20Zelda","Minecraft","Valorant","Cyberpunk%202077","Genshin%20Impact","Clash%20Royale","League%20Of%20Legends","Fall%20Guys","Outlast"};
	// Los espacios se deben escribir como "%20"

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
