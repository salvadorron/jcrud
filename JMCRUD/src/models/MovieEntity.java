package models;

/**
 * 
 * @author Salvador de J. Ron Osio
 *
 */


public class MovieEntity {

	private String title;

	private String duration;

	private String year;

	private String gender;

	public String getTitulo() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
