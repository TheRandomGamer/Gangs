package me.therandomgamer.gangs.Command;


import me.therandomgamer.gangs.Gang;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by robin on 23/05/17.
 */
public class InvitesHandler {

    private static HashMap<Player,List<Gang>> gangInvites;


    private InvitesHandler(){
        gangInvites = new HashMap<>();
    }

    private static class SingletonHelper{
        private static final InvitesHandler INSTANCE = new InvitesHandler();
    }

    public static InvitesHandler getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public  void addInvite(Player p, Gang g){
        if(gangInvites.containsKey(p)){
            List<Gang> gangs = gangInvites.get(p);
            gangs.add(g);
            gangInvites.remove(p);
            gangInvites.put(p,gangs);
        }else{
            gangInvites.put(p, Arrays.asList(g));
        }
    }

    public  void removeInvite(Player p, Gang g){
        if(gangInvites.get(p).size() <= 1){
            gangInvites.remove(p);
        }else{
            List<Gang> gangs = gangInvites.get(p);
            gangs.remove(g);
            gangInvites.remove(p);
            gangInvites.put(p,gangs);
        }
    }

    public List<Gang> getGangFromInvite(Player p){
        return gangInvites.get(p);
    }

    public  boolean hasInvite(Player p, Gang g){
        return gangInvites.get(p).contains(g);
    }



}
