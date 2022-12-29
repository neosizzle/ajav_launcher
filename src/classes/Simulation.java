package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Simulation {
	private int timesRun;
	private WeatherTower weatherTower;
	private AircraftFactory aircraftFactory;

	public Simulation()
	{
		this.timesRun = 0;
		this.weatherTower = new WeatherTower();
		this.aircraftFactory = new AircraftFactory();
	}

	public void runSimulations() {
		for (int i = 0; i < this.timesRun; i++) {
			weatherTower.changeWeather();
		}
	}

	public void configureFromfile(String path) throws FtException {

		// open file
		File file = new File(path);
	
		try {
			// read file line by line
			BufferedReader br  = new BufferedReader(new FileReader(file));
			String line;

			// read first line
			line = br.readLine();
			if (line == null)
			{
				br.close();
				throw new FtException("Scenario file empty");
			}
			// get timesRun
			this.timesRun = Integer.parseInt(line);

			// read rest of the lines
			while ((line = br.readLine()) != null)
			{
				String[] tokens = line.split(" ");
				String[] validTypes = {"Baloon", "Helicopter", "JetPlane"};

				// check if token is corrent format
				if (tokens.length != 5) {
					br.close();
					throw new FtException("Token formart incorect");
				}

				// validate type correctness
				if (!Arrays.asList(validTypes).contains(tokens[0]))
				{
					br.close();
					throw new FtException("Invalid aircraft type");
				}

				// create aircraft and register
				Flyable flyable = this.aircraftFactory.newAircraft(
					tokens[0],
					tokens[1],
					Integer.parseInt(tokens[2]),
					Integer.parseInt(tokens[3]),
					Integer.parseInt(tokens[4])
					);
				flyable.registerTower(this.weatherTower);
			}

			br.close();
		} catch (FileNotFoundException e) {
			throw new FtException("Scenario File is missing");
		}
		catch (IOException e) {
			throw new FtException("Cannot read scenario file");
		}
		catch (FtException e)
		{
			throw new FtException(e.getMessage());
		}
	}

}
