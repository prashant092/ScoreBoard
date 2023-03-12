import model.Game;
import exception.BusinessException;

import java.util.*;
import java.util.stream.Collectors;


public class FootBallScoreboard implements Scoreboard {

    private final List<Game> games;

    public FootBallScoreboard() {
        games = new ArrayList<>();
    }

    public Game startNewGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        games.add(game);
        return game;
    }

    public void updateScore(Game game, int homeScore, int awayScore) {
        if (Objects.isNull(game)) {
            throw new BusinessException("Please try with valid game data");
        }
        game.updateScore(homeScore, awayScore);
    }

    public void finishGame(Game game) {
        if (Objects.isNull(game)) {
            throw new BusinessException("Please try with valid game data");
        }
        game.finish();
        games.remove(game);
    }

    public List<Game> getGamesInProgress() {
        return games.stream()
                .filter(Game::isInProgress)
                .sorted(Comparator.comparing(Game::getTotalScore, Comparator.reverseOrder())
                        .thenComparing(Game::getStartTime, Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }
}
