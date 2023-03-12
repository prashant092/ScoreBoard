import model.Game;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        final String team1= "Home";
        final String team2="Away";
        final String team3= "Home";
        final String team4="Away";
        final int game1Team1Score=1;
        final int game1Team2Score=0;
        // create a new FootBallScoreboard instance
        Scoreboard scoreboard = new FootBallScoreboard();

        // start a new game
        Game game1 = scoreboard.startNewGame(team1, team2);

        // start a new game
        Game game2 = scoreboard.startNewGame(team3, team4);

        // update the score of the first game
        scoreboard.updateScore(game1, game1Team1Score, game1Team2Score);

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
