import model.Game;
import exception.BusinessException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class FootBallScoreboardTest {
    private FootBallScoreboard scoreboard;

    @Before
    public void setUp() {
        scoreboard = new FootBallScoreboard();
    }

    @Test
    public void testStartNewGame() {
        Game game = scoreboard.startNewGame("Home", "Away");
        assertNotNull(game);
        assertEquals("Home", game.getHomeTeam());
        assertEquals("Away", game.getAwayTeam());
    }

    @Test
    public void testUpdateScoreWithValidGame() {
        Game game = scoreboard.startNewGame("Home", "Away");
        scoreboard.updateScore(game, 1, 0);
        assertEquals(1, game.getHomeScore());
        assertEquals(0, game.getAwayScore());
    }

    @Test
    public void testUpdateScoreWithInvalidGame() {
        assertThrows(BusinessException.class, () -> scoreboard.updateScore(null, 1, 0));
    }

    @Test
    public void testFinishGameWithValidGame() {
        Game game = scoreboard.startNewGame("Home", "Away");
        scoreboard.finishGame(game);
        assertFalse(game.isInProgress());
    }

    @Test
    public void testFinishGameWithInvalidGame() {
        assertThrows(BusinessException.class, () -> scoreboard.finishGame(null));
    }

    @Test
    public void testGetGamesInProgressWithNoGames() {
        List<Game> gamesInProgress = scoreboard.getGamesInProgress();
        assertTrue(gamesInProgress.isEmpty());
    }

    @Test
    public void testGetGamesInProgressWithFinishedGames() {
        Game game1 = scoreboard.startNewGame("Home1", "Away1");
        scoreboard.finishGame(game1);

        Game game2 = scoreboard.startNewGame("Home2", "Away2");
        scoreboard.updateScore(game2, 1, 0);
        scoreboard.updateScore(game2, 2, 0);
        scoreboard.finishGame(game2);

        List<Game> gamesInProgress = scoreboard.getGamesInProgress();
        assertTrue(gamesInProgress.isEmpty());
    }

    @Test
    public void testGetGamesInProgressWithOneInProgressGame() {
        Game game = scoreboard.startNewGame("Home", "Away");
        scoreboard.updateScore(game, 1, 0);

        List<Game> gamesInProgress = scoreboard.getGamesInProgress();
        assertEquals(1, gamesInProgress.size());
        assertTrue(gamesInProgress.contains(game));
    }

    @Test
    public void testGetGamesInProgressWithMultipleInProgressGames() {
        Game game1 = scoreboard.startNewGame("Mexico", "Canada");
        scoreboard.updateScore(game1, 0, 5);

        Game game2 = scoreboard.startNewGame("Spain", "Brazil");
        scoreboard.updateScore(game2, 10, 2);

        Game game3 = scoreboard.startNewGame("Germany", "France");
        scoreboard.updateScore(game3, 2, 2);

        Game game4 = scoreboard.startNewGame("Uruguay", "Italy");
        scoreboard.updateScore(game4, 6, 6);

        Game game5 = scoreboard.startNewGame("Argentina", "Australia");
        scoreboard.updateScore(game5, 3, 1);

        List<Game> gamesInProgress = scoreboard.getGamesInProgress();
        assertEquals(5, gamesInProgress.size());
        assertEquals(game4, gamesInProgress.get(0));
        assertEquals(game2, gamesInProgress.get(1));
        assertEquals(game1, gamesInProgress.get(2));
        assertEquals(game5, gamesInProgress.get(3));
        assertEquals(game3, gamesInProgress.get(4));
    }
}
