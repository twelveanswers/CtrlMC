package escapemc.Command.commands;

import escapemc.Command.Command;
import escapemc.Util.ChatUtil;
import escapemc.module.Mode;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class CommandModeSwitch extends Command {

	@Override
	public String getName() {
		
		return "mode";
		
	}

	@Override
	public String getDescription() {
		
		return "Switches mode (if any) for the designated module.";
		
	}

	@Override
	public String getSyntax() {
		
		return "-mode [MOD]";
		
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {

		try{
			for(Module m : ModuleManager.getModules()) {
			
				if(m.getName().equalsIgnoreCase(args[1])) {
									
					//Killaura
					if(m.getMode() == Mode.Sword) {
						m.setMode(Mode.Axe);
						ChatUtil.SendChatMessage("Changed the mode §aof " + m.getName() + " to Axe.");
						break;

					}
					if(m.getMode() == Mode.Axe) {
						m.setMode(Mode.Sword);
						ChatUtil.SendChatMessage("Changed the mode §aof " + m.getName() + " to Sword.");
						break;
						
					}
					
					//Fly Speed
					if(m.getMode() == Mode.Fast) {
						
						m.setMode(Mode.SuperFast);
						ChatUtil.SendChatMessage("Changed the mode §aof " + m.getName() + " to Super Fast.");
						break;
						
					}
					if(m.getMode() == Mode.Slow) {
						
						m.setMode(Mode.Fast);
						ChatUtil.SendChatMessage("Changed the mode §aof " + m.getName() + " to Fast.");
						break;
						
					}
					if(m.getMode() == Mode.SuperFast) {
						
						m.setMode(Mode.Slow);
						ChatUtil.SendChatMessage("Changed the mode §aof " + m.getName() + " to Slow.");
						break;
						
					}
					
					//Criticals
					if(m.getMode() == Mode.Jump) {
						
						m.setMode(Mode.Packet);
						ChatUtil.SendChatMessage("CHanged the mode §aof " + m.getName() + " to Packet.");
						break;
					}
					if(m.getMode() == Mode.Packet) {
						
						m.setMode(Mode.Jump);
						ChatUtil.SendChatMessage("CHanged the mode §aof " + m.getName() + " to Jump.");
						break;
						
					}
					
					//Zoom
					if(m.getMode() == Mode.Short) {
						
						m.setMode(Mode.Far);
						ChatUtil.SendChatMessage("CHanged the mode §aof " + m.getName() + " to Far.");
						break;
						
					}
					if(m.getMode() == Mode.Far) {
						
						m.setMode(Mode.Short);
						ChatUtil.SendChatMessage("CHanged the mode §aof " + m.getName() + " to Short.");
						break;
						
					}
					
					//If there are no modes for the Module
					if(m.getMode() == null) {
						
						ChatUtil.SendChatMessage("There are no modes for " + m.getName());
						ChatUtil.SendChatMessage("§bThere are §bonly §bmodes §bhave §bkeybinds §bfor:");
						ChatUtil.SendChatMessage("§cKillaura §a(Axe and Sword)");
						ChatUtil.SendChatMessage("§cFly §a(Fast and Slow");
						break;
												
					}
				}
			}
		} catch(Exception e) {
		ChatUtil.SendChatMessage("Fuck, my code didn't work because §aof §ayour §ashitty §acommand.");
		}
	}
}
