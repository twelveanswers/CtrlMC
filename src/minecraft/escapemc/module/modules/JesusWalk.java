package escapemc.module.modules;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class JesusWalk extends Module {

	public JesusWalk() {

		super("JesusWalk", 0, Category.Movement);
	
	}

	private int ticksOutOfWater = 10;
	public int time = 0;
	public final int delay = 4;
	
	@Override
	public void Tick()
	{
		if(!mc.gameSettings.keyBindSneak.pressed)
			if(mc.thePlayer.isInWater())
			{
				mc.thePlayer.motionY = 0.11;
				ticksOutOfWater = 0;
			}else
			{
				if(ticksOutOfWater == 0)
					mc.thePlayer.motionY = 0.30;
				else if(ticksOutOfWater == 1)
					mc.thePlayer.motionY = 0;
				
				ticksOutOfWater++;
			}
	}

	@SuppressWarnings("deprecation")
	public boolean isOverWater()
	{
		final EntityPlayerSP thePlayer = mc.thePlayer;
		
		boolean isOnWater = false;
		boolean isOnSolid = false;
		
		for(final Object o : mc.theWorld.getCollisionBoxes(thePlayer,
			thePlayer.getEntityBoundingBox().offset(0, -1.0D, 0).expand(-0.001,
				0, -0.001)))
		{
			final AxisAlignedBB bbox = (AxisAlignedBB)o;
			final BlockPos blockPos =
				new BlockPos(bbox.maxX - (bbox.maxX - bbox.minX) / 2.0,
					bbox.maxY - (bbox.maxY - bbox.minY) / 2.0,
					bbox.maxZ - (bbox.maxZ - bbox.minZ) / 2.0);
			final Block block = mc.theWorld.getBlockState(blockPos).getBlock();
			if(block.getMaterial(null) == Material.WATER
				|| block.getMaterial(null) == Material.LAVA)
				isOnWater = true;
			else if(block.getMaterial(null) != Material.AIR)
				isOnSolid = true;
		}
		
		return isOnWater && !isOnSolid;
	}
	
	public boolean shouldBeSolid()
	{
		return isToggled() && !(mc.thePlayer == null)
			&& !(mc.thePlayer.fallDistance > 3)
			&& !mc.gameSettings.keyBindSneak.pressed
			&& !mc.thePlayer.isInWater();
	}

	
}
