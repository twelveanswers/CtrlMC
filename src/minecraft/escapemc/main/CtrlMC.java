package escapemc.main;

import org.lwjgl.opengl.Display;

import escapemc.Command.CommandManager;
import escapemc.module.ModuleManager;

public class CtrlMC {
	
	private final String CLIENT_NAME = "CtrlMC";
	
	private static CtrlMC CtrlMC = new CtrlMC();
	
	
	public static void initClient() {
		
		System.out.println("Loading CTRLMC Client...");
		Display.setTitle("CTRLMC Client 1.0");
		ModuleManager.registerModules();
		CommandManager.RegisterCommands();
		
	}
	
}