
public class Video {
	private String name;
	private String type;
	private long duration;
	private long height;
	private long width;
	

	public Video(String name, String type, long duration, long height, long width) {
		super();
		this.name = name;
		this.type = type;
		this.duration = duration;
		this.height=height;
		this.width=width;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getHeight() {
		return height;
	}
	
	public void setHeight(long height) {
		this.height = height;
	}
	
	public long getWidth() {
		return width;
	}
	
	public void setWidth(long width) {
		this.width = width;
	}
}
