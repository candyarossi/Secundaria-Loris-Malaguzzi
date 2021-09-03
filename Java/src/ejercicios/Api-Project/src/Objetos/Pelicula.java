package Objetos;

import java.util.ArrayList;


public class Pelicula {

	private int id;
	private String title;
	private String original_language;
	private String poster_path;
	private String release_date;
	private ArrayList<String> genres;
	private boolean adult;
	
	
	public Pelicula(int id, String title, String original_language, String poster_path, String release_date,
			ArrayList<String> genres, boolean adult) {
		super();
		this.id = id;
		this.title = title;
		this.original_language = original_language;
		this.poster_path = poster_path;
		this.release_date = release_date;
		this.genres = genres;
		this.adult = adult;
	}
	
	public Pelicula() {
		super();
		this.id = 0;
		this.title = "";
		this.original_language = "";
		this.poster_path = "";
		this.release_date = "";
		this.genres = new ArrayList<String>();
		this.adult = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		
		switch(original_language) {
			case "en":
				this.original_language = "Inglés";
				break;
			case "es":
				this.original_language = "Español";
				break;
			default:
				this.original_language = "Other";
				break;
		}
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = "https://image.tmdb.org/t/p/w500" + poster_path;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
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

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	@Override
	public String toString() {
		return "\nPelicula \nID= " + id + "\nTitle= " + title + "\nOriginal Language= " + original_language + "\nPoster Path= "
				+ poster_path + "\nRelease Date= " + release_date + "\nGenres= " + this.getGenres() + "\nAdult= " + adult;
	}
	
}
