import java.util.*;

public class Day053 {

    public static void main(String[] args) {
        TournamentManager manager = new TournamentManager();
        manager.run();
    }
}

class Team {
    private String name;
    private int wins;
    private int losses;
    private int draws;

    public Team(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public void recordWin() {
        wins++;
    }

    public void recordLoss() {
        losses++;
    }

    public void recordDraw() {
        draws++;
    }

    public int getPoints() {
        return wins * 3 + draws; 
    }

    @Override
    public String toString() {
        return name + ": " + wins + " wins, " + losses + " losses, " + draws + " draws, " + getPoints() + " points";
    }
}

class TournamentManager {
    private Map<String, Team> teams;
    private Scanner scanner;

    public TournamentManager() {
        teams = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("1. Register Team");
            System.out.println("2. Record Match Result");
            System.out.println("3. Show Team Statistics");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerTeam();
                    break;
                case 2:
                    recordMatchResult();
                    break;
                case 3:
                    showTeamStatistics();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerTeam() {
        System.out.print("Enter team name: ");
        String name = scanner.nextLine();
        if (teams.containsKey(name)) {
            System.out.println("Team already registered.");
        } else {
            teams.put(name, new Team(name));
            System.out.println("Team " + name + " registered successfully.");
        }
    }

    private void recordMatchResult() {
        System.out.print("Enter first team name: ");
        String team1 = scanner.nextLine();
        System.out.print("Enter second team name: ");
        String team2 = scanner.nextLine();

        if (!teams.containsKey(team1) || !teams.containsKey(team2)) {
            System.out.println("One or both teams not registered.");
            return;
        }

        System.out.print("Enter result (1: " + team1 + " wins, 2: " + team2 + " wins, 3: Draw): ");
        int result = scanner.nextInt();
        scanner.nextLine(); 

        switch (result) {
            case 1:
                teams.get(team1).recordWin();
                teams.get(team2).recordLoss();
                break;
            case 2:
                teams.get(team2).recordWin();
                teams.get(team1).recordLoss();
                break;
            case 3:
                teams.get(team1).recordDraw();
                teams.get(team2).recordDraw();
                break;
            default:
                System.out.println("Invalid result.");
        }

        System.out.println("Match result recorded.");
    }

    private void showTeamStatistics() {
        for (Team team : teams.values()) {
            System.out.println(team);
        }
    }
}
