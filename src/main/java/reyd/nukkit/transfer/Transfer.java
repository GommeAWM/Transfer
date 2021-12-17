package reyd.nukkit.transfer;

import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import reyd.nukkit.transfer.command.CommandTransfer;
import reyd.nukkit.transfer.utils.ConfigTransfer;

public class Transfer extends PluginBase {

    private static Transfer transfer;
    private static ConfigTransfer configTransfer;

    @Override
    public void onEnable() {
        this.getLogger().info("§fTransfer: §aON");
        registerCommand();

        configTransfer = new ConfigTransfer(this);
        configTransfer.createDefaultConfig();

    }

    @Override
    public void onDisable() {
        this.getLogger().info("§fTransfer: §cOFF");
    }

    public void registerCommand(){
        SimpleCommandMap simpleCommandMap = getServer().getCommandMap();
        simpleCommandMap.register("help", new CommandTransfer("transfer", "transfer to a server", "/transfer"));
    }

    public static ConfigTransfer getConfigTransfer(){
        return configTransfer;
    }

    public static Transfer getInstance(){
        return transfer;
    }

}
