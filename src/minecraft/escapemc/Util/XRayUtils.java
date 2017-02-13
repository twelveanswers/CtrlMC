package escapemc.Util;

import java.util.Collections;
import java.util.Comparator;

import escapemc.module.modules.Xray;
import escapemc.module.modules.Xray;
import net.minecraft.block.Block;

public class XRayUtils
{
	public static void initXRayBlocks()
	{
		Xray.xrayBlocks.add(Block.getBlockFromName("coal_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("iron_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("gold_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("redstone_ore"));
		Xray.xrayBlocks.add(Block.getBlockById(74));// Redstone ore glowing
		Xray.xrayBlocks.add(Block.getBlockFromName("lapis_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("diamond_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("emerald_ore"));
		Xray.xrayBlocks.add(Block.getBlockFromName("quartz_ore"));
		Xray.xrayBlocks.add(Block.getBlockById(8));// Water
		Xray.xrayBlocks.add(Block.getBlockById(9));// Water flowing
		Xray.xrayBlocks.add(Block.getBlockById(10));// Lava
		Xray.xrayBlocks.add(Block.getBlockById(11));// Lava flowing
		Xray.xrayBlocks.add(Block.getBlockFromName("crafting_table"));
		Xray.xrayBlocks.add(Block.getBlockById(61));// Furnace
		Xray.xrayBlocks.add(Block.getBlockById(62));// Furnace on
		Xray.xrayBlocks.add(Block.getBlockFromName("torch"));
		Xray.xrayBlocks.add(Block.getBlockFromName("ladder"));
		Xray.xrayBlocks.add(Block.getBlockFromName("tnt"));
		Xray.xrayBlocks.add(Block.getBlockFromName("coal_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("iron_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("gold_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("diamond_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("emerald_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("redstone_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("lapis_block"));
		Xray.xrayBlocks.add(Block.getBlockFromName("fire"));
		Xray.xrayBlocks.add(Block.getBlockFromName("mob_spawner"));
		Xray.xrayBlocks.add(Block.getBlockFromName("end_portal_frame"));
		Xray.xrayBlocks.add(Block.getBlockFromName("enchanting_table"));
		Xray.xrayBlocks.add(Block.getBlockFromName("bookshelf"));
		Xray.xrayBlocks.add(Block.getBlockFromName("command_block"));
	}
	
	public static boolean isXRayBlock(Block blockToCheck)
	{
		if(Xray.xrayBlocks.contains(blockToCheck))
			return true;
		return false;
	}
}
