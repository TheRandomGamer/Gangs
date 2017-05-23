package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdOwner implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        Gang g = (new GPlayer(p)).getGang();
        Player newOwner = Bukkit.getPlayer(args[1]);
        if(g != null && g.getOwner() == p && g.getMembers().contains(newOwner)){
            g.setOwner(newOwner);

        }else{
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"You don't have the permission to do this!");

        }

    }
}
