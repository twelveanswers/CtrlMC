package escapemc.Event;

import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class EventHandler {

	public static void onEvent(Event e) {
		
		for(Module m : ModuleManager.Modules) {
			
			if(m.isToggled()) {
				
				m.Event(e);
				
			}
			
		}
		
	}
	
}
