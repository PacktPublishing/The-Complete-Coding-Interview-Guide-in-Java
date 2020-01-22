package coding.challenge;

import coding.challenge.bad.Member;
import coding.challenge.good.TournamentJoiner;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nApproach that doesn't follow LSP:\n");

        List<Member> members1 = List.of(
                new coding.challenge.bad.PremiumMember("Jack Hores"),
                new coding.challenge.bad.VipMember("Tom Johns"),
                new coding.challenge.bad.FreeMember("Martin Vilop")
        );

        // this code respects LSP
        for (Member member : members1) {
            member.joinTournament();
        }
        
        System.out.println();
                
        // this code breaks LSP
        // a classic member cannot organize tournaments
        for (Member member : members1) {
            member.organizeTournament();
        }
        
        System.out.println("\nApproach that follow LSP:\n");

        List<TournamentJoiner> members2 = List.of(
                new coding.challenge.good.PremiumMember("Jack Hores"),
                new coding.challenge.good.VipMember("Tom Johns"),
                new coding.challenge.good.FreeMember("Martin Vilop")
        );               

        // this code respects LSP
        for (TournamentJoiner member : members2) {
            member.joinTournament();
        }                
    }
}
