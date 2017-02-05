package escapemc.Command;

import java.util.ArrayList;

import escapemc.Command.commands.CommandBind;
import escapemc.Command.commands.CommandHelp;
import escapemc.Util.ChatUtil;

public class CommandManager {
	
	public static ArrayList<Command> commands = null;
	
	public CommandManager(){
		
		AddCommand(new CommandBind());
		AddCommand(new CommandHelp());
	}
	
	public static void AddCommand(Command c){
		commands.add(c);
	}
	
	public static ArrayList<Command> getCommands(){
		if(commands == null) {
			commands = new ArrayList<Command>();
			new CommandManager();
		}

		return commands;
	}
	
	public static void callCommand(String s){
		String args = s.substring(1, s.length());
		String[] split = args.split(" ");
			for(Command c: getCommands()){
				if(c.getName().equalsIgnoreCase(split[0])){
					try{
						c.onCommand(args, split);
					}catch(Exception e){
						ChatUtil.SendChatMessage("Invalid Command Usage!");
						ChatUtil.SendChatMessage(c.getSyntax());
					}
					return;
				}
			}
			ChatUtil.SendChatMessage("Not Found! Use -help for a list of all commands.");
		}
}