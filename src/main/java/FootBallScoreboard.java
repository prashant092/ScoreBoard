import Model.Game;
import exception.BusinessException;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class FootBallScoreboard implements Scoreboard {

    private final PriorityQueue<Game> games;

    public FootBallScoreboard() {
        games = new PriorityQueue<>(
                Comparator.comparing(Game::getTotalScore).reversed()
                        .thenComparing(Game::getStartTime).reversed());
    }

    @Override
    public Game startNewGame(String homeTeam, String awayTeam) {
        Game game = new Game(homeTeam, awayTeam);
        this.games.add(game);
        return game;
    }

    @Override
    public void updateScore(Game game, int homeScore, int awayScore) {
        if (Objects.isNull(game)) {
            throw new BusinessException("Please try with valid game data");
        }
        game.updateScore(homeScore, awayScore);
    }

    @Override
    public void finishGame(Game game) {
        if (Objects.isNull(game)) {
            throw new BusinessException("Please try with valid game data");
        }
        game.finish();
        this.games.remove(game);
    }

    @Override
    public List<Game> getGamesInProgress() {
        return games.stream()
                .filter(Game::isInProgress)
                .collect(Collectors.toList());
    }
}
