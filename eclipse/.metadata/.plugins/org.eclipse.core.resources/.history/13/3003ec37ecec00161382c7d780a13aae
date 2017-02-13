package escapemc.Event;

import escapemc.Gui.TabGui.CtrlMCTabGui;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class HookManager {

	public static float partialTicks;
	
	public static void onKeyPress(int i) {
        
		CtrlMCTabGui.onKeyPress(i);
		
		for(Module m : ModuleManager.Modules) {
			
			if(i == m.getKey()) {
				
				m.toggle();
				
			}
			
		}

	}
		
		
	public static void onRender2D() {
		
		CtrlMCTabGui.onRender2D();
		
	}
	
}
