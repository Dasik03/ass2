interface PlayerStatistics {
    void display();
}

class BasicPlayerStatistics implements PlayerStatistics {
    private String playerName;
    private int goalsScored;

    public BasicPlayerStatistics(String playerName, int goalsScored) {
        this.playerName = playerName;
        this.goalsScored = goalsScored;
    }

    public void display() {
        System.out.println("Player: " + playerName);
        System.out.println("Goals Scored: " + goalsScored);
    }
}
abstract class PlayerStatisticsDecorator implements PlayerStatistics {
    protected PlayerStatistics decoratedPlayerStats;

    public PlayerStatisticsDecorator(PlayerStatistics decoratedPlayerStats) {
        this.decoratedPlayerStats = decoratedPlayerStats;
    }

    public void display() {
        decoratedPlayerStats.display();
    }
}

class YellowCardDecorator extends PlayerStatisticsDecorator {
    private int yellowCards;

    public YellowCardDecorator(PlayerStatistics decoratedPlayerStats, int yellowCards) {
        super(decoratedPlayerStats);
        this.yellowCards = yellowCards;
    }

    public void display() {
        super.display();
        System.out.println("Yellow Cards: " + yellowCards);
    }
}
class RedCardDecorator extends PlayerStatisticsDecorator {
    private int redCards;

    public RedCardDecorator(PlayerStatistics decoratedPlayerStats, int redCards) {
        super(decoratedPlayerStats);
        this.redCards = redCards;
    }

    public void display() {
        super.display();
        System.out.println("Red Cards: " + redCards);
    }
}

public class Main {
    public static void main(String[] args) {
        PlayerStatistics player1 = new BasicPlayerStatistics("Medeu Baktybayev", 10);
        System.out.println("Basic Player Statistics:");
        player1.display();

        PlayerStatistics player2 = new YellowCardDecorator(player1, 2);
        System.out.println("\nPlayer Statistics with Yellow Cards:");
        player2.display();

        PlayerStatistics player3 = new RedCardDecorator(player2, 1);
        System.out.println("\nPlayer Statistics with Yellow and Red Cards:");
        player3.display();
    }
}
