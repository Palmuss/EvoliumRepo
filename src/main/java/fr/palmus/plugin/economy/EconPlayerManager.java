package fr.palmus.plugin.economy;

import fr.palmus.plugin.EvoPlugin;
import fr.palmus.plugin.listeners.custom.PlayerMoneyChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EconPlayerManager {

    Player player;

    Economy econ;

    int money;

    int bank;

    public EconPlayerManager(Player pl, Economy economy) {
        this.player = pl;
        this.econ = economy;
        this.bank = econ.main.cfg.getInt(player.getUniqueId() + ".bank");;
        this.money = econ.main.cfg.getInt(player.getUniqueId() + ".money");;
    }

    public void addMoney(int money){
        this.money += money;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.MONEY, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void substractMoney(int money){
        this.money -= money;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.MONEY, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void setMoney(int money){
        this.money = money;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.MONEY, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void addBank(int money){
        this.money += money;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.BANK, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void substractBank(int money){
        this.money -= money;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.BANK, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void setBank(int bank) {
        this.bank = bank;
        PlayerMoneyChangeEvent event = new PlayerMoneyChangeEvent(player, money, bank, TransferType.BANK, econ.main);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public void saveMoney(){
        econ.main.cfg.set(player.getDisplayName() + ".money", money);
    }

    public Player getPlayer() {
        return player;
    }

    public int getMoney() {
        return money;
    }

    public int getBank() {
        return bank;
    }

    public enum TransferType{
        BANK, MONEY;
    }
}
