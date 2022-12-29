package classes;

import java.util.Random;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = null;
	private static String weather[];

	private WeatherProvider()
	{
		weather = new String[4];
		weather[0] = "RAIN";
		weather[1] = "FOG";
		weather[2] = "SUN";
		weather[3] = "SNOW";
	}

	public static WeatherProvider getProvider()
	{
		if (weatherProvider == null)
			weatherProvider = new WeatherProvider();

		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int key;
		Random rand = new Random();

		key = (coordinates.getLatitude() + coordinates.getLongtitude() + coordinates.getHeight()) * rand.nextInt(50) % 4;
		return weather[key];
	}
}
