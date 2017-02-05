package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;

public class Fullbright extends Module{

	public Fullbright() {
		super("Fullbright", Keyboard.KEY_L, Category.Render);
	}
	
	@Override
	public void Tick() {
		
		mc.gameSettings.gammaSetting = 100F;
		this.setToggled(true);
		
	}
	
	@Override
	public void onDisable() {
	
		mc.gameSettings.gammaSetting = 0F;
		this.setToggled(false);
		
	}
}