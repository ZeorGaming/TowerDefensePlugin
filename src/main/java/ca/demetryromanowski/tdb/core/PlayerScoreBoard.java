package ca.demetryromanowski.tdb.core;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

@SuppressWarnings("deprecation")
public class PlayerScoreBoard {
    public PlayerScoreBoard(Player player, Server server){
        player.sendMessage("Create Scoreboard!");

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective objective = board.registerNewObjective("Turret", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("Turret");

        Score score = objective.getScore(player);
        score.setScore(10);

        player.setScoreboard(board);
    }
}
