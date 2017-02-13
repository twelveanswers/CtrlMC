package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.Event.events.EventPreMotion;
import escapemc.module.Category;
import escapemc.module.Module;

public class Fly extends Module{

	public Fly() {
		super("Fly", Keyboard.KEY_Y, Category.Movement);
	}

	double startY;
	
	@Override
	public void Tick() {
			
		mc.thePlayer.capabilities.isFlying = true;
		this.setToggled(true);

	}	
	
	@Override
	public void onEnable() {
		
		startY = mc.thePlayer.posY;
		
	}
	
	@Override
	public void onDisable() {
		
		mc.thePlayer.capabilities.isFlying = false;
		
	}
	
	@Override
	public void Event(escapemc.Event.Event e) {
		
		if(e instanceof EventPreMotion) {
			
			((EventPreMotion) e).onGround = true;
			
		}
		
	}
	
		
}		

