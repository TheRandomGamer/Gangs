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
public class CmdDescription implements GangCommand {

    @Override
    public void execute(Player p, String[] args) {

        boolean removeFirstBool = false;
        String description  = "";
        for (String s: args){
            if(removeFirstBool){
               description = description.concat(s+" ");
            }else{
                removeFirstBool = true;
            }
        }

        GPlayer gp = new GPlayer(p);
        if (description.length() <= Main.getInstance().getConfig().getInt("configurations.descriptionmaxlength" )&&( gp.getMemberRelation() == MemberRelations.MOD || gp.getMemberRelation() == MemberRelations.OWNER )){
            Gang g = new Gang(gp);
            g.setDescription(description);

        }else{
            p.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"This description is too long!");

        }
    }
}
