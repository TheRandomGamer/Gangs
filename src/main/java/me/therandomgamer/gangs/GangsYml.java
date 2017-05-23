package me.therandomgamer.gangs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created by robin on 22/05/17.
 */
public class GangsYml {

    Main m;
    File file;
    FileConfiguration config;

    private GangsYml(){
        m = Main.getInstance();
    }

    private static class SingletonHelper{
        private static final GangsYml INSTANCE = new GangsYml();
    }

    public static GangsYml getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public void createFile(){

        file = new File(m.getDataFolder(),"gangs.yml");

        if (! file.exists()) {
            file.getParentFile().mkdirs();
            m.saveResource("gangs.yml", false);
        }
        config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String createGang(String s,Player p){
        if(config.getKeys(false).contains(s)){
            return ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"This gang already exists";
        }
        config.set(s+".owner",p.getUniqueId().toString());
        config.set(s+".description","Default description");
        config.set(s+".mods", Arrays.asList(p.getUniqueId().toString()));
        config.set(s+".members",Arrays.asList(p.getUniqueId().toString()));
        config.set(s+".allies",Arrays.asList());
        config.set(s+".truces",Arrays.asList());
        config.set(s+".enemies",Arrays.asList());

        return ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.GREEN+"You created the gang called "+s;

    }

    public Gang getGang(Player p) {
        for (String gangs : config.getKeys(false)) {
            for (String members : config.getStringList(gangs + ".members")) {
                if (p.getUniqueId().toString().equals(members)) {
                    return new Gang(gangs);
                }
            }
        }
        return null;
    }
    public Gang getGang(String s){
        for (String gangs: config.getKeys(false)){
            if(gangs.equals(s)){
                return new Gang(s);
            }
        }
        return null;
    }

    public List<Player> getMembers(Gang g){
        String name = g.getName();
        List<Player> playerList = config.getStringList(name + ".members").stream().map(uuid -> Bukkit.getPlayer(UUID.fromString(uuid))).collect(Collectors.toCollection(() -> new LinkedList<>()));
        return playerList;
    }

    public List<Player> getMods(Gang g){
        String name = g.getName();
        List<Player> playerList = config.getStringList(name + ".mods").stream().map(uuid -> Bukkit.getPlayer(UUID.fromString(uuid))).collect(Collectors.toCollection(() -> new LinkedList<>()));
        return playerList;
    }

    public Player getOwner(Gang g){
      return Bukkit.getPlayer(UUID.fromString(config.getString(g.getName()+".owner")));
    }

    public boolean addPlayerToGang(Player p, Gang g){
        List<String> currentMembers = config.getStringList(g.getName()+".members");
        if(currentMembers.size() < Main.getInstance().getConfig().getInt("configurations.maxsize")){
            currentMembers.add(p.getUniqueId().toString());
            return true;
        }
        return false;
    }

    public void setMods(Player[] p, Gang g){
        config.set(g.getName()+".mods",p);
        saveConfig();
    }

    public void setOwner(Player p, Gang g){
        config.set(g.getName()+".owner",p.getUniqueId().toString());
        saveConfig();
    }

    public void setDescription(String s, Gang g){
        config.set(g.getName()+".description",s);
        saveConfig();
    }

    public void setName(String s, Gang g){
        config.set(g.getName(),s);
        saveConfig();
    }

    private void saveConfig(){
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
