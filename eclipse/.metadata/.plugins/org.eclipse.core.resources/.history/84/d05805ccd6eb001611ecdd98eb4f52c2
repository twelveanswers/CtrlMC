package escapemc.Command.commands;

import org.lwjgl.input.Keyboard;

import escapemc.Command.Command;
import escapemc.Util.ChatUtil;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class CommandBind extends Command {

	public CommandBind() {

	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		try {
			if(args[1].equalsIgnoreCase("set")) {
				for(Module m : ModuleManager.getModules()) {
					ChatUtil.SendChatMessage(args[2]);
					if(m.getName().equalsIgnoreCase(args[2])) {
						if(Keyboard.getKeyIndex(args[3].toUpperCase()) == 0) {
							ChatUtil.SendChatMessage("Invalid key.");
						}
						m.setKey(Keyboard.getKeyIndex(args[3].toUpperCase()));
						ChatUtil.SendChatMessage("Bound " + m.getName() + " to " + Keyboard.getKeyName(m.getKey()) + ".");
						break;
					}
				}
			}
			
			if(args[1].equalsIgnoreCase("del")) {
				for(Module m : ModuleManager.getModules()) {
					if(m.getName().equalsIgnoreCase(args[2])) {
						m.setKey(0);
						ChatUtil.SendChatMessage("Removed bind on " + m.getName() + ".");
						break;
					}
				}
			}
		} catch(Exception e) {
			ChatUtil.SendChatMessage("Fuck, my code didn't work because of your shitty command.");
		}
	}
	@Override
	public String getName() {

		return "bind";
	}
	
	@Override
	public String getDescription() {
	
		return "Allows user to change keybind of a module.";
	
	}
	
	@Override
	public String getSyntax() {
	
		return "-bind set [MOD] [Key] | -bind del [MOD]";
	
	}
	
}