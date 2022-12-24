package BasicsForBuildings;

import BasicsForHumans.Coordinates;

public abstract class Building {
    private final String name;
    private final int id;
    private Coordinates location;

    public Building(String name) {
        this.name = name;
        this.id = (int) (Math.random() * 1000 + 1000);
        this.location = new Coordinates();
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public Coordinates getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj.getClass() == this.getClass()) {
            return true;
        } else {
            Building a = (Building) obj;
            return a.id == this.id;
        }
    }

    @Override
    public String toString() {
        return String.format("name: " + this.getName() + "\nid: " + this.getId() + "\nx: " + this.getLocation().getX() + "\ny: " + this.getLocation().getY() + "\nz: " + this.getLocation().getZ());
    }

    @Override
    public int hashCode() {
        return this.id;
    }
}
