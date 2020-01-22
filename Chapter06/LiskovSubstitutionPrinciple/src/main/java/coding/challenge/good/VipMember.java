package coding.challenge.good;

public class VipMember extends Member {

    public VipMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("VIP member joins tournament ...");
    }

    @Override
    public void organizeTournament() {
        System.out.println("VIP member organize tournament ...");
    }
}
