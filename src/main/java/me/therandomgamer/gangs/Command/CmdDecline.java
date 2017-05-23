package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.Gang;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdDecline implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        InvitesHandler invitesHandler = InvitesHandler.getInstance();
        Gang g = new Gang(args[1]);

        if(invitesHandler.hasInvite(p,g)){
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Gangs] " + ChatColor.RESET + ChatColor.GREEN + "You have declined the invite from "+g.getName());
            for(Player members: g.getMembers()){
                members.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Gangs] " + ChatColor.RESET + ChatColor.RED +p.getName()+" has declined your invitation");
            }

        }else{
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Gangs] " + ChatColor.RESET + ChatColor.RED + "You don't have an invite for this gang");
        }

    }
}
