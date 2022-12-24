package BasicsForHumans;

import BasicsForBuildings.Building;

public class Julio extends Human {
    public Julio(String name, Role role) {
        super(name, role);
    }

    public void explain(Building building) {
        System.out.println(super.getName() + " explains the story");
        RobberyManager event = new RobberyManager();
        event.preparation(building);
        event.shooting(event.getBandits(), event.getVictims());
        event.addTeam(event.getPolice(), building);
        event.shooting(event.getBandits(), event.getPolice());
        event.robberyEnd();
        System.out.println("That's what happened in the " + building.getName() + " that day.");

    }
}
