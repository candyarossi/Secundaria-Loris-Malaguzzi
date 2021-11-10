package App;
import java.util.ArrayList;


public class Videojuego {
	
	private int id;
	private String name;
	private String category_rating;
	private String age_rating_PEGI;
	private String age_rating_ESRB;
	private ArrayList<String> company;
	private String cover;
	private ArrayList<String> game_mode;
	private ArrayList<String> genres;
	private ArrayList<String> platforms;
	private String release_date;
	private String website;
	private String description;
	
	
	public Videojuego() {
		super();
		this.id = 0;
		this.name = "";
		this.category_rating = "";
		this.age_rating_PEGI = "";
		this.age_rating_ESRB = "";
		this.company = new ArrayList<String>();
		this.cover = "";
		this.game_mode = new ArrayList<String>();
		this.genres = new ArrayList<String>();
		this.platforms = new ArrayList<String>();
		this.release_date = "";
		this.website = "";
		this.description = "";
	}
	
	public Videojuego(int id, String name, String category_rating, String age_rating_PEGI, String age_rating_ESRB, ArrayList<String> company, String cover,
			ArrayList<String> game_mode, String game_video, ArrayList<String> genres, ArrayList<String> platforms, String release_date, String website,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.category_rating = category_rating;
		this.age_rating_PEGI = age_rating_PEGI;
		this.age_rating_ESRB = age_rating_ESRB;
		this.company = company;
		this.cover = cover;
		this.game_mode = game_mode;
		this.genres = genres;
		this.platforms = platforms;
		this.release_date = release_date;
		this.website = website;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategory_rating() {
		return category_rating;
	}
	
	public void setCategory_rating(int category_rating) {
		switch(category_rating){
		case 0:
			this.category_rating = "Main Game"; //main_game
			break;
		case 1:
			this.category_rating = "DLC"; //dlc_addon
			break;
		case 2:
			this.category_rating = "Expansion"; //expansion
			break;
		case 3:
			this.category_rating = "Bundle"; //bundle
			break;
		case 4:
			this.category_rating = "Standalone Expansion"; //standalone_expansion
			break;
		case 5:
			this.category_rating = "Mod"; //mod
			break;
		case 6:
			this.category_rating = "Episode"; //episode
			break;
		case 7:
			this.category_rating = "Season"; //season
			break;
		case 8:
			this.category_rating = "Remake"; //remake
			break;
		case 9:
			this.category_rating = "Remaster"; //remaster
			break;
		case 10:
			this.category_rating = "Expanded Game"; //expanded_game
			break;
		case 11: 
			this.category_rating = "Port"; //port
			break;
		case 12:
			this.category_rating = "Fork"; //fork
			break;
		}
	}
	
	public String getAge_rating_PEGI() {
		return age_rating_PEGI;
	}
	
	public void setAge_rating_PEGI(int age_rating_PEGI) {
		this.age_rating_PEGI = this.age_rating_name(age_rating_PEGI);
	}
	
	public String getAge_rating_ESRB() {
		return age_rating_ESRB;
	}
	
	public void setAge_rating_ESRB(int age_rating_ESRB) {
		this.age_rating_ESRB = this.age_rating_name(age_rating_ESRB);
	}
	
	private String age_rating_name(int id){
		
		String name = "";
		
		switch(id){
		case 1:
			name = "Three";
			break;
		case 2:
			name = "Seven";
			break;
		case 3:
			name = "Twelve";
			break;
		case 4:
			name = "Sixteen";
			break;
		case 5:
			name = "Eighteen";
			break;
		case 6:
			name = "RP";
			break;
		case 7:
			name = "EC";
			break;
		case 8:
			name = "E";
			break;
		case 9:
			name = "E10";
			break;
		case 10:
			name = "T";
			break;
		case 11: 
			name = "M";
			break;
		case 12:
			name = "AO";
			break;
		case 13:
			name = "Not found";
			break;
		}
		return name;
	}
	
	public String getCompany() {
		
		StringBuilder companies = new StringBuilder();
		
		for(String aux : this.company) {
			companies.append(aux + " / ");
		}
		for(int i=0; i<3; i++) {
			companies.deleteCharAt(companies.length()-1);
		}
		
		return companies.toString();
	}
	
	public void setCompany(ArrayList<String> company) {
		this.company = company;
	}
	
	public String getCover() {
		return cover;
	}
	
	public void setCover(String cover) {
		this.cover = "https:" + cover.replace("t_thumb", "t_screenshot_big");
	}
	
	public String getGame_mode() {
		
		StringBuilder game_modes = new StringBuilder();
		
		for(String aux : this.game_mode) {
			game_modes.append(aux + " / ");
		}
		for(int i=0; i<3; i++) {
			game_modes.deleteCharAt(game_modes.length()-1);
		}
		
		return game_modes.toString();
	}
	
	public void setGame_mode(ArrayList<String> game_mode) {
		this.game_mode = game_mode;
	}
	
	public String getGenres() {
		
		StringBuilder generos = new StringBuilder();
		
		for(String aux : this.genres) {
			generos.append(aux + " / ");
		}
		for(int i=0; i<3; i++) {
			generos.deleteCharAt(generos.length()-1);
		}
		
		return generos.toString();
	}
	
	public void setGenres(ArrayList<String> genres) {
		this.genres = genres;
	}
	
	public String getPlatforms() {
		
		StringBuilder plataformas = new StringBuilder();
		
		for(String aux : this.platforms) {
			plataformas.append(aux + " / ");
		}
		for(int i=0; i<3; i++) {
			plataformas.deleteCharAt(plataformas.length()-1);
		}
		
		return plataformas.toString();
	}
	
	public void setPlatforms(ArrayList<String> platforms) {
		this.platforms = platforms;
	}
	
	public String getRelease_date() {
		return release_date;
	}
	
	public void setRelease_date(String release_date) {
		this.release_date = release_date.substring(0, 10);
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nVideojuego \nID= " + id + " \nName= " + name + " \nCategory= " + category_rating + " \nPEGI= "
				+ age_rating_PEGI + " \nESRB= " + age_rating_ESRB + " \nCompanies= " + this.getCompany() + " \nCover= " + cover 
				+ " \nGame Modes= " + this.getGame_mode() + " \nGenres= " + this.getGenres() + " \nPlatforms= " + this.getPlatforms() + " \nRelease Date= "
				+ release_date + " \nWebsite= " + website + " \nDescription= " + description;
	}

}
