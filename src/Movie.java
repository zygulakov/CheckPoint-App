import java.io.Serializable;

public class Movie implements Serializable,Savable{
	private final String fileName ; 
	private int season ;
	private int episode;
	private int minute;
	private String name;
	public Movie(String name) {
		this.name = name;
		fileName = name + (int)(Math.random() * 100); // name and random num for saving object as file
	}
	
	public String getFileName() {
		return fileName;
	}
	public int getSeason() {
		return season;
	}
	//throws IllegalArgumentException if smaller than 0
	public void setSeason(int season) {
		if(season>0) {			
		this.season = season;
		}else 
			new IllegalArgumentException("season 0?");
		
	}
	public int getEpisode() {
		return episode;
	}
	//throws IllegalArgumentException if smaller than 0
	public void setEpisode(int episode) {
		if(episode>0) {
			this.episode = episode;			
		}else
			 new IllegalArgumentException("episode 0?");
	}
	public int getMinute() {
		return minute;
	}
	//throws IllegalArgumentException if smaller than 0
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getName() {
		return name;
	}
	//throws IllegalArgumentException if no name
	public void setName(String name) {
		if(!name.isBlank() && !name.isEmpty()) {
			this.name = name;			
		}else
			new IllegalArgumentException("movie name is no name?");
	}
	
	
}
