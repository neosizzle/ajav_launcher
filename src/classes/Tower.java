package classes;

import java.util.ArrayList;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (this.observers.contains(flyable)) return ;
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}

	protected void conditionsChanged() {
		// iterate through observers and call updateConditions()

		// foreach causes concurrent modification exception
		// for (Flyable flyable : this.observers) {
		// 	flyable.updateConditions();
		// }
		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.get(i).updateConditions();
		}
	}

}
