package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdInvite implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        Gang g = new Gang(new GPlayer(p));
        Player invited = Bukkit.getPlayer(args[1]);
        InvitesHandler.getInstance().addInvite(p,g);
        invited.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.GREEN+"You have been invited to join "+g.getName());
    }



}
