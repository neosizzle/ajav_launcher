import classes.Simulation;

/**
 * main
 */
public class avaj_launcher {
	public static void main(String[] args) {
        if (args.length != 1)
        {
            System.out.println("Usage: java avaj_launcher [scenario file]");
            return ;
        }

        try {
            Simulation sim = new Simulation();

            sim.configureFromfile(args[0]);
            sim.runSimulations();
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            e.printStackTrace();
        }
        System.out.println("end");
    }
}