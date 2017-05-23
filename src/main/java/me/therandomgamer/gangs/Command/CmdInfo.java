package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 22/05/17.
 */
public class CmdInfo implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        Gang g;
        if(new Gang(args[1]).exists()){
            g = new Gang(args[1]);
        }else if(new Gang(new GPlayer(p)).exists()) {
            g = new Gang(new GPlayer(p));
        }else{
            g = null;
        }
        if(g == null){
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"This Gang doesn't exist");
        }else{


        }
    }
}
