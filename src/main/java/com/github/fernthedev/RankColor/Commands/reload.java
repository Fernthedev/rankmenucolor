package com.github.fernthedev.RankColor.Commands;

import com.github.fernthedev.RankColor.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public class reload implements CommandExecutor {

    private static reload instance;

    public reload() {
        instance = this;
    }

    public static reload getInstance() {
        return instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length > 1) {

            String which = args[1];

            switch (which.toLowerCase()){
                case "all":
                    try {
                        Main.getFileHandler().reloadConfig("all");
                        sender.sendMessage(ChatColor.GREEN + "Reloaded config");
                    } catch (IOException | InvalidConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                case "config":
                    try {
                        Main.getFileHandler().reloadConfig("config");
                        sender.sendMessage(ChatColor.GREEN + "Reloaded config");
                    } catch (IOException | InvalidConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ranks":
                    try {
                        Main.getFileHandler().reloadConfig("ranks");
                        sender.sendMessage(ChatColor.GREEN + "Reloaded config");
                    } catch (IOException | InvalidConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                    default:
                        sender.sendMessage(ChatColor.RED + "No such argument, supports: (ranks,config,all)");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "No argument found");
        }

        return true;
    }
}
