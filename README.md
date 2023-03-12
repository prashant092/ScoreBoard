ScoreBoard Application

This is a ScoreBoard application built with Java 
that allows users to start, update, finish, and get in-progress games.
For Dependency management we are using maven, so for running all the testcases please use mvn clean install .
from your IDE.

Usage
To use the ScoreBoard application, simply create an instance of the FootBallScoreboard class and call its methods. Here's an example:

public class Application {

    public static void main(String[] args) {
        Scoreboard scoreboard = new FootBallScoreboard();
        Game game1 = scoreboard.startNewGame("Home", "Away1");
        Game game2 = scoreboard.startNewGame("Home1", "Away2");
        scoreboard.updateScore(game1, 2, 1);
        scoreboard.finishGame(game2);
        List<Game> gamesInProgress = scoreboard.getGamesInProgress();
        System.out.println("Games in progress: " + gamesInProgress);
    }

}

For future Extension : In the current scenario we have Scoreboard interface and Implemented only for FootballScoreboard.
In future if we want to extend for Other ScoreBoards in future we can do that by implementing this Interface. 
Common methods can come in our Interface and concert can be in the implemented class.

Note: 
This application was built using TDD approach and the code has been written
with the assumption that it will be consumed by other applications, 
hence a dummy main method has been added just to showcase the usage of the application.