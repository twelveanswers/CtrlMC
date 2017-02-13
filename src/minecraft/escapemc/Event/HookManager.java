package escapemc.Event;

import escapemc.Gui.TabGui.CtrlMCTabGui;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import escapemc.module.modules.Criticals;
import escapemc.module.modules.Tracers;

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
	
	public static void onRender3D() {
		
		for(Module m : ModuleManager.Modules) {
		
			if(m.isToggled()) {
			
				m.onRender3D();
			
			}
			
		}
		
	}
	
	public static void doCrits() {
		
			Criticals.doCrits();
		
	}
	
}
