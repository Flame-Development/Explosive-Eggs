package ir.flamedevelopment;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
        if (!cmd.getName().equals("start")) {
            return true;
        }
        if (sender.hasPermission("exploeggs.admin")) {
            return true;
        }
        ExplosiveEggs.Listening = true;
        sender.sendMessage(ChatColor.GOLD + "Started Explosive Eggs.");
        return true;
    }
}
