package escapemc.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class ChatUtil {

	
	public static void SendChatMessage(String message) {
		
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new TextComponentString("§3CtrlMc: §a" + message));
		
	}
	
}
