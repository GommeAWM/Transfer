package reyd.nukkit.transfer.command;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import reyd.nukkit.transfer.Transfer;

import java.net.InetSocketAddress;

public class CommandTransfer extends Command {

    private Transfer transfer;
    private int port;

    public CommandTransfer(String name, String description, String usageMessage) {
        super(name, description, usageMessage);
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("cmd.transfer")){
                if(args.length < 4){
                     if(args.length == 1){

                         String help = args[0];

                        if (help.equals("help")){

                            player.sendMessage(Transfer.getConfigTransfer().getHelp());
                            player.sendMessage(Transfer.getConfigTransfer().getHelp1());
                            player.sendMessage(Transfer.getConfigTransfer().getHelp2());
                            player.sendMessage(Transfer.getConfigTransfer().getHelp3());

                        } else {

                            String ip = args[0];

                            try {
                                transfer(player, ip);
                            } catch (NullPointerException ex) {
                                player.sendMessage(Transfer.getConfigTransfer().getNullPointerExceptionMsg());
                            }
                        }
                    } else if (args.length == 2){

                        String ip = args[0];
                        try{

                            int port = Integer.parseInt(args[1]);
                            try {
                                transfer(player, ip, port);
                            } catch (NullPointerException ex){
                                player.sendMessage(Transfer.getConfigTransfer().getNullPointerExceptionMsg());
                            }

                        } catch (NumberFormatException e){
                            player.sendMessage(Transfer.getConfigTransfer().getNullPointerExceptionMsg());
                        } catch (IllegalArgumentException e){
                            player.sendMessage(Transfer.getConfigTransfer().getIllegalArgumentException());
                        }

                    } else if (args.length == 3){

                        String ip = args[0];

                        try{
                            int port = Integer.parseInt(args[1]);
                            Player target = Server.getInstance().getPlayer(args[2]);
                            try {
                                if (target == null){
                                    player.sendMessage(Transfer.getConfigTransfer().getUnknownPlayer());
                                } else {
                                    transfer(target, ip, port);
                                }
                            } catch (NullPointerException ex){
                                player.sendMessage(Transfer.getConfigTransfer().getNullPointerExceptionMsg());
                            }
                        } catch (NumberFormatException e){
                            player.sendMessage(Transfer.getConfigTransfer().getNullPointerExceptionMsg());
                        } catch (IllegalArgumentException e){
                            player.sendMessage(Transfer.getConfigTransfer().getIllegalArgumentException());
                        }
                    } else {
                        player.sendMessage("§a/transfer §6<help>");
                    }
                }
            }

        }

        return true;
    }

    public void transfer(Player player, String ip, int port){
        InetSocketAddress toServer = new InetSocketAddress(ip, port);
        player.transfer(toServer);
    }

    public void transfer(Player player, String ip){
        InetSocketAddress toServer = new InetSocketAddress(ip, 19132);
        player.transfer(toServer);
    }
}
