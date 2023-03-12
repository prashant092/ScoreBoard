package model;

import exception.BusinessException;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

@Getter
@Setter
public class Game {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private boolean inProgress;
    private LocalDateTime startTime;

    private static LocalDateTime lastStartTime = LocalDateTime.now();

    public Game(String homeTeam, String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new BusinessException("Home team and away team names must be non-null and non-empty.");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.inProgress = true;
        this.startTime = lastStartTime;
        lastStartTime= lastStartTime.plusSeconds(1);
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.startTime = lastStartTime;
        lastStartTime= lastStartTime.plusSeconds(1);
    }

    public void finish() {
        this.inProgress = false;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

}
