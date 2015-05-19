package me.Cooltimmetje.CoolJump;

import me.Cooltimmetje.CoolJump.Utilities.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * This class has been created on 19-5-2015 at 19:28 by cooltimmetje.
 */
public class ReloadCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (cmd.getLabel().equalsIgnoreCase("cooljump")) {
            if(p.isOp()){
                Listeners.upwardForce = Main.getPlugin().getConfig().getDouble("UpwardForce");
                Listeners.forwardForce = Main.getPlugin().getConfig().getDouble("ForwardForce");
                ChatUtils.msgPlayerTag(p, "CoolJump", "Config reloaded!");
            } else {
                ChatUtils.msgPlayerTag(p, "CoolJump", ChatUtils.error + "You can't do that!");
            }
        }
        return true;
    }
}
