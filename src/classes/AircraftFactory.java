package classes;


public class AircraftFactory {
	public Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) throws FtException
	{
		// check coords out of bounds
		if (longtitude < 0 || latitude < 0 || height < 0)
			throw new FtException("Coordinate violate lower bound");
		// apparently this is expected to pass
		// if (longtitude > 100 || latitude > 100 || height > 100)
		// 	throw new FtException("Coordinate violate upper bound");
		Coordinates coordinates = new Coordinates(latitude, longtitude, height);

		if (type.equals("Baloon"))
			return new Baloon(name, coordinates);
		else if (type.equals("Helicopter"))
			return new Helicopter(name, coordinates);
		else 
			return new Jetplane(name, coordinates);
	}
}
