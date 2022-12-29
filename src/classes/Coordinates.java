package classes;

public class Coordinates {
	private int latitude;
	private int longtitude;
	private int height;

	public int getHeight() {
		return height;
	}

	public int getLatitude() {
		return latitude;
	}
	public int getLongtitude() {
		return longtitude;
	}

	Coordinates(int latitude, int longtitude, int height)
	{
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.height = height;
	}

	Coordinates()
	{
		this.latitude = 0;
		this.longtitude = 0;
		this.height = 0;
	}
}
