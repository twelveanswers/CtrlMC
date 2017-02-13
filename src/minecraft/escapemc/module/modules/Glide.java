package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.block.material.Material;

public class Glide extends Module {

	public Glide() {
	
		super("Glide", 0, Category.Movement);

	}
	
	@Override
	public void Tick()
	{
		if(mc.thePlayer.motionY < 0 && mc.thePlayer.isAirBorne
			&& !mc.thePlayer.isInWater() && !mc.thePlayer.isOnLadder()
			&& !mc.thePlayer.isInsideOfMaterial(Material.LAVA))
		{
			mc.thePlayer.motionY = -0.125f;
			mc.thePlayer.jumpMovementFactor *= 1.21337f;
		}
	}
}
