package me.therandomgamer.gangs.Command;

import me.therandomgamer.gangs.GPlayer;
import me.therandomgamer.gangs.Gang;
import me.therandomgamer.gangs.Main;
import me.therandomgamer.gangs.Relations.MemberRelations;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public class CmdRename implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {
        GPlayer gp = new GPlayer(p);
        Gang g = gp.getGang();
        String newName = args[1];

        if(gp.getMemberRelation() == MemberRelations.OWNER && newName.length() <= Main.getInstance().getConfig().getInt("configurations.namemaxlenght")){
            g.setName(newName);
        }else{
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"You can't do this");

        }

    }
}
