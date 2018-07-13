package com.github.fernthedev.RankColor.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandMain implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 0) {
            String method = args[0];

            switch (method.toLowerCase()) {
                case "reload":
                    new reload();
                    reload.getInstance().onCommand(sender,command,label,args);
                    break;
                    default:
                        sender.sendMessage(ChatColor.RED + "Unknown argument " + method);
                        break;
                case "":
                    openGUI gui = new openGUI();
                    //gui.onCommand(sender,command,label,args);
                    openGUI.getInstance().onCommand(sender,command,label,args);
            }
        }else{
            openGUI gui = new openGUI();
            //gui.onCommand(sender,command,label,args);
            openGUI.getInstance().onCommand(sender,command,label,args);
        }

        return true;
    }
}
