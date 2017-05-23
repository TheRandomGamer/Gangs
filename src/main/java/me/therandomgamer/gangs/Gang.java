package me.therandomgamer.gangs;


import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by robin on 22/05/17.
 */
public class Gang {

    String n;

    public Gang(String name){
        n = name;
    }

    public Gang(GPlayer gPlayer){

      n = gPlayer.getGang().getName();
    }


    public String getName(){
        return n;
    }

    public boolean exists(){
        if(GangsYml.getInstance().getGang(n) == null){
            return false;
        }
        return true;
    }

    public boolean addPlayer(Player p){
       return GangsYml.getInstance().addPlayerToGang(p,this);
    }

    public List<Player> getMembers(){
        return GangsYml.getInstance().getMembers(this);
    }

    public List<Player> getMods(){
        return GangsYml.getInstance().getMods(this);
    }

    public Player getOwner(){
        return GangsYml.getInstance().getOwner(this);
    }

    public boolean addMod(Player p){
        if(new Gang(new GPlayer(p)) == this && this.getOwner() != p && ! this.getMods().contains(p)){
            GangsYml yml = GangsYml.getInstance();
            List<Player> currentMods = yml.getMods(this);
            currentMods.add(p);

            return true;
        }
        return false;
    }

    public void setOwner(Player p){
        GangsYml.getInstance().setOwner(p,this);
    }

    public void setDescription(String s){
        GangsYml.getInstance().setDescription(s,this);
    }

    public void setName(String s){
        GangsYml.getInstance().setName(s,this);
    }

}
