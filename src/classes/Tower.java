package classes;

import java.util.ArrayList;
import java.util.Iterator;

public class Tower {
	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		if (this.observers.contains(flyable)) return ;
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		// Iterator<Flyable> iter = this.observers.iterator();

		// while (iter.hasNext()) {
		// 	Flyable item = iter.next();

		// 	if (item == flyable)
		// 		iter.remove();
		// }
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
