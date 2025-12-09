import java.util.Scanner;

public class HockeyStatsApp {
    //main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Loughborough stats:");
        TeamStats lboro = new TeamStats(
                input(sc, "Shots"),
                input(sc, "Goals from Open Play"),
                input(sc, "Circle possessions"),
                input(sc, "25 entries"),
                input(sc, "Penalty corners won"),
                input(sc, "Penalty corner goals"),
                input(sc, "Aerial retained"),
                input(sc, "Aerial lost"),
                input(sc, "Floor retained"),
                input(sc, "Floor lost")
        );

        System.out.println("\nEnter Opponent stats:");
        TeamStats opp = new TeamStats(
                input(sc, "Shots"),
                input(sc, "Goals from Open Play"),
                input(sc, "Circle possessions"),
                input(sc, "25 entries"),
                input(sc, "Penalty corners won"),
                input(sc, "Penalty corner goals"),
                0, 0, 0, 0 //cant be bothered to count stats
        );

        MatchAnalysis analysis = new MatchAnalysis(lboro, opp);
        analysis.printReport();

        sc.close();
    }

    //gets inputs
    private static int input(Scanner sc, String label) {
        System.out.print(label + ": ");
        return sc.nextInt();
    }
}
