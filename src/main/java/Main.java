import Model.Game;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // create a new FootBallScoreboard instance
        Scoreboard scoreboard = new FootBallScoreboard();

        // start a new game
        Game game1 = scoreboard.startNewGame("Home", "Away");

        // start a new game
        Game game2 = scoreboard.startNewGame("Home1", "Away1");

        // update the score of the first game
        scoreboard.updateScore(game1, 1, 0);

        // finish the second game
        scoreboard.finishGame(game2);

        // get all the games in progress
        List<Game> gamesInProgress = scoreboard.getGamesInProgress();

        // print the games in progress
        System.out.println("Games in progress:");
        for (Game game : gamesInProgress) {
            System.out.println(game.getHomeTeam() + " vs " + game.getAwayTeam() +
                    " (score: " + game.getHomeScore() + "-" + game.getAwayScore() + ")");
        }
    }
}
