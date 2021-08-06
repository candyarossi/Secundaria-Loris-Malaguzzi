package Apis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject; 
import Objetos.Pelicula;


//API The Movie Data Base - Películas y series

public class TMdbApi {
	
	private String url_base;
	private String clave_V3; // api_key
	private String token_V4;


	
	public TMdbApi() {
		
		this.setUrl_base("https://api.themoviedb.org/3/");
		this.setClave_V3("f20416aa14acdc6b2cd1af3feb7633a6");
		this.setToken_V4("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmMjA0MTZhYTE0YWNkYzZiMmNkMWFmM2ZlYjc2MzNhNiIsInN1YiI6IjVmNzVlNTExMTk2NzU3MDAzYTk4YzA0ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.6LkAEY4Xg3emHTQjr4t-mO6ubmnVYVj26cLyRA3zew8");
		
	}
	
	
	public String getUrl_base() {
		return url_base;
	}

	public void setUrl_base(String url_base) {
		this.url_base = url_base;
	}

	public String getClave_V3() {
		return clave_V3;
	}

	public void setClave_V3(String clave_V3) {
		this.clave_V3 = clave_V3;
	}

	public String getToken_V4() {
		return token_V4;
	}

	public void setToken_V4(String token_V4) {
		this.token_V4 = token_V4;
	}

	
	
	public ArrayList<Pelicula> get10Films() {
		
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		
		try {
			String strPeliculas = this.getInfo("movie/now_playing", 1);
			
			JSONObject jobj = new JSONObject(strPeliculas);
			
			JSONArray arrayPeliculas = jobj.getJSONArray("results");
			
			for(int i=0; i<10; i++) {
				
				Pelicula nuevaPelicula = this.getFilm(arrayPeliculas.getJSONObject(i));
				
				peliculas.add(nuevaPelicula);
			}
				
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		return peliculas;
	}


	
	public String getInfo(String query, int page) throws Exception {
		
		StringBuilder resultado = new StringBuilder();
		
		URL url;
		
		if(page == 0) {
			url = new URL(this.getUrl_base() + query + "?api_key=" + this.getClave_V3() + "&language=es");
		}else {
			url = new URL(this.getUrl_base() + query + "?api_key=" + this.getClave_V3() + "&language=es&page=" + page);
		}
		
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
	
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		return resultado.toString();
	}

	
	
	public Pelicula getFilm(JSONObject infoPelicula) {
		
		Pelicula nuevaPelicula = new Pelicula();
		
		try {
			nuevaPelicula.setId(infoPelicula.getInt("id"));
			nuevaPelicula.setTitle(infoPelicula.getString("title"));
			nuevaPelicula.setOriginal_language(infoPelicula.getString("original_language"));
			nuevaPelicula.setPoster_path(infoPelicula.getString("poster_path"));
			nuevaPelicula.setRelease_date(infoPelicula.getString("release_date"));
			nuevaPelicula.setAdult(infoPelicula.getBoolean("adult"));
			
			JSONArray arrayGenresMovie = infoPelicula.getJSONArray("genre_ids");
			
			try {
				
				JSONObject objGenresArray = new JSONObject(this.getInfo("genre/movie/list", 0));
				
				JSONArray arrayGenresApi = objGenresArray.getJSONArray("genres");
				
				ArrayList<String> generos = new ArrayList<String>();
				
				for(int i=0; i<arrayGenresApi.length(); i++) {
					
					for(int j=0; j<arrayGenresMovie.length(); j++) {
					
						JSONObject objGeneroApi = arrayGenresApi.getJSONObject(i);
					
						if(arrayGenresMovie.getInt(j) == objGeneroApi.getInt("id")) {
							
							String nombreGenero = objGeneroApi.getString("name");
							generos.add(nombreGenero);
						}
					}
				}
				
				nuevaPelicula.setGenres(generos);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (JSONException e) {
			//e.printStackTrace();
		}
		
		return nuevaPelicula;
	}
	
}


