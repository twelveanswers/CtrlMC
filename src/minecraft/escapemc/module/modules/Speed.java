package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;

public class Speed extends Module {

	public Speed() {
		super("speed", Keyboard.KEY_Z, Category.MOVEMENT);
	}

	@Override
	public void Tick() {

		if(mc.thePlayer.onGround) {
			
			mc.thePlayer.jump();
			
		}else{
			
			mc.timer.timerSpeed = 1.2F;
			mc.thePlayer.motionY = -0.5;
			
		}
	
	}
	
	
}
