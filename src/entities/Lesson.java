package entities;

public class Lesson {
	private String title;
	
	public Lesson() {}

	public Lesson(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int duration() {
		return 0;
	}
	
	
}
