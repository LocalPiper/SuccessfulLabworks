package BasicsForHumans;

public class Day {
    private int day_count;

    public Day() {
        this.day_count = 0;
    }

    public void startNewDay() {
        ++this.day_count;
        System.out.println("Day " + this.day_count + " started!");
    }
}
