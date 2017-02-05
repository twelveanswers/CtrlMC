package escapemc.Gui.Ingame;

import escapemc.main.Reference;
import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;

public class CtrlMCOverlay {

	static Minecraft mc = Minecraft.getMinecraft();
		
	
	public static void drawOverlay() {
		
		mc.fontRendererObj.drawString("�3Ctrl�bMC �5"+Reference.VERSION, 0, 0, 0xffffffff);
		/*mc.fontRendererObj.drawString("�1Fly �d - Y", 0, 9, 0xffffffff);
		mc.fontRendererObj.drawString("�1Fullbright �d -L", 0, 18, 0xffffffff);
		mc.fontRendererObj.drawString("�1Sprint �d - N", 0, 27, 0xffffffff);
		mc.fontRendererObj.drawString("�1Speed �d - N", 0, 36, 0xffffffff);
		mc.fontRendererObj.drawString("�1Killaura �d - K", 0, 45, 0xffffffff);
		mc.fontRendererObj.drawString("�1Criticals �d - C", 0, 54, 0xffffffff);
		DrawModList();*/
		
	}
	
	private static void DrawModList() {
		
		int y = 70;
		for(Module m : ModuleManager.Modules) {
			
			if(m.isToggled() && m.getCategory() != Category.Hidden) {
				
				mc.fontRendererObj.drawString("�c"+m.getName(), 1, y, 0xffffffff);
				y += 9;
				
			}
			
		}
		
	}
	
	
	
}
