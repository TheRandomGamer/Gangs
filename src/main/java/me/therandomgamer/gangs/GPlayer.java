package me.therandomgamer.gangs;

import me.therandomgamer.gangs.Relations.MemberRelations;
import org.bukkit.entity.Player;

/**
 * Created by robin on 22/05/17.
 */
public class GPlayer {

    Player p;

    public GPlayer(Player player){
        p = player;
    }

    public Gang getGang(){
        GangsYml gyml = GangsYml.getInstance();
        if (gyml.getGang(p) == null){
            return null;
        }
       return GangsYml.getInstance().getGang(p);
    }

    public MemberRelations getMemberRelation(){
       return  MemberRelations.getRelation(p);
    }



}
