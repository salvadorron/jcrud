package models;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */


public class MovieEntity {

	private String title;

	private String length;

	private String year;

	private String genre;

	public String getTitulo() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
