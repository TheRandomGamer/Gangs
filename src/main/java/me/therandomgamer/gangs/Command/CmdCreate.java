package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GangsYml;
import me.therandomgamer.gangs.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 22/05/17.
 */
public class CmdCreate implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        if(args[1].length() >= Main.getInstance().getConfig().getInt("configurations.namemaxlenght")){
        p.sendMessage(GangsYml.getInstance().createGang(args[1],p));
        }else {
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"This name is too long!");
        }
    }
}
