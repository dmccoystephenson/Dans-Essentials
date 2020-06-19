package essentialsystem.Commands;

import essentialsystem.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MOTDCommand {

    Main main = null;

    public MOTDCommand(Main plugin) {
        main = plugin;
    }

    public void showMOTD(CommandSender sender) {
        if (!(sender instanceof Player)) {
            // console can just view MOTD anytime
            sender.sendMessage(main.motd.getMessage());
        }
        else {
            // player needs permission
            Player player = (Player) sender;
            if (player.hasPermission("me.motd") || player.hasPermission("me.default")) {
                player.sendMessage(ChatColor.AQUA + main.motd.getMessage());
            }
            else {
                sender.sendMessage("Sorry! You need the 'me.motd' permission to use this command.");
            }
        }

    }
}