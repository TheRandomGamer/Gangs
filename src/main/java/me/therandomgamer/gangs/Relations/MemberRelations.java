package me.therandomgamer.gangs.Relations;

import me.therandomgamer.gangs.Gang;
import me.therandomgamer.gangs.GangsYml;
import org.bukkit.entity.Player;

/**
 * Created by robin on 23/05/17.
 */
public enum MemberRelations {

    NOGANG,MEMBER,MOD,OWNER;

    public static MemberRelations getRelation(Player p){
        GangsYml yml = GangsYml.getInstance();

        Gang g = yml.getGang(p);
        if(g == null){
            return MemberRelations.NOGANG;
        }else if(yml.getOwner(g) == p){
            return MemberRelations.OWNER;
        }else if(yml.getMods(g).contains(p)){
            return MemberRelations.MOD;
        }else{
            return MemberRelations.MEMBER;
        }
    }

}
