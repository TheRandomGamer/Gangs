package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdMod implements GangCommand{

    @Override
    public void execute(Player p, String[] args) {

        GPlayer gp = new GPlayer(p);
        Gang g = new Gang(gp);
        if(g.getOwner() == p){
            if(g.addMod(p)){
                p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.GREEN+p.getName()+" Has been modded!");
            }else{
                p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"You can't mod this player");

            }
        }else{
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"You don't have the permission to do this!");
        }
    }
}
