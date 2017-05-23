package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdAccept implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        InvitesHandler invitesHandler = InvitesHandler.getInstance();
        Gang g = new Gang(args[1]);
        if(invitesHandler.hasInvite(p,g) &&( new GPlayer(p)).getGang() == null){
            invitesHandler.removeInvite(p,g);
            if(g.addPlayer(p)){
                p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.GREEN+"You have joined "+g.getName());

            }else {
                p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"This gang is full");

            }
        }else {
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "[Gangs] " + ChatColor.RESET + ChatColor.RED + "You can't join this faction");

        }
    }
}
