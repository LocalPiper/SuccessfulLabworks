import BasicsForBuildings.Auction;
import BasicsForBuildings.Bank;
import BasicsForHumans.Human;
import BasicsForHumans.Julio;
import BasicsForHumans.OnDuty;
import BasicsForHumans.Role;

public class Main {
    public static void main(String[] args) {
        Auction auction = new Auction("Auction");
        Human neznayka = new Human("Neznayka", Role.AUCTIONEER);
        Human miga = new Human("Miga", Role.AUCTIONEER);
        Human kozlik = new Human("Kozlik", Role.AUCTIONEER);
        OnDuty connector = new OnDuty();
        connector.setHuman(neznayka);
        connector.transaction(null);
        Julio julio = new Julio("Julio", Role.AUCTIONEER);
        connector.setHuman(julio);
        connector.goTo(auction);
        julio.explain(new Bank("Bank"));

    }
}