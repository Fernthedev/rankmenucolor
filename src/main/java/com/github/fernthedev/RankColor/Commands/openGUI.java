package com.github.fernthedev.RankColor.Commands;

import com.github.fernthedev.RankColor.Main;
import com.nametagedit.plugin.NametagEdit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class openGUI implements CommandExecutor,Listener {


    private boolean hasotherPlayer;
    private Player otherPlayer;




    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if ((sender instanceof Player)) {
            Player p = (Player) sender;
            hasotherPlayer = false;

            //Main.getInstance().getLogger().info("opened rank menu gui");

            if(args.length > 1) {
                otherPlayer = Bukkit.getPlayer(args[1]);
            }

            String[] groups = Main.getPermissions().getPlayerGroups(null,p);

            String group;

            if(groups.length > 1) {
                group = groups[1];
            }else {
                group = groups[0];
            }

            FileConfiguration rankConfig = Main.getFileHandler().rankConfig;

            if (sender.hasPermission("rankcolor.use") && rankConfig.getConfigurationSection(group).getBoolean("AllowColoring")) {
// Here we create our named help "inventory"
                Inventory namecolor = Bukkit.getServer().createInventory(p, 27, "RankColor");

                //Here you define our item
                ItemStack ref1 = new ItemStack(Material.BARRIER);
                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();

                //lore.add("test");

                metaref1.setLore(lore);
                metaref1.setDisplayName(colorCodeString("&cExit"));
                ref1.setItemMeta(metaref1);

                //COLORS
                //DARK RED 251:14


                ItemStack darkred = new ItemStack(Material.CONCRETE, 1, (byte) 14);
                ItemMeta darkredmeta = darkred.getItemMeta();
                darkredmeta.setDisplayName(colorCodeString("&4DarkRed Name"));
                darkred.setItemMeta(darkredmeta);


                //RED
                ItemStack red = new ItemStack(Material.WOOL, 1, (byte) 14);
                ItemMeta redmeta = red.getItemMeta();
                redmeta.setDisplayName(colorCodeString("&cRed Name"));
                red.setItemMeta(redmeta);


                //ORANGE
                ItemStack orange = new ItemStack(Material.WOOL, 1, (byte) 1);
                ItemMeta orangemeta = orange.getItemMeta();
                orangemeta.setDisplayName(colorCodeString("&6Orange Name"));
                orange.setItemMeta(orangemeta);


                //YELLOW
                ItemStack yellow = new ItemStack(Material.WOOL, 1, (byte) 4);
                ItemMeta yellowmeta = yellow.getItemMeta();
                yellowmeta.setDisplayName(colorCodeString("&eYellow Name"));
                yellow.setItemMeta(yellowmeta);


                //LIME
                ItemStack lime = new ItemStack(Material.WOOL, 1, (byte) 5);
                ItemMeta limemeta = lime.getItemMeta();
                limemeta.setDisplayName(colorCodeString("&aLime Name"));
                lime.setItemMeta(limemeta);


                //GREEN
                ItemStack green = new ItemStack(Material.WOOL, 1, (byte) 13);
                ItemMeta greenmeta = green.getItemMeta();
                greenmeta.setDisplayName(colorCodeString("&2Green Name"));
                green.setItemMeta(greenmeta);


                //LIGHT BLUE
                ItemStack lightblue = new ItemStack(Material.WOOL, 1, (byte) 3);
                ItemMeta lightbluemeta = lime.getItemMeta();
                lightbluemeta.setDisplayName(colorCodeString("&bLightBlue Name"));
                lightblue.setItemMeta(lightbluemeta);


                //BLUE 251:11
                ItemStack blue = new ItemStack(Material.CONCRETE, 1, (byte) 11);
                ItemMeta bluemeta = lime.getItemMeta();
                bluemeta.setDisplayName(colorCodeString("&9Blue Name"));
                blue.setItemMeta(bluemeta);


                //CYAN
                ItemStack cyan = new ItemStack(Material.WOOL, 1, (byte) 9);
                ItemMeta cyanmeta = cyan.getItemMeta();
                cyanmeta.setDisplayName(colorCodeString("&3Cyan Name"));
                cyan.setItemMeta(cyanmeta);


                //DARK BLUE
                ItemStack darkblue = new ItemStack(Material.WOOL, 1, (byte) 11);
                ItemMeta darkbluemeta = darkblue.getItemMeta();
                darkbluemeta.setDisplayName(colorCodeString("&1DarkBlue Name"));
                darkblue.setItemMeta(darkbluemeta);


                //PURPLE
                ItemStack purple = new ItemStack(Material.WOOL, 1, (byte) 10);
                ItemMeta purplemeta = purple.getItemMeta();
                purplemeta.setDisplayName(colorCodeString("&5Purple Name"));
                purple.setItemMeta(purplemeta);


                //MAGENTA
                ItemStack magenta = new ItemStack(Material.WOOL, 1, (byte) 2);
                ItemMeta magentameta = magenta.getItemMeta();
                magentameta.setDisplayName(colorCodeString("&dMagenta Name"));
                magenta.setItemMeta(magentameta);


                //LIGHT GRAY
                ItemStack lightgray = new ItemStack(Material.WOOL, 1, (byte) 8);
                ItemMeta lightgraymeta = lightgray.getItemMeta();
                lightgraymeta.setDisplayName(colorCodeString("&7LightGray Name"));
                lightgray.setItemMeta(lightgraymeta);


                //GRAY
                ItemStack gray = new ItemStack(Material.WOOL, 1, (byte) 7);
                ItemMeta graymeta = gray.getItemMeta();
                graymeta.setDisplayName(colorCodeString("&8Gray Name"));
                gray.setItemMeta(graymeta);


                //BLACK
                ItemStack black = new ItemStack(Material.WOOL, 1, (byte) 15);
                ItemMeta blackmeta = black.getItemMeta();
                blackmeta.setDisplayName(colorCodeString("&0Black Name"));
                black.setItemMeta(blackmeta);


                //WHITE
                ItemStack white = new ItemStack(Material.WOOL, 1, (byte) 0);
                ItemMeta whitemeta = white.getItemMeta();
                whitemeta.setDisplayName(colorCodeString("&fWhite Name"));
                white.setItemMeta(whitemeta);


                int slot = 9;
                namecolor.setItem(1, ref1);

                ConfigurationSection values = rankConfig.getConfigurationSection(group);

                /*for(String key : values.getKeys(true)) {
                    Main.getInstance().getLogger().info(key + " is a value of" + group);
                }*/


                if (values.getBoolean("DarkRed")) {
                    namecolor.setItem(slot, darkred);
                    slot++;
                }

                if (values.getBoolean("Red")) {
                    namecolor.setItem(slot, red);
                    slot++;
                }

                if (values.getBoolean("Orange")) {
                    namecolor.setItem(slot, orange);
                    slot++;
                }

                if (values.getBoolean("Yellow")) {
                    namecolor.setItem(slot, yellow);
                    slot++;
                }

                if (values.getBoolean("Lime")) {
                    namecolor.setItem(slot, lime);
                    slot++;
                }

                if (values.getBoolean("Green")) {
                    namecolor.setItem(slot, green);
                    slot++;
                }

                if (values.getBoolean("LightBlue")) {
                    namecolor.setItem(slot, lightblue);
                    slot++;
                }

                if (values.getBoolean("Blue")) {
                    namecolor.setItem(slot, blue);
                    slot++;
                }

                if (values.getBoolean("Cyan")) {
                    namecolor.setItem(slot, cyan);
                    slot++;
                }

                if (values.getBoolean("DarkBlue")) {
                    namecolor.setItem(slot, darkblue);
                    slot++;
                }

                if (values.getBoolean("Purple")) {
                    namecolor.setItem(slot, purple);
                    slot++;
                }

                if (values.getBoolean("Magenta")) {
                    namecolor.setItem(slot, magenta);
                    slot++;
                }

                if (values.getBoolean("Grey")) {
                    namecolor.setItem(slot, lightgray);
                    slot++;
                }

                if (values.getBoolean("DarkGrey")) {
                    namecolor.setItem(slot, gray);
                    slot++;
                }

                if (values.getBoolean("Black")) {
                    namecolor.setItem(slot, black);
                    slot++;
                }

                if (values.getBoolean("White")) {
                    namecolor.setItem(slot, white);
                }

                //namecolor.setItem(24,ref1);

                //Here opens the inventory
                p.openInventory(namecolor);

            }else{
                sender.sendMessage(ChatColor.RED + "No permission!. Are you sure you have your permissions set correctly?");
            }
        }
        return true;
    }

    private static openGUI instance;

    public openGUI() {
        instance = this;
    }

    static openGUI getInstance() {
        return instance;
    }


    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
       // Main.getInstance().getLogger().info("test");
        Player p = (Player) e.getWhoClicked();
        //p.sendMessage("test");

        if (e.getInventory().getTitle().equalsIgnoreCase("RankColor")) {
            e.setCancelled(true);
            if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType().equals(Material.AIR))) {
                return;
            }
            String currentslot = e.getCurrentItem().getItemMeta().getDisplayName();

            if ((e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(colorCodeString("&cExit")))) {
                p.sendMessage(colorCodeString("&cExited"));
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&4DarkRed Name")))) {
                setName(p,"&4");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if (e.getSlot() == 10 && (currentslot.equalsIgnoreCase(colorCodeString("&cRed Name")))) {
                setName(p,"&c");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&6Orange Name")))) {
                setName(p,"&6");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&eYellow Name")))) {
                setName(p,"&e");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&aLime Name")))) {
                setName(p,"&a");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&2Green Name")))) {
                setName(p,"&2");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&bLightBlue Name")))) {
                setName(p,"&b");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&9Blue Name")))) {
                setName(p,"&9");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&3Cyan Name")))) {
                setName(p,"&3");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&1DarkBlue Name")))) {
                setName(p,"&1");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&5Purple Name")))) {
                setName(p,"&5");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&dMagenta Name")))) {
                setName(p,"&d");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&7LightGray Name")))) {
                setName(p,"&7");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if (currentslot.equalsIgnoreCase(colorCodeString("&8Gray Name"))) {
                setName(p,"&8");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
            if ((currentslot.equalsIgnoreCase(colorCodeString("&0Black Name")))) {
                setName(p,"&0");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }

            if ((currentslot.equalsIgnoreCase(colorCodeString("&fWhite Name")))) {
                setName(p,"&f");
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
            }
        }
    }

    private void setName(Player p,String color) {

        String[] groups = Main.getPermissions().getPlayerGroups(null,p);

        String group;

        if(groups.length > 1) {
            group = groups[1];
        }else {
            group = groups[0];
        }

        String prefix = Main.getFileHandler().rankConfig.getConfigurationSection(group).getString("RankName");

        //Main.getInstance().getLogger().info("Name not changed: " + prefix);
        //Main.getInstance().getLogger().info("New prefix: " + prefix.replaceAll("%color%",color) );

        if(Main.getChat().isEnabled()) {
            if(hasotherPlayer)
                p = otherPlayer;

                Main.getChat().setPlayerPrefix(p,prefix.replaceAll("%color%",color));
            //Main.getChat().setPlayerName(p, Main.getChat().getPlayerName(p));
        }

        if(Main.isIsNTEEnabled()) {


            NametagEdit.getApi().setPrefix(p,prefix.replaceAll("%color%",color));

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"nte player " + p.getName() + " prefix " + prefix.replaceAll("%color%",color));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"nte reload");
        }

        //Main.getInstance().getLogger().info(" the length of prefix is " + Main.getChat().getPlayerPrefix(p).length());
        //Main.getInstance().getLogger().info("A prefix!");

        //p.sendMessage(group + "Name not changed: " + prefix);
        //p.sendMessage("New prefix: " + prefix.replaceAll("%color%",color));
        p.sendMessage(colorCodeString("&aSuccessful. Name is now " + color + "this color"));
    }



    private String colorCodeString(String message) {
        return ChatColor.translateAlternateColorCodes('&',message);
    }
}
