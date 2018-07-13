package com.github.fernthedev.RankColor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileHandler {


    private FileConfiguration config = Main.getInstance().getConfig();




    private File configfile = new File(Main.getInstance().getDataFolder(), "config.yml");
    private File rankFile =  new File(Main.getInstance().getDataFolder(),"ranks.yml");


    public FileConfiguration rankConfig = YamlConfiguration.loadConfiguration(rankFile);

    public static List<String> ranks = new ArrayList<>();

    /**
     *
     * @param which Which config to reload, such as (config,all)
     */
    public void reloadConfig(String which) throws IOException, InvalidConfigurationException {
        if(which.equals("all") || which.equals("config")) {
            if(configfile.exists()) {
                config.load(new File(Main.getInstance().getDataFolder(),"config.yml"));
            }else{
                //createFile();
                createConfig();
                setDefault();
            }
        }

        if(which.equalsIgnoreCase("all") || which.equalsIgnoreCase("ranks")) {
            if(rankFile.exists()) {
                //config.load(new File(Main.getInstance().getDataFolder(),"ranks.yml"));



                setRankConfig();
                rankConfig.save(rankFile);
                rankConfig.load(rankFile);
            }else{
                createFile();
            }
        }
    }


    public void createFile(){
        File file = new File(Main.getInstance().getDataFolder(), "ranks.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void setDefault() {
        //FileConfiguration config = FernCommands.getInstance().getConfig();
        //Main.getInstance().getConfig().set("nodmgepearl",false);
        config.set("CostMoney",false);
        config.set("AmountCost",0);

        config.set("NameColor",true);
        Main.getInstance().saveConfig();
    }


    public void setRankConfig() {
        if (Main.getPermissions() != null) {
            Collections.addAll(ranks, Main.getPermissions().getGroups());
        }
        try {
            rankConfig.load(rankFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < ranks.toArray().length; i++) {
            String group = ranks.get(i);
            if (Main.getChat().getGroupPrefix(Bukkit.getServer().getWorld("world"), group) != null) {
                Main.getInstance().getLogger().info(ChatColor.GREEN + group + " is a grooooop");
                //List<String> configValues = rankConfig.getStringList(group);

                ConfigurationSection section = rankConfig.getConfigurationSection(group);

                if (section == null) {
                    rankConfig.createSection(group);
                    section = rankConfig.getConfigurationSection(group);
                    if (section.getKeys(true) == null || section.getKeys(true).isEmpty()) {
                        section.set("Permission", "rankcolor.group." + group);
                        section.set("AllowColoring", true);
                        section.set("RankName", Main.getChat().getGroupPrefix(Bukkit.getServer().getWorld("world"), group));
                        section.set("NameTagName", "");
                        section.set("White", true);
                        section.set("Red", true);
                        section.set("DarkRed", true);
                        section.set("Orange", true);
                        section.set("Yellow", true);
                        section.set("Lime", true);
                        section.set("Green", true);
                        section.set("LightBlue", true);
                        section.set("Cyan", true);
                        section.set("Blue", true);
                        section.set("DarkBlue", true);
                        section.set("Purple", true);
                        section.set("Magenta", true);
                        section.set("Grey", true);
                        section.set("DarkGrey", true);
                        section.set("Black", true);
                        try {
                            rankConfig.save(rankFile);
                            rankConfig.load(rankFile);
                        } catch (IOException | InvalidConfigurationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public void saveConfig() {
        try {
            rankConfig.save(rankFile);
            config.save(configfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createConfig() {
        try {
            if (!Main.getInstance().getDataFolder().exists()) {
                Main.getInstance().getDataFolder().mkdirs();
            }
            File file = new File(Main.getInstance().getDataFolder(), "config.yml");
            if (!file.exists()) {
                Main.getInstance().getLogger().info("Config.yml not found, creating!");
                Main.getInstance().saveDefaultConfig();
            } else {
                Main.getInstance().getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
