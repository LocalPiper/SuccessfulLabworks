package BasicsForHumans;

import BasicsForBuildings.Building;
import Interfaces.ArmedAndDangerous;
import Interfaces.HideAndSeek;
import Interfaces.MoveSomewhere;
import Interfaces.SellPapers;


public class OnDuty implements ArmedAndDangerous, HideAndSeek, SellPapers, MoveSomewhere {
    private Human human = new Human("PlaceHolder", Role.BANKER);

    public void setHuman(Human human) {
        this.human = human;
    }

    public Human getHuman() {
        return human;
    }

    public void shoot(Human victim) {
        if (human.getRole() == Role.POLICEMAN || human.getRole() == Role.BANDIT) {
            if (human.getState() != State.DEAD && victim.getState() != State.DEAD) {
                if (!victim.getHidden()) {
                    Weapons weapon = Weapons.values()[(int) (Math.random() * Weapons.values().length)];
                    if ((int) (Math.random() * 100) <= weapon.getKill_chance()) {
                        System.out.println(victim.getName() + " was killed by " + human.getName() + " with " + weapon);
                        victim.setState(State.DEAD);
                    } else if ((int) (Math.random() * 100) <= weapon.getHurt_chance()) {
                        System.out.println(victim.getName() + " was injured by " + human.getName() + " with " + weapon);
                        victim.setState(State.INJURED);
                    } else {
                        System.out.println("Somehow, " + victim.getName() + " survived the attack of " + human.getName());
                    }
                } else {
                    System.out.println(victim.getName() + " wasn't killed by " + human.getName() + " because " + victim.getName() + " chose a place to hide");
                }
            }
        }
    }

    public void transaction(Human customer) {
        if (human.getRole() == Role.AUCTIONEER && human.getState() != State.DEAD) {
            if (customer != null) {
                System.out.println("Transaction between " + human.getName() + " and " + customer.getName() + " went successfully");
            } else {
                System.out.println("There were no transactions: nobody came.");
            }
        }

    }

    public void hide(String place_to_hide) {
        if (human.getRole() == Role.CASHIER && human.getState() != State.DEAD) {
            System.out.println(human.getName() + " chose a place to hide: " + place_to_hide);
            human.setHidden(true);
        }
    }

    public void goTo(Building building) {
        if (human.getState() != State.DEAD) {
            human.getLocation().setX(building.getLocation().getX());
            human.getLocation().setY(building.getLocation().getY());
            human.getLocation().setZ(building.getLocation().getZ());
            System.out.println(human.getName() + " goes to " + building.getName());
        }

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
            OnDuty a = (OnDuty) obj;
            return human.getId() == a.human.getId();
        }
    }

    @Override
    public String toString() {
        return String.format("name: " + human.getName() + "\nid: " + human.getId() + "\nx: " + human.getLocation().getX() + "\ny: " + human.getLocation().getY() + "\nz: " + human.getLocation().getZ());
    }

    @Override
    public int hashCode() {
        return human.getId();
    }
}