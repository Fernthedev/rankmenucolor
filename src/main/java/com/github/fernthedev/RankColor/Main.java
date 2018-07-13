package com.github.fernthedev.RankColor;

import com.github.fernthedev.RankColor.Commands.commandMain;
import com.github.fernthedev.RankColor.Commands.openGUI;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class Main extends JavaPlugin {

    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;
    private FileConfiguration config;

    private static boolean isNTE;

    private static FileHandler fileHandler;
    private static Main instance;

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.GREEN + "Enabling RankMenu Color");
        instance = this;
        config = this.getConfig();


        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupPermissions();
        setupChat();

        isNTE = this.getServer().getPluginManager().isPluginEnabled("NametagEdit");
        if(isNTE)
            getLogger().info("HOOKED NAMETAGEDIT API");

        getLogger().info("HOOKED VAULT ECONOMY PERMISSIONS AND CHAT");
        fileHandler = new FileHandler();
        try {
            fileHandler.reloadConfig("all");
        } catch (IOException e) {
            getLogger().warning("Unable to load config");
        } catch (InvalidConfigurationException e) {
            getLogger().warning("Invalid Config");
        }
        registerListeners();


    }
    @Override
    public void onDisable() {
        getLogger().info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
        getLogger().info(ChatColor.RED + "Disabling RankMenu Color");
        chat = null;
        perms = null;
        econ = null;
        instance = null;
        this.saveDefaultConfig();
        fileHandler.saveConfig();
        fileHandler = null;
        config = null;
    }








    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }

    public static FileHandler getFileHandler() {
        return fileHandler;
    }







    public static boolean useCost;
    public static double amountCost;

    public static Main getInstance() {
        return instance;
    }

    public static boolean isIsNTEEnabled() {
        return isNTE;
    }


    private void registerListeners() {
        try {
            fileHandler.reloadConfig("all");
        } catch (IOException e) {
            getLogger().warning("Unable to load config");
        } catch (InvalidConfigurationException e) {
            getLogger().warning("Invalid Config");
        }

        if(!config.getBoolean("NameColor")) {
            isNTE = false;
        }

        if(config.getBoolean("CostMoney")) {
            useCost = true;
            amountCost = config.getDouble("AmountCost");
        }

        this.getCommand("rankcolor").setExecutor(new commandMain());
        Bukkit.getPluginManager().registerEvents(new openGUI(),this);

    }
}
