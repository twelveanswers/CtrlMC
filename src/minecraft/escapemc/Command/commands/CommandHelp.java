package escapemc.Command.commands;

import escapemc.Command.Command;
import escapemc.Command.CommandManager;
import escapemc.Util.ChatUtil;

public class CommandHelp extends Command {

	public CommandHelp() {
		
	}	
		
	@Override
	public String getName() {

		return "help";

	}

	@Override
	public String getDescription() {

		return "Lists all CtrlMC Commands.";
	
	}

	@Override
	public String getSyntax() {
	
		return "-help";

	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		
		for(Command c : CommandManager.getCommands()) {
			
			ChatUtil.SendChatMessage(c.getName() + ": "+ c.getDescription());
			
		}
		
	}
	
}
