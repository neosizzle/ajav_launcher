package classes;


public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longtitude, int latitude, int height)
	{
		// TODO check for error
		Coordinates coordinates = new Coordinates(latitude, longtitude, height);

		if (type.equals("Baloon"))
			return new Baloon(name, coordinates);
		else if (type.equals("Helicopter"))
			return new Helicopter(name, coordinates);
		else 
			return new Jetplane(name, coordinates);
	}
}
