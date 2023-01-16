import BasicsForBuildings.Auction;
import BasicsForBuildings.Bank;
import BasicsForHumans.*;
import Exceptions.EmptyRobberyException;
import Exceptions.NamelessObjectException;
import Tools.Newspaper;

public class Main {
    public static void main(String[] args) throws EmptyRobberyException, NamelessObjectException {

        Day day = new Day();
        Auction auction = new Auction("Auction");
        Human neznayka = new Human("Neznayka", Role.AUCTIONEER);
        Human miga = new Human("Miga", Role.AUCTIONEER);
        Human kozlik = new Human("Kozlik", Role.AUCTIONEER);
        Julio julio = new Julio("Julio", Role.AUCTIONEER);
        Quarrel quarrel = new Quarrel(julio, miga);
        Newspaper news = new Newspaper();

        day.startNewDay();
        quarrel.quarrelStart();
        quarrel.stateOpinion("Chairman", "Treasurer");
        quarrel.pacifyAttempt(neznayka);
        quarrel.quarrelEnd(kozlik);

        day.startNewDay();
        OnDuty connector = new OnDuty();
        connector.setHuman(neznayka);
        connector.sellTo(null);
        connector.setHuman(julio);
        connector.goTo(auction);
        julio.explain(new Bank("Bank"));
        connector.setHuman(miga);
        connector.sellTo(null);

        day.startNewDay();
        news.explain(new Bank("Bank"));
    }
}