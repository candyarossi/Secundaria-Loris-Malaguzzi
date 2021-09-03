package Apis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import Objetos.Cancion;


//API Deezer - Musica

public class DeezerApi {

	private String url_base;
	

	public DeezerApi() {
		
		this.setUrl_base("https://api.deezer.com/");
		
	}
	
	
	public String getUrl_base() {
		return url_base;
	}

	public void setUrl_base(String url_base) {
		this.url_base = url_base;
	}
	
	
	
	public ArrayList<Cancion> get10Songs(ArrayList<Integer> idsCanciones) {
		
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		
		for(Integer aux : idsCanciones) {
			try {
				Cancion nuevaCancion = this.getSongInfo(aux);
				
				canciones.add(nuevaCancion);
				
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
		return canciones;
	}


	
	public Cancion getSongInfo(Integer songId) throws Exception {
		
		StringBuilder resultado = new StringBuilder();
		
		Cancion nuevaCancion = new Cancion();
	    
		URL url = new URL(this.getUrl_base() + "track/" + songId);

		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
	
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		nuevaCancion = this.getSong(resultado.toString());
		
		return nuevaCancion;
	}
	
	
	
	public Cancion getSong(String infoCancion) {
		
		Cancion nuevaCancion = new Cancion();
		
		try {
			JSONObject jobj = new JSONObject(infoCancion);
			
			nuevaCancion.setId(jobj.getInt("id"));
			nuevaCancion.setTitle(jobj.getString("title"));
			nuevaCancion.setLink(jobj.getString("link"));
			nuevaCancion.setDuration(jobj.getInt("duration"));
			nuevaCancion.setRelease_date(jobj.getString("release_date"));
			
			try {
				nuevaCancion.setPreview(new URL(jobj.getString("preview")));
			} catch (MalformedURLException e) {
				//e.getMessage();
				//e.printStackTrace();
				try {
					nuevaCancion.setPreview(new URL("https://www.deezer.com/mx/"));
				} catch (MalformedURLException e1) {
					e1.getMessage();
					e1.printStackTrace();
				}
			}
			
			JSONObject artista = jobj.getJSONObject("artist");
			nuevaCancion.setArtist(artista.getString("name"));
			
			JSONObject album = jobj.getJSONObject("album");
			nuevaCancion.setAlbum(album.getString("title"));
			
		} catch (JSONException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return nuevaCancion;
	}
	
}
