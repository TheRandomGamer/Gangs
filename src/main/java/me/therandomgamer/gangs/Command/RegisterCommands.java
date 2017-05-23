package me.therandomgamer.gangs.Command;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by robin on 22/05/17.
 */
public class RegisterCommands implements CommandExecutor {

   static HashMap<List<String>, GangCommand> commands = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] strings) {

        if(strings.length > 0 && sender instanceof Player){
            Player player = (Player) sender;
            for (List<String> sList: commands.keySet()){

                for(String s: sList){
                    if(s.equalsIgnoreCase((strings[0]))){
                    GangCommand c = commands.get(s);
                    c.execute(player, strings);
                    }
                }
            }

        }else{
            sender.sendMessage(ChatColor.GOLD+""+ChatColor.BOLD+"[Gangs] "+ChatColor.RESET+ChatColor.RED+"Type /g help for more information");
        }
        return true;
    }

   public static void addCommands(){
       commands.put(Arrays.asList("create"),new CmdCreate());
       commands.put(Arrays.asList("info","i"),new CmdCreate());
       commands.put(Arrays.asList("inv","invite"),new CmdInvite());
       commands.put(Arrays.asList("accept","join"),new CmdAccept());
       commands.put(Arrays.asList("decline"),new CmdDecline());
       commands.put(Arrays.asList("mod"),new CmdMod());
       commands.put(Arrays.asList("owner"),new CmdOwner());
       commands.put(Arrays.asList("description","desc"),new CmdDescription());
       commands.put(Arrays.asList("rename"),new CmdRename());


   }



}
