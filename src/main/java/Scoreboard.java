import Model.Game;

import java.util.List;
import java.util.Optional;

public interface Scoreboard {

     Game startNewGame(String homeTeam, String awayTeam);

     void updateScore(Game game, int homeScore, int awayScore);

     void finishGame(Game game);

     List<Game> getGamesInProgress();

}
