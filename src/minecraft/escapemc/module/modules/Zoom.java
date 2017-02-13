package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Mode;
import escapemc.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class Zoom extends Module {

	public Zoom() {
	
		super("Zoom", Keyboard.KEY_Z, Category.Render);
		this.setMode(Mode.Short);

	}

	private float fov;
	private float mouseSensitivity;
	
	@Override
	public void onEnable() {

		fov = mc.gameSettings.getOptionFloatValue(GameSettings.Options.FOV);
		mouseSensitivity = mc.gameSettings.getOptionFloatValue(GameSettings.Options.SENSITIVITY);
		
	
	}
	
	@Override
	public void Tick() {

		if(this.getMode() == Mode.Short) {
			mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, 30F);
			mc.gameSettings.setOptionFloatValue(GameSettings.Options.SENSITIVITY, 0.005F);
		}else if(this.getMode() == Mode.Far)
			mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, 5F);
			mc.thePlayer.capabilities.setPlayerWalkSpeed(100F);
			mc.gameSettings.setOptionFloatValue(GameSettings.Options.SENSITIVITY, 0.005F);

	}
	
	@Override
	public void onDisable() {

		mc.thePlayer.capabilities.setPlayerWalkSpeed(0.1F);
		mc.gameSettings.setOptionFloatValue(GameSettings.Options.FOV, fov);
		mc.gameSettings.setOptionFloatValue(GameSettings.Options.SENSITIVITY, mouseSensitivity);
	
	}
	
}