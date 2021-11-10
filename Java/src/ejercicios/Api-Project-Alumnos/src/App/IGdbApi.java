package App;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


// API Twitch - Videojuegos

public class IGdbApi {
	
	private String url_base;
	private String client_id;
	private String secret_client;
	private String authorization;
	private String user_agent;
	private String[] fields = {"id","name","category","summary","url","platforms.name","cover.url","age_ratings.category","age_ratings.rating","game_modes.name","first_release_date","genres.name","involved_companies.company.name"};
	
	
	
	public IGdbApi() {
		
		this.setUrl_base("https://api.igdb.com/v4/");
		this.setClient_id("fmyceeybnz9bon2u00s5wprlwin5ty");
		this.setSecret_Client("npepydkx67afrjz5u90xgdzx0wq693");
		this.setUser_agent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36");
		
		String tokenStr = "";
		
		try {
			
			tokenStr = this.Token();
			
			JSONObject jobj = new JSONObject(tokenStr);
			
			String tokenType = jobj.getString("token_type");
			String tokenTypeCap = tokenType.replace(tokenType.charAt(0), tokenType.toUpperCase().charAt(0));
			
			this.setAuthorization(tokenTypeCap + " " + jobj.getString("access_token"));
			 
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	
	public String getUrl_base() {
		return url_base;
	}

	public void setUrl_base(String url_base) {
		this.url_base = url_base;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	
	public String getSecret_Client() {
		return secret_client;
	}

	public void setSecret_Client(String secret_client) {
		this.secret_client = secret_client;
	}

	public String getAuthorization() {
		return authorization;
	}

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String user_agent) {
		this.user_agent = user_agent;
	}
	
	
	
	private String Token() throws Exception {
		
		String urlToken = "https://id.twitch.tv/oauth2/token?client_id=" + this.getClient_id() + "&client_secret=" + this.getSecret_Client() + "&grant_type=client_credentials";
		
		StringBuilder resultado = new StringBuilder();
		
		URL url = new URL(urlToken);

		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("POST");
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
	
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		return resultado.toString();
	}
	
	
	
	public ArrayList<Videojuego> get10Games(String[] nombresJuegos) {
		
		ArrayList<Videojuego> juegos = new ArrayList<Videojuego>();
		
		for(String aux2 : nombresJuegos) {
			try {
				String infoJuego = this.getGameInfo(aux2);
				
				Videojuego nuevoJuego = this.getVideoGame(infoJuego);
				
				juegos.add(nuevoJuego);
				
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		
		return juegos;
	}

	
	
	public String getGameInfo(String gameName) throws Exception {
		
		String strFields = this.concatFields();
		
		StringBuilder resultado = new StringBuilder();
		
		// Los espacios se deben escribir como "%20"
		gameName = gameName.replace(" ", "%20");
		
		URL url = new URL(this.getUrl_base() + "games/?fields="+strFields+"&search="+gameName);
		
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("POST");
		conexion.addRequestProperty("Client-ID", this.getClient_id());
		conexion.addRequestProperty("Authorization", this.getAuthorization());
		conexion.addRequestProperty("User-Agent", this.getUser_agent());
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
	
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		return resultado.toString();
	}
	
	
	
	public Videojuego getVideoGame(String infoJuego) {
		
		Videojuego nuevoJuego = new Videojuego();
		
		JSONArray jarray;
		try {
			jarray = new JSONArray(infoJuego);
			
			JSONObject jobj = new JSONObject(jarray.get(0).toString());
			
			nuevoJuego.setName(jobj.getString("name"));
			nuevoJuego.setId(jobj.getInt("id"));
			nuevoJuego.setDescription(jobj.getString("summary"));
			nuevoJuego.setWebsite(jobj.getString("url"));
			nuevoJuego.setCategory_rating(jobj.getInt("category"));
			nuevoJuego.setCover(jobj.getJSONObject("cover").getString("url"));
			nuevoJuego.setRelease_date(String.valueOf(Instant.ofEpochSecond(jobj.getLong("first_release_date"))));
			
			ArrayList<String> companias = new ArrayList<String>();
			JSONArray arrayComp = jobj.getJSONArray("involved_companies");
			
			for(int i=0; i<arrayComp.length(); i++) {
				JSONObject comp = arrayComp.getJSONObject(i);
				JSONObject compName = comp.getJSONObject("company");
				companias.add(compName.getString("name"));
			}
			
			nuevoJuego.setCompany(companias);
			
			try {
				JSONArray arrayAge = jobj.getJSONArray("age_ratings");
				
				for(int i=0; i<arrayAge.length(); i++) {
					JSONObject jage = (JSONObject)arrayAge.get(i);
					
					if(jage.getInt("category") == 2){
						nuevoJuego.setAge_rating_PEGI(jage.getInt("rating"));
					}else if(jage.getInt("category") == 1){
						nuevoJuego.setAge_rating_ESRB(jage.getInt("rating"));
					}
				}
				
			} catch(JSONException ex) {
				nuevoJuego.setAge_rating_PEGI(13);
				nuevoJuego.setAge_rating_ESRB(13);
			}
			
			ArrayList<String> generos = new ArrayList<String>();
			JSONArray arrayGenres = jobj.getJSONArray("genres");
			
			for(int i=0; i<arrayGenres.length(); i++) {
				JSONObject genr = arrayGenres.getJSONObject(i);
				generos.add(genr.getString("name"));
			}
			
			nuevoJuego.setGenres(generos);
			
			ArrayList<String> modos = new ArrayList<String>();
			JSONArray arrayModes = jobj.getJSONArray("game_modes");
			
			for(int i=0; i<arrayModes.length(); i++) {
				JSONObject mod = arrayModes.getJSONObject(i);
				modos.add(mod.getString("name"));
			}
			
			nuevoJuego.setGame_mode(modos);
			
			ArrayList<String> plataformas = new ArrayList<String>();
			JSONArray arrayPlat = jobj.getJSONArray("platforms");
			
			for(int i=0; i<arrayPlat.length(); i++) {
				JSONObject plat = arrayPlat.getJSONObject(i);
				plataformas.add(plat.getString("name"));
			}
			
			nuevoJuego.setPlatforms(plataformas);
			
		} catch (JSONException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return nuevoJuego;
	}
	
	
	
	public Videojuego getGameInfoId(String gameName) throws Exception {
		
		String strFields = this.concatFields();
		
		gameName = gameName.replace(" ", "%20");
		
		StringBuilder resultado = new StringBuilder();
		
		Videojuego nuevoJuego = new Videojuego();
		
		URL url = new URL(this.getUrl_base() + "games/?fields="+strFields+"&search="+gameName);
		
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("POST");
		conexion.addRequestProperty("Client-ID", this.getClient_id());
		conexion.addRequestProperty("Authorization", this.getAuthorization());
		conexion.addRequestProperty("User-Agent", this.getUser_agent());
		
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "UTF-8"));
	
		String linea;
		
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		
		rd.close();
		
		nuevoJuego = this.getVideoGame(resultado.toString());
		
		return nuevoJuego;
	}
	
	
	
	public String concatFields() {
		
		StringBuilder strFields = new StringBuilder();
		
		for(String aux : this.fields) {
			strFields.append(aux + ",");
		}
		
		strFields.deleteCharAt(strFields.length()-1);
		
		return strFields.toString();
	}
	
}
