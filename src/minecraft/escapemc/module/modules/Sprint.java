package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.network.play.client.CPacketPlayer;

public class Sprint extends Module {

	public Sprint() {
	
		super("NoFall", Keyboard.KEY_N, Category.MOVEMENT);

	}

	@Override
	public void onEnable() {

		mc.thePlayer.setSprinting(true);

	}
		
	@Override
	public void onDisable() {
		
		mc.thePlayer.setSprinting(false);
		
	}	
	
}