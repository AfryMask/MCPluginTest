package top.afrymask.spigotplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

/**
 * Handler for the /debug sample command.
 * @author SpaceManiac
 */
public class SampleDebugCommand implements CommandExecutor {
    private final SamplePlugin plugin;

    public SampleDebugCommand(SamplePlugin plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] split) {

        Player player = (Player) sender;
        if (!player.hasPermission("afrymask.debug")){
            player.sendMessage("You have no permission!");
            return false;
        }


        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec("touch plugins/BetonQuest/bibibi9.afrymask");
        } catch (IOException ex) {

        }

//        if (sender instanceof Player) {
//            Player player = (Player) sender;
//            player.setAllowFlight(!plugin.isDebugging(player));
//            plugin.setDebugging(player, !plugin.isDebugging(player));
            return true;
//        } else {
//            return false;
//        }
    }
}
