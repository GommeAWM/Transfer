package reyd.nukkit.transfer.utils;

import cn.nukkit.utils.Config;
import reyd.nukkit.transfer.Transfer;

import java.io.File;

public class ConfigTransfer {

    private Transfer transfer;
    private File file;
    private Config config;

    public ConfigTransfer(Transfer transfer){
        this.transfer = transfer;
        this.file = new File(transfer.getDataFolder(), "ConfigTR.yml");
        this.config = new Config(this.file, 2);
    }

    public void createDefaultConfig(){
        addDefault("reyd.cmd.msg.NullPointerException", "§cInvalid Address §e- §a/transfer §6<help>");
        addDefault("reyd.cmd.msg.IllegalArgumentException", "Something go wrong §e- §a/transfer §6<help>");
        addDefault("reyd.cmd.msg.unknownplayer", "Unknown Player §e- §a/transfer §6<help>");
        addDefault("reyd.cmd.msg.description", "transfer to a server");
        addDefault("reyd.cmd.msg.help", "§6--- TRANSFER ---");
        addDefault("reyd.cmd.msg.help1", "§a/transfer §6<address> §f: standard port 19132");
        addDefault("reyd.cmd.msg.help2", "§a/transfer §6<address> <port>");
        addDefault("reyd.cmd.msg.help3", "§a/transfer §6<address> <port> <target> §f: transfer a player");
    }

    public String getNullPointerExceptionMsg(){
        return this.config.getString("reyd.cmd.msg.NullPointerException");
    }

    public String getIllegalArgumentException(){
        return this.config.getString("reyd.cmd.msg.IllegalArgumentException");
    }

    public String getUnknownPlayer(){
        return this.config.getString("reyd.cmd.msg.unknownplayer");
    }

    public String getDescription(){
        return this.config.getString("reyd.cmd.msg.description");
    }

    public String getHelp() { return this.config.getString("reyd.cmd.msg.help"); }

    public String getHelp1() { return this.config.getString("reyd.cmd.msg.help1"); }

    public String getHelp2() { return this.config.getString("reyd.cmd.msg.help2"); }

    public String getHelp3() { return this.config.getString("reyd.cmd.msg.help3"); }

    public void addDefault(String path, Object object){
        if(!this.config.exists(path)){
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
