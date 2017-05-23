package me.therandomgamer.gangs;

import me.therandomgamer.gangs.Command.RegisterCommands;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;


/**
 * Created by robin on 21/05/17.
 */
public class Main extends JavaPlugin {

    private static Main m;


    @Override
    public void onEnable() {
        super.onEnable();
        m = this;
        saveDefaultConfig();

        //Creates the gangs.yml file
        GangsYml.getInstance().createFile();

        //Registers commands
        this.getCommand("gang").setExecutor(new  RegisterCommands());
        RegisterCommands.addCommands();


        this.getLogger().info("Gangs by TheRandomGamer has been enabled");
    }

    public static Main getInstance(){
        return m;
    }


}
