package BasicsForHumans;

public class Quarrel {
    private Human side1;
    private Human side2;

    public Quarrel(Human side1, Human side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public void quarrelStart() {
        System.out.println(this.side1.getName() + " and " + this.side2.getName() + " started arguing!");
    }

    public void stateOpinion(String argument1, String argument2) {
        System.out.println(this.side1.getName() + " stated that he was the " + argument1 + ", therefore, " + this.side2.getName() + " must respect his opinion");
        System.out.println("On the other hand, " + this.side2.getName() + " stated that he was the " + argument2 + ", therefore, " + this.side1.getName() + " should back down");
    }

    public void pacifyAttempt(Human pacifier) {
        System.out.println(pacifier.getName() + " tried to calm down " + this.side1.getName() + " and " + this.side2.getName() + ", but failed");
    }

    public void quarrelEnd(Human ender) {
        System.out.println("Finally, " + ender.getName() + " stepped into the quarrel and ended it. " + this.side1.getName() + " and " + this.side2.getName() + " stopped arguing");
    }
}
