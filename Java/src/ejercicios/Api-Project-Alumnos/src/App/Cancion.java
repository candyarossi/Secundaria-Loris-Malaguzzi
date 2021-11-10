package App;
import java.net.MalformedURLException;
import java.net.URL;


public class Cancion {
	
	private int id;
	private String title;
	private String link;
	private int duration;
	private String release_date;
	private URL preview;
	private String artist;
	private String album;
	
	
	public Cancion() {
		super();
		this.id = 0;
		this.title = "";
		this.link = "";
		this.duration = 0;
		this.release_date = "";
		try {
			this.preview = new URL("https://www.deezer.com/mx/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		this.artist = "";
		this.album = "";
	}
	
	public Cancion(int id, String title, String link, int duration, String release_date, URL preview, String artist, String album) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.release_date = release_date;
		this.preview = preview;
		this.artist = artist;
		this.album = album;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public URL getPreview() {
		return preview;
	}

	public void setPreview(URL preview) {
		this.preview = preview;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	@Override
	public String toString() {
		return "\nCancion \nID= " + id + "\nTitle= " + title + "\nLink= " + link + "\nDuration= " + duration
				+ "\nRelease Date= " + release_date + "\nPreview= " + preview + "\nArtist= " + artist + "\nAlbum= " + album;
	}
	
}
