package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.client.Minecraft;

public class Criticals extends Module {

	public Criticals() {
	
		super("Criticals", Keyboard.KEY_C, Category.COMBAT);

	}
	
	@Override
	public void onEnable() {

		this.setToggled(true);
	
	}
	
	@Override
	public void onDisable() {

		this.setToggled(false);
	
	}
	
	
	public static void doCrits() {
		
		Minecraft.getMinecraft().thePlayer.setPosition(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY +0.5, Minecraft.getMinecraft().thePlayer.posZ);
		
	}
	

}
