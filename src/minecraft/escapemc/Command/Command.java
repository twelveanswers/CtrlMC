package escapemc.Command;

import escapemc.Util.ChatUtil;

public abstract class Command {
	
	public abstract String getName();
	public abstract String getDescription();
	public abstract String getSyntax();
	public abstract void onCommand(String command, String[] args) throws Exception;

}