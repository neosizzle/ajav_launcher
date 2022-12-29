package classes;

public class Baloon extends Aircraft implements Flyable{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	@Override
	public void registerTower(WeatherTower _weatherTower) {
		String prefix = "Baloon#" + this.name + "(" + this.id + "): ";
		_weatherTower.register(this);
		this.weatherTower = _weatherTower;
		System.out.println("Tower registered: " + prefix);
	}

	@Override
	public void updateConditions() {
		String currentWeather = this.weatherTower.getWeather(this.coordinates);
		String prefix = "Baloon#" + this.name + "(" + this.id + "): ";
		int newHeight = this.coordinates.getHeight();
		int newLat = this.coordinates.getLatitude();
		int newLong = this.coordinates.getLongtitude();

		if (currentWeather == "SUN")
		{
			newLong += 2;
			newHeight += 4;
			System.out.println(prefix + "kemarau");
		}
		else if (currentWeather == "RAIN")
		{
			newHeight -= 5;
			System.out.println(prefix + "banjir");
		}
		else if (currentWeather == "FOG")
		{
			newHeight -= 3;
			System.out.println(prefix + "jerebu");
		}
		else if (currentWeather == "SNOW")
		{
			newHeight -= 15;
			System.out.println(prefix + "早上好中国我现在有❄️BING CHILLING❄️");
		}
		
		if(newHeight > 100) newHeight = 100;
		if(newHeight < 0)
		{
			newHeight = 0;
			System.out.println(prefix + "is landing..");
			this.weatherTower.unregister(this);
			System.out.println("Tower unregistered: " + prefix);
		}
		this.coordinates = new Coordinates(newLat, newLong, newHeight);
	}
}
