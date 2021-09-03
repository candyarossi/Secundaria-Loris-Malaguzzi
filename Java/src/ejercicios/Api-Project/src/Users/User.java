package Users;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;


public class User {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private ArrayList<String> favGames;
	private ArrayList<Integer> favFilms;
	private ArrayList<Integer> favSongs;
	
	
	public User() {
		super();
		this.name = "";
		this.surname = "";
		this.email = "";
		this.password = "";
		this.favGames = new ArrayList<String>();
		this.favFilms = new ArrayList<Integer>();
		this.favSongs = new ArrayList<Integer>();
	}

	
	public User(String name, String surname, String email, String password, ArrayList<String> favGames, ArrayList<Integer> favFilms, ArrayList<Integer> favSongs) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.favGames = favGames;
		this.favFilms = favFilms;
		this.favSongs = favSongs;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static JSONObject toJSON(User user) {
		
		JSONObject jobj = new JSONObject();
		
		try {
			
			jobj.put("name", user.getName());
			jobj.put("surname", user.getSurname());
			jobj.put("email", user.getEmail());
			jobj.put("password", user.getPassword());
			
		} catch (JSONException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return jobj;
	}
	
	public static User fromJSON(JSONObject jobj) {
		
		User user = new User();
		
		try {
			
			user.setName(jobj.getString("name"));
			user.setSurname(jobj.getString("surname"));
			user.setEmail(jobj.getString("email"));
			user.setPassword(jobj.getString("password"));
			
		} catch (JSONException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public String toString() {
		return "- Nombre: " + name + ", Apellido: " + surname + ", Email: " + email + ", Password: " + password + " -";
	}


	@Override
	public int hashCode() {
		return 1;
	}


	@Override
	public boolean equals(Object obj) {
		
		User other = (User) obj;
		if (!email.equals(other.email)) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean addFavJuegos(String gameName) {
		boolean agregado = favGames.add(gameName);
		return agregado;
	}
	
	public boolean addFavPelis(int id) {
		boolean agregado = favFilms.add(385128);
		return agregado;
	}
	
	public boolean addFavCancion(int id) {
		boolean agregado = favSongs.add(id);
		return agregado;
	}

	public ArrayList<String> getFavGames() {
		return favGames;
	}

	public void setFavGames(ArrayList<String> favGames) {
		this.favGames = favGames;
	}

	public ArrayList<Integer> getFavFilms() {
		return favFilms;
	}

	public void setFavFilms(ArrayList<Integer> favFilms) {
		this.favFilms = favFilms;
	}

	public ArrayList<Integer> getFavSongs() {
		return favSongs;
	}

	public void setFavSongs(ArrayList<Integer> favSongs) {
		this.favSongs = favSongs;
	}
	
}
