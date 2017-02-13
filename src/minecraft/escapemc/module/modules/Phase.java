package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;

public class Phase extends Module {

	public Phase() {
	
		super("Phase", Keyboard.KEY_J, Category.Player);

	}

	@Override
	public void Tick()
	{
		mc.thePlayer.noClip = true;
		mc.thePlayer.fallDistance = 0;
		mc.thePlayer.onGround = true;
	}

	@Override
	public void onDisable() {

		mc.thePlayer.noClip = false;
	
	}
	
}
