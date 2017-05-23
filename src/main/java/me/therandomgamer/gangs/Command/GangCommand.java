package me.therandomgamer.gangs.Command;

import org.bukkit.entity.Player;

/**
 * Created by robin on 22/05/17.
 */
public interface GangCommand {

    public abstract void execute(Player p, String[] args);

}
