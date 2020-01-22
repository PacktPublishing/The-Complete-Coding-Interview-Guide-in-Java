package coding.challenge.bad;

public class FreeMember extends Member {

    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Classic member joins tournament ...");
    }

    // this method breaks Liskov’s Substitution Principle
    // since a classic member cannot organize tournamens it cannot be
    // a substitute for the base class
    @Override
    public void organizeTournament() {
        System.out.println("A classic member cannot organize tournaments");
    }
}
